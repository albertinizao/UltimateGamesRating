package com.opipo.ultimategamesrating.controller;

import com.opipo.ultimategamesrating.model.Videogame;
import com.opipo.ultimategamesrating.service.ServiceDTOInterface;
import com.opipo.ultimategamesrating.service.VideogameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import io.swagger.annotations.Api;

@RestController
@RequestMapping("/videogame")
@Api(value = "REST API to manage the videogames")
public class VideogameController extends AbstractCRUDController<Videogame, String> {

    @Autowired
    private VideogameService service;

    @Override
    protected ServiceDTOInterface<Videogame, String> getService() {
        return service;
    }

    @Override
    protected boolean checkIdFromElement(String name, Videogame element) {
        return (name == null && (element == null || element.getName() == null))
                || (name != null && element != null && element.getName() != null && name.equals(element.getName()));
    }
}