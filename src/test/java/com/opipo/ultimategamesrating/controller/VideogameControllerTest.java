package com.opipo.ultimategamesrating.controller;

import com.opipo.ultimategamesrating.model.Videogame;
import com.opipo.ultimategamesrating.service.ServiceDTOInterface;
import com.opipo.ultimategamesrating.service.VideogameService;
import org.mockito.InjectMocks;
import org.mockito.Mock;


public class VideogameControllerTest extends AbstractCRUDControllerTest<Videogame, Integer> {

    @InjectMocks
    private VideogameController controller = new VideogameController();

    @Mock
    private VideogameService service;

    @Override
    AbstractCRUDController<Videogame, Integer> getController() {
        return controller;
    }

    @Override
    ServiceDTOInterface<Videogame, Integer> getService() {
        return service;
    }

    @Override
    Integer getCorrectID() {
        return 1;
    }

    @Override
    Integer getIncorrectID() {
        return 2;
    }

    @Override
    Videogame buildElement(Integer id) {
        Videogame videogame = new Videogame();
        videogame.setId(id);
        return videogame;
    }
}
