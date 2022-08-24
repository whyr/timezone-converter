package com.whyr.timezoneconverter.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimezoneRsDto {

    @Schema(example = "2021-10-07")
    private String date;

    @Schema(example = "02:30")
    private String time;

    @Schema(example = "America/New_York")
    private String timezone;

}
