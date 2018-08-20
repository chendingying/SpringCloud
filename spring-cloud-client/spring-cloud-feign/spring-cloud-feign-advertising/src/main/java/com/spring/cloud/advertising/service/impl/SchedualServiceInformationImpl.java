package com.spring.cloud.advertising.service.impl;

import com.spring.cloud.advertising.service.SchedualServiceInformation;
import org.springframework.web.bind.annotation.PathVariable;

public class SchedualServiceInformationImpl implements SchedualServiceInformation {
    @Override
    public String index() {
        return "sorry";
    }

    @Override
    public String list() {
        return "sorry";
    }

    @Override
    public String add() {
        return "sorry";
    }

    @Override
    public String edit() {
        return "sorry";
    }

    @Override
    public String edit(@PathVariable Integer id) {
        return "sorry";
    }

    @Override
    public String delete(@PathVariable Integer id) {
        return "sorry";
    }
}
