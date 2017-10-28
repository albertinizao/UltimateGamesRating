package com.opipo.ultimategamesrating.service;

import com.opipo.ultimategamesrating.model.Generation;
import com.opipo.ultimategamesrating.repository.GenerationRepository;
import com.opipo.ultimategamesrating.service.impl.AbstractServiceDTO;
import com.opipo.ultimategamesrating.service.impl.GenerationServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.mongodb.repository.MongoRepository;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.HashSet;
import java.util.Optional;

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
            generation.setGraphicsAdjustment((Integer) params[1]);
        }
        return generation;
    }

    @Override
    public Generation buildCompleteElement(String id, Object... params) {
        Generation generation = new Generation();
        generation.setId(id);
        generation.setGraphicsAdjustment(20);
        return generation;
    }

    @Override
    public Generation builPartialElement(Object... params) {
        Generation generation = new Generation();
        generation.setGraphicsAdjustment(20);
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

    @Test
    public void givenPartialElementThenThrowsException() {
        String id = getCorrectID();
        Generation previous = buildCompleteElement(id);
        Generation partial = new Generation();
        partial.setGraphicsAdjustment(105);
        Generation expected = buildExpectedElement(id);
        Mockito.when(getRepository().findById(id)).thenReturn(Optional.of(previous));
        Mockito.when(getRepository().save(expected)).thenReturn(expected);

        java.util.Set<javax.validation.ConstraintViolation<Generation>> validation = new HashSet<>();
        validation.add(Mockito.mock(ConstraintViolation.class));

        Mockito.when(validator.validate(expected)).thenReturn(validation);

        ConstraintViolationException exception = assertThrows(ConstraintViolationException.class,
                () -> getService().update(id, expected));
    }
}