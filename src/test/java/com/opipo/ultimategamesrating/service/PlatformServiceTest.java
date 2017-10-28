package com.opipo.ultimategamesrating.service;

import com.opipo.ultimategamesrating.model.Platform;
import com.opipo.ultimategamesrating.repository.PlatformRepository;
import com.opipo.ultimategamesrating.service.impl.AbstractServiceDTO;
import com.opipo.ultimategamesrating.service.impl.PlatformServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.mongodb.repository.MongoRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class PlatformServiceTest extends GenericCRUDServiceTest<Platform, String> {
    @InjectMocks
    private PlatformServiceImpl service;

    @Mock
    private PlatformRepository repository;

    @Override
    protected MongoRepository<Platform, String> getRepository() {
        return repository;
    }

    @Override
    protected AbstractServiceDTO<Platform, String> getService() {
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
    public Platform buildExpectedElement(String id, Object... params) {
        Platform platform = new Platform();
        platform.setId(id);
        if (params != null && params.length > 0) {
            platform.setName((String) params[1]);
        }
        return platform;
    }

    @Override
    public Platform buildCompleteElement(String id, Object... params) {
        Platform platform = new Platform();
        platform.setId(id);
        platform.setName("name");
        return platform;
    }

    @Override
    public Platform builPartialElement(Object... params) {
        Platform platform = new Platform();
        platform.setName("name");
        return platform;
    }

    @Override
    public void initFindCorrect(String id) {
        Platform platform = new Platform();
        platform.setId(id);
        initFindCorrect(platform, id);
    }

    @Override
    public Class<Platform> getElementClass() {
        return Platform.class;
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