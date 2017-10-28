package com.opipo.ultimategamesrating.controller;

import com.opipo.ultimategamesrating.model.Genre;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collection;

@RestController
@RequestMapping("/combo")
@Api(value = "REST API to get a list of combos")
public class ComboController {

    @RequestMapping(value = "/genre", method = RequestMethod.GET)
    @ApiOperation(value = "List", notes = "list all the genres")
    public @ResponseBody
    ResponseEntity<Collection<Genre>> genres() {
        return new ResponseEntity<Collection<Genre>>(Arrays.asList(Genre.values()), HttpStatus.OK);
    }
}
