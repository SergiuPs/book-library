package de.pislaru.sergiu.booklibrary.domain.address;

import com.fasterxml.jackson.annotation.JsonIgnore;
import de.pislaru.sergiu.booklibrary.domain.BaseEntity;
import de.pislaru.sergiu.booklibrary.domain.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Address extends BaseEntity {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recipient_id")
    private Recipient recipient;

    @ManyToOne(cascade = CascadeType.MERGE, targetEntity = City.class)
    @JoinColumn(name = "city_id")
    @NotNull
    private City city;

    @Size(min = 1, max = 255)
    private String zip;

    @Size(min = 3, max = 255)
    private String street;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
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
    public String toString() {
        return "Address { "
                + super.toString()
                + ", recipient {" + recipient.toString()
                + "}, city {" + city.toString()
                + "}, zip=" + zip
                + ", street" + street
                + ", user" + user.getId()
                + ", default-billing-address" + defaultBillingAddress
                + ", default-shipping-address" + defaultShippingAddress
                + "}";
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
