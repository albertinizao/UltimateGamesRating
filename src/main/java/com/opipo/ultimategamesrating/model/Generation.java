package com.opipo.ultimategamesrating.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Document
@ApiModel(value = "Generation", description = "All the information about the generation")
public class Generation implements Comparable<Generation>{

    @Id
    @ApiModelProperty(value = "The id of the generation", required = true, example = "PS4")
    private String id;

    @NotEmpty
    @ApiModelProperty(value = "The complete name of the generation", required = true, example = "Playstation 4")
    public String name;

    @NotEmpty
    @Min(0)
    @Max(100)
    @ApiModelProperty(value = "The adjustment percent for the graphics in this generation", required = true, example = "85")
    public Short graphicsAdjustment;

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

    public Short getGraphicsAdjustment() {
        return graphicsAdjustment;
    }

    public void setGraphicsAdjustment(Short graphicsAdjustment) {
        this.graphicsAdjustment = graphicsAdjustment;
    }

    @Override
    public int hashCode() {
        final HashCodeBuilder hcb = new HashCodeBuilder();
        hcb.append(getId());
        hcb.append(getName());
        hcb.append(getGraphicsAdjustment());
        return hcb.toHashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Generation)) {
            return false;
        }
        final Generation other = ( Generation ) object;
        final EqualsBuilder eqb = new EqualsBuilder();
        eqb.append(this.getId(), other.getId());
        eqb.append(this.getName(), other.getName());
        eqb.append(this.getGraphicsAdjustment(), other.getGraphicsAdjustment());
        return eqb.isEquals();
    }

    @Override
    public int compareTo(Generation other) {
        final CompareToBuilder ctb = new CompareToBuilder();
        ctb.append(this.getId(), other.getId());
        ctb.append(this.getName(), other.getName());
        ctb.append(this.getGraphicsAdjustment(), other.getGraphicsAdjustment());
        return ctb.toComparison();
    }
}
