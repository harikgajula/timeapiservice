package com.ghk.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WorldTimeResponse {

	private String datetime;
	
    @JsonProperty("abbreviation")
    private String timezoneAbbreviation;

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getTimezoneAbbreviation() {
        return timezoneAbbreviation;
    }

	public void setTimezoneAbbreviation(String timezoneAbbreviation) {
		this.timezoneAbbreviation = timezoneAbbreviation;
	}
    
}
