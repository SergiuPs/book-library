package de.pislaru.sergiu.booklibrary.domain.address;

import com.fasterxml.jackson.annotation.JsonIgnore;
import de.pislaru.sergiu.booklibrary.domain.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
public class City extends BaseEntity {

    @Size(min = 1, max = 100)
    private String name;

    @Enumerated(value = EnumType.STRING)
    @NotNull
    private Region region;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "city", targetEntity = Address.class, fetch = FetchType.LAZY)
    private Set<Address> addresses = new HashSet<>();

    public City() {
    }

    public City(String name, Region region) {
        this.name = name;
        this.region = region;
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public Region getRegion() {return region;}
    public void setRegion(Region region) {this.region = region;}
    public Set<Address> getAddresses() {return addresses;}
    public void setAddresses(Set<Address> addresses) {this.addresses = addresses;}

    @Override
    public String toString() {
        return "City { "
                + super.toString()
                + ", name=" + name
                + ", region=" + region.getName()
                + "}";
    }
}
