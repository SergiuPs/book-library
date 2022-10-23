package de.pislaru.sergiu.booklibrary.model.address;

import de.pislaru.sergiu.booklibrary.model.BaseEntity;
import de.pislaru.sergiu.booklibrary.model.User;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Address extends BaseEntity {

    @JoinColumn(name = "city_id")
    @ManyToOne(cascade = CascadeType.ALL, targetEntity = City.class)
    private City city;
    private String zip;
    private String street;

    @JoinColumn(name = "user_id", nullable = false)
    @ManyToOne(cascade = CascadeType.ALL, targetEntity = User.class)
    private User user;

    public Address() {
    }

    public Address(City city, String zip, String street, User user) {
        this.city = city;
        this.zip = zip;
        this.street = street;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
