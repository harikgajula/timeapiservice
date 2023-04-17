package com.ghk.demo.service;

import com.ghk.demo.dto.TimeResponse;

public interface TimeService {
	
	TimeResponse getFormattedUSTimeByCallingAPI(String zoneId);
	
}
