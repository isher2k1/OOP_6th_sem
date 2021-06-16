package com.databases.server.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SalePK implements Serializable {
    @Column(name = "upc")
    private String upc;
    @Column(name = "check_number")
    private String checkNumber;

    public SalePK() {
    }

    public SalePK(String upc, String checkNumber) {
        this.upc = upc;
        this.checkNumber = checkNumber;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalePK salePK = (SalePK) o;
        return Objects.equals(upc, salePK.upc) && Objects.equals(checkNumber, salePK.checkNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(upc, checkNumber);
    }
}
