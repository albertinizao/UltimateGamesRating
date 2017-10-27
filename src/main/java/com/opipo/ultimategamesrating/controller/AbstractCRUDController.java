package com.opipo.ultimategamesrating.controller;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.opipo.ultimategamesrating.service.ServiceDTOInterface;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

public abstract class AbstractCRUDController<T, ID extends Serializable> {

    protected abstract ServiceDTOInterface<T, ID> getService();

    protected abstract boolean checkIdFromElement(ID id, T element);

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ApiOperation(value = "List", notes = "list all the elements")
    public @ResponseBody ResponseEntity<Collection<T>> list() {
        return new ResponseEntity<Collection<T>>(getService().findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ApiOperation(value = "Create", notes = "Create one element and return it")
    public @ResponseBody ResponseEntity<T> create() {
        return new ResponseEntity<T>(getService().create(), HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Get", notes = "Get one element by id")
    public @ResponseBody ResponseEntity<T> get(
            @ApiParam(value = "The identifier of the element", required = true) @PathVariable("id") ID id) {
        return new ResponseEntity<T>(getService().find(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ApiOperation(value = "Update", notes = "Update one element given the element")
    public @ResponseBody ResponseEntity<T> save(
            @ApiParam(value = "The identifier of the element", required = true) @PathVariable("id") ID id,
            @ApiParam(value = "Element to update with the changes", required = true) @RequestBody T element) {
        Assert.isTrue(checkIdFromElement(id, element), "The id is not the expected");
        Assert.notNull(getService().find(id), "The element doesn't exist");
        return new ResponseEntity<T>(getService().save(element), HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    @ApiOperation(value = "Create", notes = "Create a element if you know the id")
    public @ResponseBody ResponseEntity<T> create(@PathVariable("id") ID id,
                                                  @ApiParam(value = "Element to create if you want to save it directly", required = false) @RequestBody(required = false) T element) {
        Assert.isNull(getService().find(id), "The element exists now");
        if (element == null) {
            element = getService().create(id);
        } else {
            Assert.isTrue(checkIdFromElement(id, element), "The id is not the expected");
        }
        return new ResponseEntity<T>(getService().save(element), HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Delete", notes = "Delete element by id")
    public @ResponseBody ResponseEntity<ID> delete(
            @ApiParam(value = "The identifier of the element", required = true) @PathVariable("id") ID id) {
        getService().delete(id);
        return new ResponseEntity<ID>(id, HttpStatus.OK);
    }
}
