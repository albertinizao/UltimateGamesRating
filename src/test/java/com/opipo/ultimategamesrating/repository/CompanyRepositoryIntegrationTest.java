package com.opipo.ultimategamesrating.repository;

import com.opipo.ultimategamesrating.UltimateGamesRatingApplicationConfig;
import com.opipo.ultimategamesrating.model.Company;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {UltimateGamesRatingApplicationConfig.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ActiveProfiles("test")
public class CompanyRepositoryIntegrationTest {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    private Company company1 = null;
    private String id1 = "Id 1";
    private Company company2 = null;
    private String id2 = "Id 2";

    @Before
    public void setUp() throws Exception {
        company1 = new Company();
        company1.setName(id1);
        mongoTemplate.insert(company1);

        company2 = new Company();
        company2.setName(id2);
        mongoTemplate.insert(company2);
    }

    @Test
    public void get() {
        Company actual = companyRepository.findById(id1).get();
        assertNotNull(actual);
    }

    @Test
    public void save() {
        Company expected = new Company();
        String id = "Id";
        Integer graphicsAdjustment = 100;
        expected.setName(id);
        Company actual = companyRepository.save(expected);
        assertNotNull(actual);
        assertEquals(id, actual.getName());
    }

    @Test
    public void update() {
        Company previous = companyRepository.findById(company1.getName()).get();
        Company actual = companyRepository.save(company1);
        assertNotNull(actual);
        assertEquals(company1.getName(), actual.getName());
    }

    @Test
    public void list() {
        Collection<Company> actual = companyRepository.findAll();
        assertEquals(2, actual.size());
        List<Company> generations = Arrays.asList(company1, company2);
        assertTrue(actual.stream().allMatch(p -> generations.contains(p)));

    }

    @Test
    public void delete() {
        assertTrue(companyRepository.existsById(id1));
        companyRepository.deleteById(id1);
        assertFalse(companyRepository.existsById(id1));
    }

    @Test
    public void deleteAll() {
        assertTrue(0L < companyRepository.count());
        companyRepository.deleteAll();
        assertEquals(0L, companyRepository.count());
    }
}
