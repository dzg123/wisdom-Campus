package com.dzg.springarcgis.domain;

import lombok.*;

import javax.validation.constraints.NotNull;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String phone;
    private int state;
    private int role;
    private String nickname;
}
