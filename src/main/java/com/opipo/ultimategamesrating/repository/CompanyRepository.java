package com.opipo.ultimategamesrating.repository;

import com.opipo.ultimategamesrating.model.Company;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompanyRepository extends MongoRepository<Company, String> {
}
