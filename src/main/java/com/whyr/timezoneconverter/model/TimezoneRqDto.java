package com.whyr.timezoneconverter.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description = "Timezone Request")
public class TimezoneRqDto {

    @ApiModelProperty(example = "2021-10-07")
    private String date;

    @ApiModelProperty(example = "08:30")
    private String time;

    @ApiModelProperty(example = "Europe/Madrid")
    private String timezoneFrom;

    @ApiModelProperty(example = "America/New_York")
    private String timezoneTo;

}
