package com.opipo.ultimategamesrating.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Videogame autogenerated")
public class VideogameTest {

    private  Videogame videogame;

    @BeforeEach
    public void init(){
        videogame = new Videogame();
    }



    @Test
    @DisplayName("The getter and the setter of name work well")
    public void nameAttributeTest(){
        String name = Integer.toString(1);
        videogame.setName(name);
        assertEquals(name,videogame.getName());
    }


    @Test
    @DisplayName("The getter and the setter of platform work well")
    public void platformAttributeTest(){
        List<String> platform = new ArrayList<String>();
        videogame.setPlatform(platform);
        assertEquals(platform,videogame.getPlatform());
    }


    @Test
    @DisplayName("The getter and the setter of genre work well")
    public void genreAttributeTest(){
        List<Genre> genre = new ArrayList<Genre>();
        videogame.setGenre(genre);
        assertEquals(genre,videogame.getGenre());
    }


    @Test
    @DisplayName("The getter and the setter of company work well")
    public void companyAttributeTest(){
        Company company = this.buildCompany();
        videogame.setCompany(company);
        assertEquals(company,videogame.getCompany());
    }

    private Company buildCompany() {
        return new Company();
    }


    @Test
    @DisplayName("The getter and the setter of masterpiece work well")
    public void masterpieceAttributeTest(){
        Masterpiece masterpiece = this.buildMasterpiece();
        videogame.setMasterpiece(masterpiece);
        assertEquals(masterpiece,videogame.getMasterpiece());
    }

    private Masterpiece buildMasterpiece() {
        return Masterpiece.FALSE;
    }


    @Test
    @DisplayName("The getter and the setter of completed work well")
    public void completedAttributeTest(){
        Boolean completed = Boolean.valueOf(true);
        videogame.setCompleted(completed);
        assertEquals(completed,videogame.getCompleted());
    }


    @Test
    @DisplayName("The getter and the setter of completedDate work well")
    public void completedDateAttributeTest(){
        Date completedDate = new Date();
        videogame.setCompletedDate(completedDate);
        assertEquals(completedDate,videogame.getCompletedDate());
    }

    @Test
    @DisplayName("In a date, when you set null the value is setted")
    public void completedDateNullAttributeTest(){
        Date completedDate = null;
        videogame.setCompletedDate(completedDate);
        assertNull(videogame.getCompletedDate());
    }

    @DisplayName("In a date, when you set value and then change it, the value settet still unchanged")
    @Test
    public void completedDateWithChangeAttributeTest(){
        Date completedDate = new Date();
        videogame.setCompletedDate(completedDate);
        completedDate.setTime(1L);
        assertNotEquals(completedDate,videogame.getCompletedDate());}


    @Test
    @DisplayName("The getter and the setter of timeUsed work well")
    public void timeUsedAttributeTest(){
        Integer timeUsed = Integer.valueOf(2);
        videogame.setTimeUsed(timeUsed);
        assertEquals(timeUsed,videogame.getTimeUsed());
    }


    @Test
    @DisplayName("The getter and the setter of license work well")
    public void licenseAttributeTest(){
        String license = Integer.toString(3);
        videogame.setLicense(license);
        assertEquals(license,videogame.getLicense());
    }


    @Test
    @DisplayName("The getter and the setter of mainCharacters work well")
    public void mainCharactersAttributeTest(){
        List<String> mainCharacters = new ArrayList<String>();
        videogame.setMainCharacters(mainCharacters);
        assertEquals(mainCharacters,videogame.getMainCharacters());
    }


    @Test
    @DisplayName("The getter and the setter of trophy work well")
    public void trophyAttributeTest(){
        TrophyPercent trophy = this.buildTrophyPercent();
        videogame.setTrophy(trophy);
        assertEquals(trophy,videogame.getTrophy());
    }

    private TrophyPercent buildTrophyPercent() {
        return TrophyPercent.T0;
    }


    @Test
    public void givenSameObjReturnThatTheyAreEquals(){
        Videogame o1 = new Videogame();
        Videogame o2 = new Videogame();
        assertEquals(o1, o2);
    }

    @Test
    public void givenSameObjReturnZero(){
        Videogame o1 = new Videogame();
        Videogame o2 = new Videogame();
        assertEquals(0, o1.compareTo(o2));
    }

    @Test
    public void givenObjectFromOtherClassReturnThatTheyArentEquals(){
        Videogame o1 = new Videogame();
        assertNotEquals(o1, new String());
    }

    @Test
    public void givenSameObjReturnSameHashCode(){
        Videogame o1 = new Videogame();
        Videogame o2 = new Videogame();
        assertEquals(o1.hashCode(), o2.hashCode());
    }

}