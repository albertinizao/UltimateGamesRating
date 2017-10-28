package com.opipo.ultimategamesrating.controller;

import com.opipo.ultimategamesrating.model.Platform;
import com.opipo.ultimategamesrating.service.PlatformService;
import com.opipo.ultimategamesrating.service.ServiceDTOInterface;
import org.mockito.InjectMocks;
import org.mockito.Mock;


public class PlatformControllerTest extends AbstractCRUDControllerTest<Platform, String> {

    @InjectMocks
    private PlatformController controller = new PlatformController();

    @Mock
    private PlatformService service;

    @Override
    AbstractCRUDController<Platform, String> getController() {
        return controller;
    }

    @Override
    ServiceDTOInterface<Platform, String> getService() {
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
    Platform buildElement(String name) {
        Platform platform = new Platform();
        platform.setId(name);
        return platform;
    }
}
