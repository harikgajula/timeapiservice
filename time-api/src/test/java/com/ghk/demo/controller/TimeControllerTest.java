package com.ghk.demo.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ghk.demo.dto.TimeResponse;
import com.ghk.demo.service.TimeServiceImpl;
import com.ghk.demo.utils.TimezoneUtils;

@SpringBootTest
public class TimeControllerTest {
	
	@InjectMocks
	TimeServiceImpl timeService;
	
	TimeController timeController;
	
	@Before
	public void setUp() {
		timeController = new TimeController();
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
