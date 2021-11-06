package com.whyr.timezoneconverter.service;

import com.whyr.timezoneconverter.model.TimezoneRsDto;
import com.whyr.timezoneconverter.service.exceptions.BadRequestException;
import org.springframework.stereotype.Service;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class TimezoneServiceImpl implements TimezoneService {

    private static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm";

    @Override
    public TimezoneRsDto convertTimezone(String date, String time, String timezoneFrom, String timezoneTo) {

        try {

            LocalDateTime ldtFrom = LocalDateTime.parse(date + " " + time,
                    DateTimeFormatter.ofPattern(DATETIME_FORMAT));
            ZoneId zFrom = ZoneId.of(timezoneFrom);
            ZonedDateTime zdtFrom = ldtFrom.atZone(zFrom);

            ZoneId zTo = ZoneId.of(timezoneTo);
            ZonedDateTime zdtTo = zdtFrom.withZoneSameInstant(zTo);

            TimezoneRsDto timezoneRsDto = new TimezoneRsDto();
            timezoneRsDto.setTimezone(zdtTo.getZone().toString());
            timezoneRsDto.setDate(zdtTo.toString().substring(0, zdtTo.toString().indexOf("T")));
            timezoneRsDto.setTime(
                    zdtTo.toString().substring(zdtTo.toString().indexOf("T") + 1, zdtTo.toString().indexOf("T") + 6));

            return timezoneRsDto;

        } catch (DateTimeException dateTimeException) {

            throw new BadRequestException(dateTimeException.getMessage());
        }
    }
}
