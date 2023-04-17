package com.ghk.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TimeResponse {

	@JsonProperty("datetime")
	private final String datetime;
	
    @JsonProperty("timezone_abbreviation")
    private final String timezoneAbbreviation;
    
    @JsonProperty("status")
    private final String status;

    public TimeResponse(String datetime, String timezoneAbbreviation) {
        this.datetime = datetime;
        this.timezoneAbbreviation = timezoneAbbreviation;
        this.status = "Success";
    }

    public TimeResponse(String status) {
        this.datetime = "Invalid Date";
        this.timezoneAbbreviation = "Invalid Timezone";
        this.status = "Error";
    }

    public String getDatetime() {
        return datetime;
    }

    public String getTimezoneAbbreviation() {
        return timezoneAbbreviation;
    }

    public String getStatus() {
        return status;
    }
}
