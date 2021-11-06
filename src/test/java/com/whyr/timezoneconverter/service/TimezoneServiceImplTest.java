package com.whyr.timezoneconverter.service;

import com.whyr.timezoneconverter.model.TimezoneRsDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TimezoneServiceImplTest {

    private final TimezoneService timezoneService = new TimezoneServiceImpl();

    @Test
    void timezoneConvertTest() {

        String date = "2021-07-10";
        String time = "08:30:00";
        String timezoneFrom = "Europe/Madrid";
        String timezoneTo = "America/New_York";

        TimezoneRsDto timezoneRsDto = timezoneService.convertTimezone(date, time, timezoneFrom, timezoneTo);

        Assertions.assertEquals("2021-07-10", timezoneRsDto.getDate());
        Assertions.assertEquals("02:30:00", timezoneRsDto.getTime());
        Assertions.assertEquals("America/New_York", timezoneRsDto.getTimezone());

    }

}