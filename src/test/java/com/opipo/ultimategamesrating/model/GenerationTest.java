package com.opipo.ultimategamesrating.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@DisplayName("Generation autogenerated")
public class GenerationTest {

    private  Generation generation;

    @BeforeEach
    public void init(){
        generation = new Generation();
    }



    @Test
    @DisplayName("The getter and the setter of id work well")
    public void idAttributeTest(){
        String id = Integer.toString(1);
        generation.setId(id);
        assertEquals(id,generation.getId());
    }


    @Test
    @DisplayName("The getter and the setter of graphicsAdjustment work well")
    public void graphicsAdjustmentAttributeTest(){
        Integer graphicsAdjustment = 3;
        generation.setGraphicsAdjustment(graphicsAdjustment);
        assertEquals(graphicsAdjustment,generation.getGraphicsAdjustment());
    }



    @Test
    public void givenSameObjReturnThatTheyAreEquals(){
        Generation o1 = new Generation();
        Generation o2 = new Generation();
        assertEquals(o1, o2);
    }

    @Test
    public void givenSameObjReturnZero(){
        Generation o1 = new Generation();
        Generation o2 = new Generation();
        assertEquals(0, o1.compareTo(o2));
    }

    @Test
    public void givenObjectFromOtherClassReturnThatTheyArentEquals(){
        Generation o1 = new Generation();
        assertNotEquals(o1, new String());
    }

    @Test
    public void givenSameObjReturnSameHashCode(){
        Generation o1 = new Generation();
        Generation o2 = new Generation();
        assertEquals(o1.hashCode(), o2.hashCode());
    }

}