package com.opipo.ultimategamesrating.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
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

    @Override
    public int hashCode() {
        final HashCodeBuilder hcb = new HashCodeBuilder();
        hcb.append(getName());
        hcb.append(getPlatform());
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
        return eqb.isEquals();
    }

    @Override
    public int compareTo(Videogame other) {
        final CompareToBuilder ctb = new CompareToBuilder();
        ctb.append(this.getName(), other.getName());
        ctb.append(this.getPlatform(), other.getPlatform());
        return ctb.toComparison();
    }

}
