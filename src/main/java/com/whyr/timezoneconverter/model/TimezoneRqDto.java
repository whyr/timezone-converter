package com.whyr.timezoneconverter.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimezoneRqDto {

    @Schema(example = "2025-10-07")
    private String date;

    @Schema(example = "08:30")
    private String time;

    @Schema(example = "Europe/Madrid")
    private String timezoneFrom;

    @Schema(example = "America/New_York")
    private String timezoneTo;

}
