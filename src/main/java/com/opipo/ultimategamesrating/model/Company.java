package com.opipo.ultimategamesrating.model;

import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.validation.constraints.NotNull;

public class Company implements Comparable<Company> {
    @NotNull
    @ApiModelProperty(value = "The company how develops the game", required = true, example = "Konami")
    private String developer;

    @NotNull
    @ApiModelProperty(value = "The company how edits the game", required = true, example = "Konami")
    private String editor;

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    @Override
    public int hashCode() {
        final HashCodeBuilder hcb = new HashCodeBuilder();
        hcb.append(getDeveloper());
        hcb.append(getEditor());
        return hcb.toHashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Company)) {
            return false;
        }
        final Company other = (Company) object;
        final EqualsBuilder eqb = new EqualsBuilder();
        eqb.append(this.getDeveloper(), other.getDeveloper());
        eqb.append(this.getEditor(), other.getEditor());
        return eqb.isEquals();
    }

    @Override
    public int compareTo(Company other) {
        final CompareToBuilder ctb = new CompareToBuilder();
        ctb.append(this.getDeveloper(), other.getDeveloper());
        ctb.append(this.getEditor(), other.getEditor());
        return ctb.toComparison();
    }
}
