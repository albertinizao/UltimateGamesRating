package com.opipo.ultimategamesrating.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import com.opipo.ultimategamesrating.model.Generation;
import com.opipo.ultimategamesrating.repository.GenerationRepository;
import com.opipo.ultimategamesrating.service.GenerationService;

@Service
public class GenerationServiceImpl extends AbstractServiceDTO<Generation, String> implements GenerationService {
    @Autowired
    private GenerationRepository generationRepository;

    @Override
    protected MongoRepository<Generation, String> getRepository() {
        return generationRepository;
    }

    @Override
    protected Generation buildElement(String id) {
        Generation generation = new Generation();
        generation.setId(id);
        return generation;
    }

    @Override
    public String buildId() {
        throw new UnsupportedOperationException(AbstractServiceDTO.NEEDS_ID);
    }
}
