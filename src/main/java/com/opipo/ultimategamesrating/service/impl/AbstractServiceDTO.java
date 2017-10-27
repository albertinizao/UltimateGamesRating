package com.opipo.ultimategamesrating.service.impl;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.opipo.ultimategamesrating.service.ServiceDTOInterface;

public abstract class AbstractServiceDTO<T, ID extends Serializable> implements ServiceDTOInterface<T, ID> {

    public static String DOESNT_EXISTS = "ERR:RESOURCE:01";
    public static String EXISTS = "ERR:RESOURCE:02";
    public static String NEEDS_ID = "ERR:RESOURCE:03";

    protected abstract MongoRepository<T, ID> getRepository();

    protected abstract T buildElement(ID id);

    public abstract ID buildId();

    public Boolean exists(ID id) {
        return this.find(id) != null;
    }

    public void checkExists(ID id) throws IllegalArgumentException {
        if (!exists(id)) {
            throw new IllegalArgumentException(DOESNT_EXISTS);
        }
    }

    public void checkDoesntExists(ID id) throws IllegalArgumentException {
        if (exists(id)) {
            throw new IllegalArgumentException(EXISTS);
        }
    }

    @Override
    public T find(ID id) {
        return getRepository().findById(id).orElse(null);
    }

    @Override
    public Collection<T> findAll() {
        return getRepository().findAll();
    }

    @Override
    public T save(T element) {
        return getRepository().save(element);
    }

    @Override
    public void delete(T element) {
        getRepository().delete(element);
    }

    @Override
    public void delete(ID id) {
        getRepository().deleteById(id);
    }

    @Override
    public T create(ID id) {
        return this.save(buildElement(id));
    }

    @Override
    public T create() {
        return this.create(buildId());
    }
}
