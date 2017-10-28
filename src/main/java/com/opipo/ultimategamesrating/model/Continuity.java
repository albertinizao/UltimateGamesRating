package com.opipo.ultimategamesrating.model;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.List;

public class Continuity implements Comparable<Continuity> {
    private String saga;
    private Integer position;
    private List<String> expansion;
    private List<String> DLC;

    public String getSaga() {
        return saga;
    }

    public void setSaga(String saga) {
        this.saga = saga;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public List<String> getExpansion() {
        return expansion;
    }

    public void setExpansion(List<String> expansion) {
        this.expansion = expansion;
    }

    public List<String> getDLC() {
        return DLC;
    }

    public void setDLC(List<String> DLC) {
        this.DLC = DLC;
    }

    @Override
    public int hashCode() {
        final HashCodeBuilder hcb = new HashCodeBuilder();
        hcb.append(getSaga());
        hcb.append(getPosition());
        hcb.append(getExpansion());
        hcb.append(getDLC());
        return hcb.toHashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Continuity)) {
            return false;
        }
        final Continuity other = (Continuity) object;
        final EqualsBuilder eqb = new EqualsBuilder();
        eqb.append(this.getSaga(), other.getSaga());
        eqb.append(this.getPosition(), other.getPosition());
        eqb.append(this.getExpansion(), other.getExpansion());
        eqb.append(this.getDLC(), other.getDLC());
        return eqb.isEquals();
    }

    @Override
    public int compareTo(Continuity other) {
        final CompareToBuilder ctb = new CompareToBuilder();
        ctb.append(this.getSaga(), other.getSaga());
        ctb.append(this.getPosition(), other.getPosition());
        ctb.append(this.getExpansion(), other.getExpansion());
        ctb.append(this.getDLC(), other.getDLC());
        return ctb.toComparison();
    }
}
