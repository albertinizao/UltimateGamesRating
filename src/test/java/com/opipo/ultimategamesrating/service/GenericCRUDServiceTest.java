package com.opipo.ultimategamesrating.service;

import com.opipo.ultimategamesrating.MockitoExtension;
import com.opipo.ultimategamesrating.service.impl.AbstractServiceDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public abstract class GenericCRUDServiceTest<T, ID extends Serializable> {

    protected abstract MongoRepository<T, ID> getRepository();

    protected abstract AbstractServiceDTO<T, ID> getService();

    public abstract ID getCorrectID();

    public abstract ID getIncorrectCorrectID();

    public abstract T buildExpectedElement(ID id, Object... params);

    public abstract void initFindCorrect(ID id);

    public abstract Class<T> getElementClass();

    public abstract void mockIdGeneration();

    @BeforeEach
    public void init(){
        MockitoAnnotations.initMocks(getService());
    }

    public void initFindCorrect(T element, ID id) {
        Mockito.when(getRepository().findById(id)).thenReturn(Optional.of(element));
    }

    @Test
    public void givenCorrectIdThenExists() {
        ID id = getCorrectID();
        initFindCorrect(id);
        assertTrue(getService().exists(id));
    }

    @Test
    public void givenMissCorrectIdThenDoesntExists() {
        assertFalse(getService().exists(getCorrectID()));
    }

    @Test
    public void givenCorrectIdThenDoesntThrowsExceptionBecauseItExists() {
        ID id = getCorrectID();
        initFindCorrect(id);
        getService().checkExists(id);
        assertTrue(true);
    }

    @Test
    public void givenCorrectIdThenThrowsExceptionBecauseItDoesntExists() {
        ID id = getCorrectID();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> getService().checkExists(id));
        assertTrue(exception.getMessage().contains(AbstractServiceDTO.DOESNT_EXISTS));
    }

    @Test
    public void givenCorrectIdThenThrowsExceptionBecauseItExists() {
        ID id = getCorrectID();
        initFindCorrect(id);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> getService().checkDoesntExists(id));
        assertTrue(exception.getMessage().contains(AbstractServiceDTO.EXISTS));
    }

    @Test
    public void givenCorrectIdThenDoesntThrowsExceptionBecauseItDoesntExists() {
        ID id = getCorrectID();
        getService().checkDoesntExists(id);
        assertTrue(true);
    }

    @Test
    public void givenIdThenRetunElement() {
        ID id = getCorrectID();
        T expected = buildExpectedElement(id);
        initFindCorrect(expected, id);
        T actual = getService().find(id);
        assertEquals(expected, actual);
    }

    @Test
    public void givenMissIdThenRetunNoElement() {
        ID id = getCorrectID();
        T expected = buildExpectedElement(id);
        initFindCorrect(expected, id);
        T actual = getService().find(getIncorrectCorrectID());
        assertNull(actual);
    }

    @Test
    public void whenInvokeGetAllThenGetAll() {
        List<T> expected = new ArrayList<>();
        expected.add(buildExpectedElement(getCorrectID()));
        Mockito.when(getRepository().findAll()).thenReturn(expected);
        Collection<T> actual = getService().findAll();
        assertEquals(expected, actual);
    }

    @Test
    public void givenElementThenDeleteIt() {
        T element = buildExpectedElement(getCorrectID());
        getService().delete(element);
        Mockito.verify(getRepository()).delete(element);
    }

    @Test
    public void givenIdThenDeleteIt() {
        ID id = getCorrectID();
        getService().delete(id);
        Mockito.verify(getRepository()).deleteById(id);
    }

    @Test
    public void givenElementThenSaveIt() {
        ID id = getCorrectID();
        T expected = buildExpectedElement(id);
        Mockito.when(getRepository().save(expected)).thenReturn(expected);
        T actual = getService().save(expected);
        assertEquals(expected, actual);
    }

    @Test
    public void givenIdThenCreateElement() {
        whenCreation(true);
    }

    @Test
    public void givenNoneThenCreateIt() {
        this.mockIdGeneration();
        whenCreation(false);
    }

    private void whenCreation(Boolean useId) {
        ID id = getCorrectID();
        T expected = buildExpectedElement(id);
        Mockito.when(getRepository().save(Mockito.any(getElementClass()))).thenReturn(expected);
        T actual = useId ? getService().create(id) : getService().create();
        ArgumentCaptor<T> captor = ArgumentCaptor.forClass(getElementClass());
        Mockito.verify(getRepository()).save(captor.capture());
        assertNotNull(captor.getValue());
        assertEquals(expected, captor.getValue());
        assertEquals(expected, actual);
    }
}
