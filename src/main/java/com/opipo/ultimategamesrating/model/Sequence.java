package com.opipo.ultimategamesrating.model;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.data.annotation.Id;

public class Sequence implements Comparable<Sequence > {
    @Id
    private String id;
    private Integer seq;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    @Override
    public int hashCode() {
        final HashCodeBuilder hcb = new HashCodeBuilder();
        hcb.append(getId());
        hcb.append(getSeq());
        return hcb.toHashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Sequence)) {
            return false;
        }
        final Sequence other = (Sequence) object;
        final EqualsBuilder eqb = new EqualsBuilder();
        eqb.append(this.getId(), other.getId());
        eqb.append(this.getSeq(), other.getSeq());
        return eqb.isEquals();
    }

    @Override
    public int compareTo(Sequence other) {
        final CompareToBuilder ctb = new CompareToBuilder();
        ctb.append(this.getId(), other.getId());
        ctb.append(this.getSeq(), other.getSeq());
        return ctb.toComparison();
    }

}