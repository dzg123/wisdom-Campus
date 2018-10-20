package com.dzg.springarcgis.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    private Integer id;
    private Integer userId;
    private String coordinate;
    private Date time;
    private String userIp;
    private Integer state;

}
