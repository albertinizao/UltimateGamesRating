package com.opipo.ultimategamesrating.controller;

import com.opipo.ultimategamesrating.model.Videogame;
import com.opipo.ultimategamesrating.service.ServiceDTOInterface;
import com.opipo.ultimategamesrating.service.VideogameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import io.swagger.annotations.Api;

@RestController
@RequestMapping("/position")
@Api(value = "REST API to manage the position of the duties")
public class VideogameController extends AbstractCRUDController<Videogame, Integer> {

    @Autowired
    private VideogameService service;

    @Override
    protected ServiceDTOInterface<Videogame, Integer> getService() {
        return service;
    }

    @Override
    protected boolean checkIdFromElement(Integer id, Videogame element) {
        return (id == null && (element == null || element.getId() == null))
                || (id != null && element != null && element.getId() != null && id.equals(element.getId()));
    }
}