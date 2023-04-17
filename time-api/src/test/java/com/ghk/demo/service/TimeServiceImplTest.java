package com.ghk.demo.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.ghk.demo.dto.TimeResponse;
import com.ghk.demo.dto.WorldTimeResponse;
import com.ghk.demo.service.TimeServiceImpl;

@SpringBootTest
public class TimeServiceImplTest {
	
	@Mock
	private RestTemplate restTemplate;

	TimeServiceImpl timeService;

	@Before
	public void setUp() {
		restTemplate = mock(RestTemplate.class);
		timeService = new TimeServiceImpl();
	}

	@Test
	public void testGetFormattedUSTimeByCallingAPI() {
		String zoneId = "America/New_York";
		WorldTimeResponse worldTimeResponse = new WorldTimeResponse();
		worldTimeResponse.setDatetime("2021-04-17T12:00:00.000000-04:00");
		worldTimeResponse.setTimezoneAbbreviation("EDT");
		when(restTemplate.getForObject("http://worldtimeapi.org/api/timezone/America/New_York", WorldTimeResponse.class))
				.thenReturn(worldTimeResponse);

		TimeResponse timeResponse = timeService.getFormattedUSTimeByCallingAPI(zoneId);
		assertEquals("2021-04-17 12:00 PM", timeResponse.getDatetime());
		assertEquals("EDT", timeResponse.getTimezoneAbbreviation());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetFormattedUSTimeByCallingAPIWithInvalidZoneId() {
	    String invalidZoneId = "Invalid/Zone";
	    when(restTemplate.getForObject("http://worldtimeapi.org/api/timezone/" + invalidZoneId, WorldTimeResponse.class))
	            .thenThrow(new IllegalArgumentException("Invalid time zone ID"));

	    timeService.getFormattedUSTimeByCallingAPI(invalidZoneId);
	}
}
