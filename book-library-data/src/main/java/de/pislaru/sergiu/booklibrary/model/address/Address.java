package de.pislaru.sergiu.booklibrary.model.address;

import com.fasterxml.jackson.annotation.JsonIgnore;
import de.pislaru.sergiu.booklibrary.model.BaseEntity;
import de.pislaru.sergiu.booklibrary.model.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
public class Address extends BaseEntity {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recipient_id", referencedColumnName = "id")
    private Recipient recipient;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = City.class)
    @JoinColumn(name = "city_id")
    @NotNull
    private City city;

    @Size(min = 1, max = 255)
    private String zip;

    @Size(min = 3, max = 255)
    private String street;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = User.class)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    @NotNull
    private User user;

    @Column(name = "def_bil_address")
    private boolean defaultBillingAddress;

    @Column(name = "def_ship_address")
    private boolean defaultShippingAddress;

    public Address() {
    }

    public Address(Recipient recipient, City city, String zip, String street, User user,
                   boolean defaultBillingAddress, boolean defaultShippingAddress) {
        this.recipient = recipient;
        this.city = city;
        this.zip = zip;
        this.street = street;
        this.user = user;
        this.defaultBillingAddress = defaultBillingAddress;
        this.defaultShippingAddress = defaultShippingAddress;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass() || !super.equals(object)) {
            return false;
        }

        Address that = (Address) object;

        return  Objects.equals(this.recipient, that.recipient) &&
                Objects.equals(this.city, that.city) &&
                Objects.equals(this.zip, that.zip) &&
                Objects.equals(this.street, that.street) &&
                this.defaultShippingAddress == that.defaultShippingAddress &&
                this.defaultBillingAddress == that.defaultBillingAddress;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), recipient.hashCode(), city.hashCode(),
                zip, street, defaultBillingAddress, defaultShippingAddress);
    }

    @Override
    public String toString() {
        return "Address {"
                + "recipient=" + recipient.toString()
                + ", city=" + city.getName()
                + ", region=" + city.getRegion()
                + ", zip=" + zip
                + ", street" + street
                + ", default-billing-address" + defaultBillingAddress
                + ", default-shipping-address" + defaultShippingAddress
                + "}"
                + super.toString();
    }

    public Recipient getRecipient() {return recipient;}
    public void setRecipient(Recipient recipient) {this.recipient = recipient;}
    public City getCity() {
        return city;
    }
    public void setCity(City city) {this.city = city;}
    public String getZip() {return zip;}
    public void setZip(String zip) {this.zip = zip;}
    public String getStreet() {return street;}
    public void setStreet(String street) {this.street = street;}
    public User getUser() {return user;}
    public void setUser(User user) {this.user = user;}
    public boolean isDefaultBillingAddress() {return defaultBillingAddress;}
    public void setDefaultBillingAddress(boolean defaultBillingAddress) {this.defaultBillingAddress = defaultBillingAddress;}
    public boolean isDefaultShippingAddress() {return defaultShippingAddress;}
    public void setDefaultShippingAddress(boolean defaultShippingAddress) {this.defaultShippingAddress = defaultShippingAddress;}
}
