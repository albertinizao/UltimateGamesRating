package com.opipo.ultimategamesrating.controller;

import com.opipo.ultimategamesrating.model.Company;
import com.opipo.ultimategamesrating.service.CompanyService;
import com.opipo.ultimategamesrating.service.ServiceDTOInterface;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/generation")
@Api(value = "REST API to manage the generations")
public class CompanyController extends AbstractCRUDController<Company, String> {

    @Autowired
    private CompanyService service;

    @Override
    protected ServiceDTOInterface<Company, String> getService() {
        return service;
    }

    protected String getIdFromElement(Company element){
        return element.getName();
    }

}