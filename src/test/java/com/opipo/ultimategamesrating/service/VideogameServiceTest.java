package com.opipo.ultimategamesrating.service;

import com.opipo.ultimategamesrating.model.Videogame;
import com.opipo.ultimategamesrating.repository.VideogameRepository;
import com.opipo.ultimategamesrating.service.impl.AbstractServiceDTO;
import com.opipo.ultimategamesrating.service.impl.VideogameServiceImpl;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.mongodb.repository.MongoRepository;


public class VideogameServiceTest extends GenericCRUDServiceTest<Videogame, Integer> {
    @InjectMocks
    private VideogameServiceImpl service;

    @Mock
    private VideogameRepository repository;

    @Mock
    private SequenceService secuenceService;

    @Override
    protected MongoRepository<Videogame, Integer> getRepository() {
        return repository;
    }

    @Override
    protected AbstractServiceDTO<Videogame, Integer> getService() {
        return service;
    }

    @Override
    public Integer getCorrectID() {
        return 2;
    }

    @Override
    public Integer getIncorrectCorrectID() {
        return 3333;
    }

    @Override
    public Videogame buildExpectedElement(Integer id, Object... params) {
        Videogame videogame = new Videogame();
        videogame.setId(id);
        if (params!=null && params.length>0){
            videogame.setName((String)params[1]);
        }
        return videogame;
    }

    @Override
    public void initFindCorrect(Integer id) {
        Videogame videogame = new Videogame();
        videogame.setId(id);
        initFindCorrect(videogame, id);
    }

    @Override
    public Class<Videogame> getElementClass() {
        return Videogame.class;
    }

    @Override
    public void mockIdGeneration() {
        Mockito.when(secuenceService.getNextSequence(Videogame.SEQUENCE_NAME)).thenReturn(getCorrectID());
    }
}