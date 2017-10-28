package com.opipo.ultimategamesrating.service.impl;

import com.opipo.ultimategamesrating.model.Videogame;
import com.opipo.ultimategamesrating.repository.VideogameRepository;
import com.opipo.ultimategamesrating.service.SequenceService;
import com.opipo.ultimategamesrating.service.VideogameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Service
public class VideogameServiceImpl extends AbstractServiceDTO<Videogame, String> implements VideogameService {
    @Autowired
    private VideogameRepository videogameRepository;

    @Autowired
    private SequenceService sequenceService;

    @Override
    protected MongoRepository<Videogame, String> getRepository() {
        return videogameRepository;
    }

    @Override
    protected Videogame buildElement(String name) {
        Videogame videogame = new Videogame();
        videogame.setName(name);
        return videogame;
    }

    @Override
    public String buildId() {
        throw new UnsupportedOperationException(AbstractServiceDTO.NEEDS_ID);
    }
}
