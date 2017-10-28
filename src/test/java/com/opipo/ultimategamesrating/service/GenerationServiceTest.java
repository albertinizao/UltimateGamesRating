package com.opipo.ultimategamesrating.service;

import com.opipo.ultimategamesrating.model.Generation;
import com.opipo.ultimategamesrating.repository.GenerationRepository;
import com.opipo.ultimategamesrating.service.impl.AbstractServiceDTO;
import com.opipo.ultimategamesrating.service.impl.GenerationServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.mongodb.repository.MongoRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class GenerationServiceTest extends GenericCRUDServiceTest<Generation, String> {
    @InjectMocks
    private GenerationServiceImpl service;

    @Mock
    private GenerationRepository repository;

    @Override
    protected MongoRepository<Generation, String> getRepository() {
        return repository;
    }

    @Override
    protected AbstractServiceDTO<Generation, String> getService() {
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
    public Generation buildExpectedElement(String id, Object... params) {
        Generation generation = new Generation();
        generation.setId(id);
        if (params != null && params.length > 0) {
            generation.setName((String) params[1]);
        }
        return generation;
    }

    @Override
    public void initFindCorrect(String id) {
        Generation generation = new Generation();
        generation.setId(id);
        initFindCorrect(generation, id);
    }

    @Override
    public Class<Generation> getElementClass() {
        return Generation.class;
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