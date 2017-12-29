package com.opipo.ultimategamesrating.repository;

import com.opipo.ultimategamesrating.UltimateGamesRatingApplicationConfig;
import com.opipo.ultimategamesrating.model.Generation;
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
public class GenerationRepositoryIntegrationTest {

    @Autowired
    private GenerationRepository generationRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    private Generation generation1 = null;
    private String id1 = "Id 1";
    private Integer graphicsAdjustment1 = 1;
    private Generation generation2 = null;
    private String id2 = "Id 2";
    private Integer graphicsAdjustment2 = 2;

    @Before
    public void setUp() throws Exception {
        generation1 = new Generation();
        generation1.setId(id1);
        generation1.setGraphicsAdjustment(graphicsAdjustment1);
        mongoTemplate.insert(generation1);

        generation2 = new Generation();
        generation2.setId(id2);
        generation2.setGraphicsAdjustment(graphicsAdjustment2);
        mongoTemplate.insert(generation2);
    }

    @Test
    public void get() {
        Generation actual = generationRepository.findById(id1).get();
        assertNotNull(actual);
        assertEquals(graphicsAdjustment1, actual.getGraphicsAdjustment());
    }

    @Test
    public void save() {
        Generation expected = new Generation();
        String id = "Id";
        Integer graphicsAdjustment = 100;
        expected.setId(id);
        expected.setGraphicsAdjustment(graphicsAdjustment);
        Generation actual = generationRepository.save(expected);
        assertNotNull(actual);
        assertEquals(id, actual.getId());
        assertEquals(graphicsAdjustment, actual.getGraphicsAdjustment());
    }

    @Test
    public void update() {
        generationRepository.findById(generation1.getId()).get();
        generation1.setGraphicsAdjustment(50);
        Generation actual = generationRepository.save(generation1);
        assertNotNull(actual);
        assertEquals(generation1.getId(), actual.getId());
        assertEquals(generation1.getGraphicsAdjustment(), actual.getGraphicsAdjustment());
    }

    @Test
    public void list() {
        Collection<Generation> actual = generationRepository.findAll();
        assertEquals(2, actual.size());
        List<Generation> generations = Arrays.asList(generation1, generation2);
        assertTrue(actual.stream().allMatch(p -> generations.contains(p)));

    }

    @Test
    public void delete() {
        assertTrue(generationRepository.existsById(id1));
        generationRepository.deleteById(id1);
        assertFalse(generationRepository.existsById(id1));
    }

    @Test
    public void deleteAll() {
        assertTrue(0L < generationRepository.count());
        generationRepository.deleteAll();
        assertEquals(0L, generationRepository.count());
    }
}
