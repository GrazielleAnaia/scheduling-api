package com.grazielleanaia.scheduling_api.business.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CustomerDTO {

    private String email;

    private String password;

}
