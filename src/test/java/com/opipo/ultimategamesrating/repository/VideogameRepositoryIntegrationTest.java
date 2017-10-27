package com.opipo.ultimategamesrating.repository;

import com.opipo.ultimategamesrating.UltimateGamesRatingApplicationConfig;
import com.opipo.ultimategamesrating.model.Videogame;
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
public class VideogameRepositoryIntegrationTest {

    @Autowired
    private VideogameRepository videogameRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    private Videogame videogame1 = null;
    private Integer id1 = 1;
    private String name1 = "Name 1";
    private Videogame videogame2 = null;
    private Integer id2 = 2;
    private String name2 = "Name 2";

    @Before
    public void setUp() throws Exception {
        videogame1 = new Videogame();
        videogame1.setName(name1);
        videogame1.setId(id1);
        mongoTemplate.insert(videogame1);

        videogame2 = new Videogame();
        videogame2.setName(name2);
        videogame2.setId(id2);
        mongoTemplate.insert(videogame2);
    }

    @Test
    public void get() {
        Videogame actual = videogameRepository.findById(id1).get();
        assertNotNull(actual);
        assertEquals(name1, actual.getName());
        assertEquals(id1, actual.getId());
    }

    @Test
    public void save() {
        Videogame expected = new Videogame();
        String name = "Name";
        Integer id = 3;
        expected.setName(name);
        expected.setId(id);
        Videogame actual = videogameRepository.save(expected);
        assertNotNull(actual);
        assertEquals(name, actual.getName());
        assertEquals(id, actual.getId());
    }

    @Test
    public void update() {
        Videogame previous = videogameRepository.findById(videogame1.getId()).get();
        videogame1.setName("previous");
        Videogame actual = videogameRepository.save(videogame1);
        assertNotNull(actual);
        assertEquals(videogame1.getName(), actual.getName());
        assertEquals(videogame1.getId(), actual.getId());
    }

    @Test
    public void list() {
        Collection<Videogame> actual = videogameRepository.findAll();
        assertEquals(2, actual.size());
        List<Videogame> videogames = Arrays.asList(videogame1, videogame2);
        assertTrue(actual.stream().allMatch(p -> videogames.contains(p)));

    }

    @Test
    public void delete() {
        assertTrue(videogameRepository.existsById(id1));
        videogameRepository.deleteById(id1);
        assertFalse(videogameRepository.existsById(id1));
    }

    @Test
    public void deleteAll() {
        assertTrue(0L < videogameRepository.count());
        videogameRepository.deleteAll();
        assertEquals(0L, videogameRepository.count());
    }
}
