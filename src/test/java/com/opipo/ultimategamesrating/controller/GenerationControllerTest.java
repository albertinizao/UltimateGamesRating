package com.opipo.ultimategamesrating.controller;

import com.opipo.ultimategamesrating.model.Generation;
import com.opipo.ultimategamesrating.service.GenerationService;
import com.opipo.ultimategamesrating.service.ServiceDTOInterface;
import org.mockito.InjectMocks;
import org.mockito.Mock;


public class GenerationControllerTest extends AbstractCRUDControllerTest<Generation, String> {

    @InjectMocks
    private GenerationController controller = new GenerationController();

    @Mock
    private GenerationService service;

    @Override
    AbstractCRUDController<Generation, String> getController() {
        return controller;
    }

    @Override
    ServiceDTOInterface<Generation, String> getService() {
        return service;
    }

    @Override
    String getCorrectID() {
        return "1";
    }

    @Override
    String getIncorrectID() {
        return "2";
    }

    @Override
    Generation buildElement(String name) {
        Generation generation = new Generation();
        generation.setId(name);
        return generation;
    }
}
