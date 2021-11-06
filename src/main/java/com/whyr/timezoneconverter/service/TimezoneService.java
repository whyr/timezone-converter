package com.whyr.timezoneconverter.service;

import com.whyr.timezoneconverter.model.TimezoneRsDto;

public interface TimezoneService {

    TimezoneRsDto convertTimezone(String date, String time, String timezoneFrom, String timezoneTo);

}
