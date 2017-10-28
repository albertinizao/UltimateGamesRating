package com.opipo.ultimategamesrating.service.impl;

import com.opipo.ultimategamesrating.model.Platform;
import com.opipo.ultimategamesrating.repository.PlatformRepository;
import com.opipo.ultimategamesrating.service.PlatformService;
import com.opipo.ultimategamesrating.service.SequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Service
public class PlatformServiceImpl extends AbstractServiceDTO<Platform, String> implements PlatformService {
    @Autowired
    private PlatformRepository platformRepository;

    @Autowired
    private SequenceService sequenceService;

    @Override
    protected MongoRepository<Platform, String> getRepository() {
        return platformRepository;
    }

    @Override
    protected Platform buildElement(String id) {
        Platform platform = new Platform();
        platform.setId(id);
        return platform;
    }

    @Override
    public String buildId() {
        throw new UnsupportedOperationException(AbstractServiceDTO.NEEDS_ID);
    }
}
