package de.pislaru.sergiu.booklibrary.model.address;

import de.pislaru.sergiu.booklibrary.model.BaseEntity;

import java.io.Serializable;
import java.util.Objects;

public class Address extends BaseEntity implements Serializable {

    private City city;
    private String zip;
    private String street;

    public Address() {
    }

    public Address(City city, String zip, String street) {
        this.city = city;
        this.zip = zip;
        this.street = street;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass() || !super.equals(object)) {
            return false;
        }

        Address address = (Address) object;

        return Objects.equals(city, address.city) &&
                Objects.equals(zip, address.zip) &&
                Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), city.hashCode(), zip, street);
    }

    @Override
    public String toString() {
        return "Address {"
                + "city=" + city.getName()
                + ", region=" + city.getRegion()
                + ", zip=" + zip
                + ", street" + street
                + "}"
                + super.toString();
    }
}
