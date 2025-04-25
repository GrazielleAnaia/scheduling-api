package com.grazielleanaia.scheduling_api.infrastructure.client;


import com.grazielleanaia.scheduling_api.business.dto.CustomerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "customer", url = "${customer.url}")

public interface CustomerClient {

    @GetMapping
    CustomerDTO findCustomerByEmail(@RequestParam("email") String email,
                                    @RequestHeader("Authorization") String token);


}
