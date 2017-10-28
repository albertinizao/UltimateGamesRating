package com.opipo.ultimategamesrating.repository;

import com.opipo.ultimategamesrating.model.Platform;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlatformRepository extends MongoRepository<Platform, String> {
}
