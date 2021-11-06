package com.whyr.timezoneconverter.controller;

import com.whyr.timezoneconverter.model.TimezoneRqDto;
import com.whyr.timezoneconverter.model.TimezoneRsDto;
import com.whyr.timezoneconverter.service.TimezoneService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/timezone-converter")
@Api(tags = "Timezone Converter")
public class TimezoneController {

    @Autowired
    private TimezoneService timezoneService;

    @GetMapping("/")
    public ResponseEntity<TimezoneRsDto> convert(
            @ApiParam(value = "date", example = "2021-10-07", required = true) @RequestParam(name = "date") String date,
            @ApiParam(value = "time", example = "08:30", required = true) @RequestParam(name = "time") String time,
            @ApiParam(value = "timezoneFrom", example = "Europe/Madrid", required = true) @RequestParam(name = "timezoneFrom") String timezoneFrom,
            @ApiParam(value = "timezoneTo", example = "America/New_York", required = true) @RequestParam(name = "timezoneTo") String timezoneTo
    ) {

        return new ResponseEntity<>(timezoneService.convertTimezone(date, time, timezoneFrom, timezoneTo),
                HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<TimezoneRsDto> convert(
            @ApiParam(value = "timezoneRq", required = true) @RequestBody TimezoneRqDto request
    ) {

        return new ResponseEntity<>(
                timezoneService.convertTimezone(request.getDate(), request.getTime(), request.getTimezoneFrom(),
                        request.getTimezoneTo()), HttpStatus.OK);
    }

}
