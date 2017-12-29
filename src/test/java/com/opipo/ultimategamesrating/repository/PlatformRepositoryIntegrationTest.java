package com.opipo.ultimategamesrating.repository;

import com.opipo.ultimategamesrating.UltimateGamesRatingApplicationConfig;
import com.opipo.ultimategamesrating.model.Platform;
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
public class PlatformRepositoryIntegrationTest {

    @Autowired
    private PlatformRepository platformRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    private Platform platform1 = null;
    private String id1 = "Id 1";
    private String name1 = "Name 1";
    private Platform platform2 = null;
    private String id2 = "Id 2";
    private String name2 = "Name 2";

    @Before
    public void setUp() throws Exception {
        platform1 = new Platform();
        platform1.setId(id1);
        platform1.setName(name1);
        mongoTemplate.insert(platform1);

        platform2 = new Platform();
        platform2.setId(id2);
        platform2.setName(name2);
        mongoTemplate.insert(platform2);
    }

    @Test
    public void get() {
        Platform actual = platformRepository.findById(id1).get();
        assertNotNull(actual);
        assertEquals(name1, actual.getName());
    }

    @Test
    public void save() {
        Platform expected = new Platform();
        String id = "Id";
        String name = "Name";
        expected.setId(id);
        expected.setName(name);
        Platform actual = platformRepository.save(expected);
        assertNotNull(actual);
        assertEquals(id, actual.getId());
        assertEquals(name, actual.getName());
    }

    @Test
    public void update() {
        platformRepository.findById(platform1.getId()).get();
        platform1.setName("previous");
        Platform actual = platformRepository.save(platform1);
        assertNotNull(actual);
        assertEquals(platform1.getId(), actual.getId());
        assertEquals(platform1.getName(), actual.getName());
    }

    @Test
    public void list() {
        Collection<Platform> actual = platformRepository.findAll();
        assertEquals(2, actual.size());
        List<Platform> generations = Arrays.asList(platform1, platform2);
        assertTrue(actual.stream().allMatch(p -> generations.contains(p)));

    }

    @Test
    public void delete() {
        assertTrue(platformRepository.existsById(id1));
        platformRepository.deleteById(id1);
        assertFalse(platformRepository.existsById(id1));
    }

    @Test
    public void deleteAll() {
        assertTrue(0L < platformRepository.count());
        platformRepository.deleteAll();
        assertEquals(0L, platformRepository.count());
    }
}
