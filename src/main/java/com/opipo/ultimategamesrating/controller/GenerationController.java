package com.opipo.ultimategamesrating.controller;

import com.opipo.ultimategamesrating.model.Generation;
import com.opipo.ultimategamesrating.service.GenerationService;
import com.opipo.ultimategamesrating.service.ServiceDTOInterface;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/generation")
@Api(value = "REST API to manage the generations")
public class GenerationController extends AbstractCRUDController<Generation, String> {

    @Autowired
    private GenerationService service;

    @Override
    protected ServiceDTOInterface<Generation, String> getService() {
        return service;
    }

    protected String getIdFromElement(Generation element){
        return element.getId();
    }

}