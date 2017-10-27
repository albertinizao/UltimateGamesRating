package com.opipo.ultimategamesrating.repository;

import com.opipo.ultimategamesrating.model.Videogame;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface VideogameRepository extends MongoRepository<Videogame, Integer> {

    public List<Videogame> findAllByName(String name);

}
