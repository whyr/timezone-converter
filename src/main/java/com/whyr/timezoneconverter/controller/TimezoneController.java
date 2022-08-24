package com.whyr.timezoneconverter.controller;

import com.whyr.timezoneconverter.model.TimezoneRqDto;
import com.whyr.timezoneconverter.model.TimezoneRsDto;
import com.whyr.timezoneconverter.service.TimezoneService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/timezone-converter")
@Tag(name = "Timezone Converter")
public class TimezoneController {

    @Autowired
    private TimezoneService timezoneService;

    @GetMapping("/")
    public ResponseEntity<TimezoneRsDto> convert(
            @Parameter(name = "date", example = "2021-10-07", required = true) @RequestParam(name = "date") String date,
            @Parameter(name = "time", example = "08:30", required = true) @RequestParam(name = "time") String time,
            @Parameter(name = "timezoneFrom", example = "Europe/Madrid", required = true) @RequestParam(name = "timezoneFrom") String timezoneFrom,
            @Parameter(name = "timezoneTo", example = "America/New_York", required = true) @RequestParam(name = "timezoneTo") String timezoneTo
    ) {

        return new ResponseEntity<>(timezoneService.convertTimezone(date, time, timezoneFrom, timezoneTo),
                HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<TimezoneRsDto> convert(
            @Parameter(name = "timezoneRq", required = true) @RequestBody TimezoneRqDto request
    ) {

        return new ResponseEntity<>(
                timezoneService.convertTimezone(request.getDate(), request.getTime(), request.getTimezoneFrom(),
                        request.getTimezoneTo()), HttpStatus.OK);
    }

}
