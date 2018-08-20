package com.spring.cloud.advertising.service;

import com.spring.cloud.advertising.service.impl.SchedualServiceAdminIndexImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "SERVICE-ADVERTISING",fallback = SchedualServiceAdminIndexImpl.class)
public interface SchedualServiceAdminIndex {

    @RequestMapping(value ={"/admin/index"})
    String index();

    @RequestMapping(value = {"/admin/welcome"})
    String welcome();
}
