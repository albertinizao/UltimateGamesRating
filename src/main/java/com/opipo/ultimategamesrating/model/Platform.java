package com.opipo.ultimategamesrating.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;

@Document
@ApiModel(value = "Platform", description = "All the information about the platform")
public class Platform implements Comparable<Platform> {

    @NotEmpty
    @ApiModelProperty(value = "The complete name of the platform", required = true, example = "Playstation 4")
    public String name;

    @NotEmpty
    @ApiModelProperty(value = "The generation at with this platform bellows", required = true, example = "4ª Generación")
    public String generation;

    @Id
    @NotEmpty
    @ApiModelProperty(value = "The id of the platform", required = true, example = "PS4")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGeneration() {
        return generation;
    }

    public void setGeneration(String generation) {
        this.generation = generation;
    }

    @Override
    public int hashCode() {
        final HashCodeBuilder hcb = new HashCodeBuilder();
        hcb.append(getId());
        hcb.append(getName());
        hcb.append(getGeneration());
        return hcb.toHashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Platform)) {
            return false;
        }
        final Platform other = (Platform) object;
        final EqualsBuilder eqb = new EqualsBuilder();
        eqb.append(this.getId(), other.getId());
        eqb.append(this.getName(), other.getName());
        eqb.append(this.getGeneration(), other.getGeneration());
        return eqb.isEquals();
    }

    @Override
    public int compareTo(Platform other) {
        final CompareToBuilder ctb = new CompareToBuilder();
        ctb.append(this.getId(), other.getId());
        ctb.append(this.getName(), other.getName());
        ctb.append(this.getGeneration(), other.getGeneration());
        return ctb.toComparison();
    }
}
