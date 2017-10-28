package com.opipo.ultimategamesrating.controller;

import com.opipo.ultimategamesrating.model.Platform;
import com.opipo.ultimategamesrating.service.PlatformService;
import com.opipo.ultimategamesrating.service.ServiceDTOInterface;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/platform")
@Api(value = "REST API to manage the platforms")
public class PlatformController extends AbstractCRUDController<Platform, String> {

    @Autowired
    private PlatformService service;

    @Override
    protected ServiceDTOInterface<Platform, String> getService() {
        return service;
    }

    @Override
    protected boolean checkIdFromElement(String name, Platform element) {
        return (name == null && (element == null || element.getId() == null))
                || (name != null && element != null && element.getId() != null && name.equals(element.getId()));
    }
}