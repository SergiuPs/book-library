package de.pislaru.sergiu.booklibrary.model.address;

import de.pislaru.sergiu.booklibrary.model.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class City extends BaseEntity {

    @Size(min = 1, max = 100)
    private String name;

    @Enumerated(value = EnumType.STRING)
    @NotNull
    private Region region;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "city", targetEntity = Address.class)
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
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass() || !super.equals(object)) {
            return false;
        }

        City city = (City) object;

        return Objects.equals(name, city.name) &&
                Objects.equals(region, city.region);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, region);
    }

    @Override
    public String toString() {
        return "City {"
                + "name=" + name
                + ", region=" + region.getName()
                + "}"
                + super.toString();
    }
}
