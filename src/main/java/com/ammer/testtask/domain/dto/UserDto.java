package com.ammer.testtask.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("Bank user")
public class UserDto {
    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "name", required = true)
    private String name;
}
