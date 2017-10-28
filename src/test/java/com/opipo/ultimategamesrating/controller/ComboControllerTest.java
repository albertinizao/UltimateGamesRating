package com.opipo.ultimategamesrating.controller;

import com.opipo.ultimategamesrating.model.Genre;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ComboControllerTest {

    private ComboController comboController = new ComboController();

    @Test
    public void listAllGenres() {
        Collection<Genre> expected = Arrays.asList(Genre.values());
        ResponseEntity<Collection<Genre>> actual = comboController.genres();
        assertEquals(HttpStatus.OK, actual.getStatusCode());
        assertTrue(actual.getBody().stream().allMatch(expected::contains));
    }
}
