package com.example.easypc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class pc {
    private String part;
    private String price;
    private String brand;
    private String description;
    private String image;
    private String model;
}