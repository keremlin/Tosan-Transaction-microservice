package com.tosan.transaction.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.Data;

@Data
public class depositNumberDto {
    
    @Min(10000)
    @Max(99999)
    int depositNumber;

}
