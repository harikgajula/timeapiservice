package com.ghk.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ghk.demo.dto.TimeResponse;
import com.ghk.demo.dto.WorldTimeResponse;

@Service
public class TimeServiceImpl implements TimeService {

	private final RestTemplate restTemplate = new RestTemplate();
	
	@Value("${timeapi.url}")
	private String apiUrl;

	@Override
	public TimeResponse getFormattedUSTimeByCallingAPI(String zoneId) {
		
		WorldTimeResponse response = restTemplate.getForObject(apiUrl + zoneId, WorldTimeResponse.class);
		
		return new TimeResponse(response.getDatetime(), response.getTimezoneAbbreviation());
	}
	
}
