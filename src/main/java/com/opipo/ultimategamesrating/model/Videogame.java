package com.opipo.ultimategamesrating.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Document
@ApiModel(value = "Videogame", description = "All the information about the videogame")
public class Videogame implements Comparable<Videogame>, Serializable {

    @Id
    @NotEmpty
    @ApiModelProperty(value = "The name of the game", required = true, example = "Final Fantasy VII")
    private String name;

    @NotEmpty
    @ApiModelProperty(value = "Collection of all the platforms", required = true, example = "PS")
    private List<String> platform;

    @NotEmpty
    @ApiModelProperty(value = "Collection of all the genres", required = true, example = "RPG")
    private List<Genre> genre;

    @ApiModelProperty(value = "Information about the company", required = false)
    private Company company;

    @NotEmpty
    @ApiModelProperty(value = "If is a masterpiece or not. FALSE, TRUE or HOLLY", required = true, example = "FALSE")
    private Masterpiece masterpiece;

    @NotEmpty
    @ApiModelProperty(value = "If the game was completed or not", required = true, example = "false")
    private Boolean completed;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @ApiModelProperty(value = "The date in witch the game was completed", required = true, example = "2017-01-30")
    private Date completedDate;

    @ApiModelProperty(value = "The time in hours that you used to completed the game", required = false, example = "23")
    private Integer timeUsed;

    @ApiModelProperty(value = "The name of the license", required = false, example = "Starwars")
    private String license;

    @ApiModelProperty(value = "The name of the mains characters", required = false)
    private List<String> mainCharacters;

    @ApiModelProperty(value = "The percent of trophies that you have.", required = false, example = "P75")
    private TrophyPercent trophy;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPlatform() {
        return platform;
    }

    public void setPlatform(List<String> platform) {
        this.platform = platform;
    }

    public List<Genre> getGenre() {
        return genre;
    }

    public void setGenre(List<Genre> genre) {
        this.genre = genre;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Masterpiece getMasterpiece() {
        return masterpiece;
    }

    public void setMasterpiece(Masterpiece masterpiece) {
        this.masterpiece = masterpiece;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Date getCompletedDate() {
        return completedDate==null?null:new Date(completedDate.getTime());
    }

    public void setCompletedDate(Date completedDate) {
        this.completedDate = completedDate==null?null:new Date(completedDate.getTime());
    }

    public Integer getTimeUsed() {
        return timeUsed;
    }

    public void setTimeUsed(Integer timeUsed) {
        this.timeUsed = timeUsed;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public List<String> getMainCharacters() {
        return mainCharacters;
    }

    public void setMainCharacters(List<String> mainCharacters) {
        this.mainCharacters = mainCharacters;
    }

    public TrophyPercent getTrophy() {
        return trophy;
    }

    public void setTrophy(TrophyPercent trophy) {
        this.trophy = trophy;
    }

    @Override
    public int hashCode() {
        final HashCodeBuilder hcb = new HashCodeBuilder();
        hcb.append(getName());
        hcb.append(getPlatform());
        hcb.append(getGenre());
        hcb.append(getCompany());
        hcb.append(getMasterpiece());
        hcb.append(getCompleted());
        hcb.append(getCompletedDate());
        hcb.append(getTimeUsed());
        hcb.append(getLicense());
        hcb.append(getMainCharacters());
        hcb.append(getTrophy());
        return hcb.toHashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Videogame)) {
            return false;
        }
        final Videogame other = (Videogame) object;
        final EqualsBuilder eqb = new EqualsBuilder();
        eqb.append(this.getName(), other.getName());
        eqb.append(this.getPlatform(), other.getPlatform());
        eqb.append(this.getGenre(), other.getGenre());
        eqb.append(this.getCompany(), other.getCompany());
        eqb.append(this.getMasterpiece(), other.getMasterpiece());
        eqb.append(this.getCompleted(), other.getCompleted());
        eqb.append(this.getCompletedDate(), other.getCompletedDate());
        eqb.append(this.getTimeUsed(), other.getTimeUsed());
        eqb.append(this.getLicense(), other.getLicense());
        eqb.append(this.getMainCharacters(), other.getMainCharacters());
        eqb.append(this.getTrophy(), other.getTrophy());
        return eqb.isEquals();
    }

    @Override
    public int compareTo(Videogame other) {
        final CompareToBuilder ctb = new CompareToBuilder();
        ctb.append(this.getName(), other.getName());
        ctb.append(this.getPlatform(), other.getPlatform());
        ctb.append(this.getGenre(), other.getGenre());
        ctb.append(this.getCompany(), other.getCompany());
        ctb.append(this.getMasterpiece(), other.getMasterpiece());
        ctb.append(this.getCompleted(), other.getCompleted());
        ctb.append(this.getCompletedDate(), other.getCompletedDate());
        ctb.append(this.getTimeUsed(), other.getTimeUsed());
        ctb.append(this.getLicense(), other.getLicense());
        ctb.append(this.getMainCharacters(), other.getMainCharacters());
        ctb.append(this.getTrophy(), other.getTrophy());
        return ctb.toComparison();
    }
}
