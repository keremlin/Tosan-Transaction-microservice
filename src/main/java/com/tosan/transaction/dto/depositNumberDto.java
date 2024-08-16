package com.tosan.transaction.dto;



import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class depositNumberDto {
    
    @Min(10000)
    @Max(99999)
    int depositNumber;

}
