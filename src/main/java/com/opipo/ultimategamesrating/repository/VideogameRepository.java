package com.opipo.ultimategamesrating.repository;

import com.opipo.ultimategamesrating.model.Videogame;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VideogameRepository extends MongoRepository<Videogame, String> {

}
