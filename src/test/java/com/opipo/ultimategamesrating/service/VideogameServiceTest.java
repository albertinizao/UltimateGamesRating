package com.opipo.ultimategamesrating.service;

import com.opipo.ultimategamesrating.model.Videogame;
import com.opipo.ultimategamesrating.repository.VideogameRepository;
import com.opipo.ultimategamesrating.service.impl.AbstractServiceDTO;
import com.opipo.ultimategamesrating.service.impl.VideogameServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class VideogameServiceTest extends GenericCRUDServiceTest<Videogame, String> {
    @InjectMocks
    private VideogameServiceImpl service;

    @Mock
    private VideogameRepository repository;

    @Override
    protected MongoRepository<Videogame, String> getRepository() {
        return repository;
    }

    @Override
    protected AbstractServiceDTO<Videogame, String> getService() {
        return service;
    }

    @Override
    public String getCorrectID() {
        return "2";
    }

    @Override
    public String getIncorrectCorrectID() {
        return "3333";
    }

    @Override
    public Videogame buildExpectedElement(String name, Object... params) {
        Videogame videogame = new Videogame();
        videogame.setName(name);
        if (params != null && params.length > 0) {
            videogame.setName((String) params[1]);
        }
        return videogame;
    }

    @Override
    public Videogame buildCompleteElement(String id, Object... params) {
        Videogame videogame = new Videogame();
        videogame.setName(id);
        videogame.setPlatform(Arrays.asList("Plataforma"));
        return videogame;
    }

    @Override
    public Videogame builPartialElement(Object... params) {
        Videogame videogame = new Videogame();
        videogame.setPlatform(Arrays.asList("Plataforma"));
        return videogame;
    }

    @Override
    public void initFindCorrect(String name) {
        Videogame videogame = new Videogame();
        videogame.setName(name);
        initFindCorrect(videogame, name);
    }

    @Override
    public Class<Videogame> getElementClass() {
        return Videogame.class;
    }

    @Override
    public void mockIdGeneration() {
    }


    @Test
    public void givenNoneThenCreateIt() {
        this.mockIdGeneration();
        UnsupportedOperationException exception = assertThrows(UnsupportedOperationException.class, () -> whenCreation(false));
        assertEquals(AbstractServiceDTO.NEEDS_ID, exception.getMessage());
    }
}