package com.opipo.ultimategamesrating.service;

import com.opipo.ultimategamesrating.model.Company;
import com.opipo.ultimategamesrating.repository.CompanyRepository;
import com.opipo.ultimategamesrating.service.impl.AbstractServiceDTO;
import com.opipo.ultimategamesrating.service.impl.CompanyServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.mongodb.repository.MongoRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CompanyServiceTest extends GenericCRUDServiceTest<Company, String> {
    @InjectMocks
    private CompanyServiceImpl service;

    @Mock
    private CompanyRepository repository;

    @Override
    protected MongoRepository<Company, String> getRepository() {
        return repository;
    }

    @Override
    protected AbstractServiceDTO<Company, String> getService() {
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
    public Company buildExpectedElement(String id, Object... params) {
        Company generation = new Company();
        generation.setName(id);
        return generation;
    }

    @Override
    public Company buildCompleteElement(String id, Object... params) {
        Company generation = new Company();
        generation.setName(id);
        return generation;
    }

    @Override
    public Company builPartialElement(Object... params) {
        Company generation = new Company();
        return generation;
    }

    @Override
    public void initFindCorrect(String id) {
        Company generation = new Company();
        generation.setName(id);
        initFindCorrect(generation, id);
    }

    @Override
    public Class<Company> getElementClass() {
        return Company.class;
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