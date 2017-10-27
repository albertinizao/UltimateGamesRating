package com.opipo.ultimategamesrating.service.impl;

import com.opipo.ultimategamesrating.model.Videogame;
import com.opipo.ultimategamesrating.repository.VideogameRepository;
import com.opipo.ultimategamesrating.service.SequenceService;
import com.opipo.ultimategamesrating.service.VideogameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;

public class VideogameServiceImpl extends AbstractServiceDTO<Videogame, Integer> implements VideogameService {
    @Autowired
    private VideogameRepository videogameRepository;

    @Autowired
    private SequenceService sequenceService;

    @Override
    protected MongoRepository<Videogame, Integer> getRepository() {
        return videogameRepository;
    }

    @Override
    protected Videogame buildElement(Integer id) {
        Videogame videogame = new Videogame();
        videogame.setId(id);
        return videogame;
    }

    @Override
    public Integer buildId() {
        return sequenceService.getNextSequence(Videogame.SEQUENCE_NAME);
    }
}
