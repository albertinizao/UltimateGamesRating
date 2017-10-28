package com.opipo.ultimategamesrating.repository;

import com.opipo.ultimategamesrating.model.Generation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GenerationRepository extends MongoRepository<Generation, String> {
}
