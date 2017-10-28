package com.opipo.ultimategamesrating.controller;

import com.opipo.ultimategamesrating.model.Company;
import com.opipo.ultimategamesrating.service.CompanyService;
import com.opipo.ultimategamesrating.service.ServiceDTOInterface;
import org.mockito.InjectMocks;
import org.mockito.Mock;


public class CompanyControllerTest extends AbstractCRUDControllerTest<Company, String> {

    @InjectMocks
    private CompanyController controller = new CompanyController();

    @Mock
    private CompanyService service;

    @Override
    AbstractCRUDController<Company, String> getController() {
        return controller;
    }

    @Override
    ServiceDTOInterface<Company, String> getService() {
        return service;
    }

    @Override
    String getCorrectID() {
        return "1";
    }

    @Override
    String getIncorrectID() {
        return "2";
    }

    @Override
    Company buildElement(String id) {
        Company company = new Company();
        company.setName(id);
        return company;
    }
}
