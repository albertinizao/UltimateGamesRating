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

@Document
@ApiModel(value = "Videogame", description = "All the information about the videogame")
public class Videogame implements Comparable<Videogame>, Serializable {

    @ApiModelProperty(value = "The id of the game", required = true, example = "1")
    @Id
    public Integer id;

    @ApiModelProperty(value = "The name of the game", required = true, example = "Final Fantasy VII")
    @NotEmpty
    public String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        final HashCodeBuilder hcb = new HashCodeBuilder();
        hcb.append(getId());
        hcb.append(getName());
        return hcb.toHashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Videogame)) {
            return false;
        }
        final Videogame other = (Videogame) object;
        final EqualsBuilder eqb = new EqualsBuilder();
        eqb.append(this.getId(), other.getId());
        eqb.append(this.getName(), other.getName());
        return eqb.isEquals();
    }

    @Override
    public int compareTo(Videogame other) {
        final CompareToBuilder ctb = new CompareToBuilder();
        ctb.append(this.getId(), other.getId());
        ctb.append(this.getName(), other.getName());
        return ctb.toComparison();
    }

}
