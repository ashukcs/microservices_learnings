package com.hrs.springboot.exceptionhandling.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrs.springboot.exceptionhandling.model.Company;
import com.hrs.springboot.exceptionhandling.model.CompanyDetailsRequest;

@RestController
@RequestMapping(path = "/api/company")
public class RestApiController {

    @PostMapping(path = "/all")
    public ResponseEntity<Company> getCompanyDetails(@Valid @RequestBody CompanyDetailsRequest request) {
        Company company = new Company();
        company.setId(request.getId());
        company.setName(request.getName());
        company.setMobile(request.getMobile());
        company.setLocation(request.getLocation());
        return new ResponseEntity<>(company, HttpStatus.OK);
    }
}