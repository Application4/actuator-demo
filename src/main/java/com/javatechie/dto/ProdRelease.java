package com.javatechie.dto;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProdRelease {

    private String crq;
    private String rolloutDate;
    private List<String> features;

}
