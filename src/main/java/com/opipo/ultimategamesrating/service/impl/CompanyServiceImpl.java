package com.opipo.ultimategamesrating.service.impl;

import com.opipo.ultimategamesrating.model.Company;
import com.opipo.ultimategamesrating.repository.CompanyRepository;
import com.opipo.ultimategamesrating.service.CompanyService;
import com.opipo.ultimategamesrating.service.SequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl extends AbstractServiceDTO<Company, String> implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private SequenceService sequenceService;

    @Override
    protected MongoRepository<Company, String> getRepository() {
        return companyRepository;
    }

    @Override
    protected Company buildElement(String id) {
        Company generation = new Company();
        generation.setName(id);
        return generation;
    }

    @Override
    public String buildId() {
        throw new UnsupportedOperationException(AbstractServiceDTO.NEEDS_ID);
    }
}
