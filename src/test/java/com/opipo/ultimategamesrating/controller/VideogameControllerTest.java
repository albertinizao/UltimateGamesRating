package com.opipo.ultimategamesrating.controller;

import com.opipo.ultimategamesrating.model.Videogame;
import com.opipo.ultimategamesrating.service.ServiceDTOInterface;
import com.opipo.ultimategamesrating.service.VideogameService;
import org.mockito.InjectMocks;
import org.mockito.Mock;


public class VideogameControllerTest extends AbstractCRUDControllerTest<Videogame, String> {

    @InjectMocks
    private VideogameController controller = new VideogameController();

    @Mock
    private VideogameService service;

    @Override
    AbstractCRUDController<Videogame, String> getController() {
        return controller;
    }

    @Override
    ServiceDTOInterface<Videogame, String> getService() {
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
    Videogame buildElement(String name) {
        Videogame videogame = new Videogame();
        videogame.setName(name);
        return videogame;
    }
}
