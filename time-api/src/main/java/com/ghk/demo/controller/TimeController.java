package com.ghk.demo.controller;

import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ghk.demo.dto.TimeResponse;
import com.ghk.demo.service.TimeService;
import com.ghk.demo.utils.TimezoneUtils;

@RestController
@RequestMapping("/api")
public class TimeController {
	
	@Autowired
	private TimeService timeService;
	
	@Value("${invalid.timezone.error.message}")
	private String invalidTimezoneErrorMessage;
	
	@Value("${notus.timezone.error.message}")
	private String NotUSTimezoneErrorMessage;

	@GetMapping("/time")
	public ResponseEntity<TimeResponse> getUSTime(@RequestParam String timezone) {
		
		ZoneId zoneId;
		try {
			zoneId = ZoneId.of(timezone);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new TimeResponse(invalidTimezoneErrorMessage));
		}
		if (!TimezoneUtils.getUSTimezones().contains(zoneId.getId())) {
			return ResponseEntity.badRequest().body(new TimeResponse(NotUSTimezoneErrorMessage));
		}
		TimeResponse timeResponse = timeService.getFormattedUSTimeByCallingAPI(zoneId.getId());
				
		return ResponseEntity.ok(timeResponse);
	}
	
	
}
