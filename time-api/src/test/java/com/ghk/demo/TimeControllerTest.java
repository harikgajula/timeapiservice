package com.ghk.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ghk.demo.controller.TimeController;
import com.ghk.demo.dto.TimeResponse;
import com.ghk.demo.service.TimeService;
import com.ghk.demo.utils.TimezoneUtils;

@SpringBootTest
class TimeControllerTest {
	
	private TimeController timeController;
	private TimeService timeService;
	
	@Before
	public void setUp() {
		timeService = mock(TimeService.class);
		timeController = new TimeController();
		//timeController.setTimeService(timeService);
		//timeController.setInvalidTimezoneErrorMessage("Invalid timezone provided");
		//timeController.setNotUSTimezoneErrorMessage("Non-US timezone provided");
	}
	
	@Test
	public void testGetUSTimeWithValidTimezone() {
		String timezone = "America/New_York";
		TimeResponse expectedResponse = new TimeResponse("2021-04-17 01:00 PM", "EDT");
		when(timeService.getFormattedUSTimeByCallingAPI(timezone)).thenReturn(expectedResponse);
		
		ResponseEntity<TimeResponse> response = timeController.getUSTime(timezone);
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(expectedResponse, response.getBody());
	}
	
	@Test
	public void testGetUSTimeWithInvalidTimezone() {
		String invalidTimezone = "Invalid/Timezone";
		ResponseEntity<TimeResponse> response = timeController.getUSTime(invalidTimezone);
		System.out.println("--Response--"+response);
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		assertEquals("Invalid timezone provided", response.getBody().getStatus());
	}
	
	@Test
	public void testGetUSTimeWithNonUSTimezone() {
		String nonUSTimezone = "Asia/Kolkata";
		ResponseEntity<TimeResponse> response = timeController.getUSTime(nonUSTimezone);
		
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		assertEquals("Non-US timezone provided", response.getBody().getStatus());
		assertTrue(TimezoneUtils.getUSTimezones().stream().noneMatch(tz -> tz.equals(nonUSTimezone)));
	}
}
