package de.pislaru.sergiu.booklibrary.commands.address;

import de.pislaru.sergiu.booklibrary.commands.BaseEntityCommand;
import de.pislaru.sergiu.booklibrary.commands.UserResponse;
import de.pislaru.sergiu.booklibrary.model.address.Recipient;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

public class AddressCommand implements Serializable {

    private Long id;
    private Recipient recipient;
    private CityCommand city;
    private String zip;
    private String street;
    private UserResponse userResponse;
    private boolean defaultBillingAddress;
    private boolean defaultShippingAddress;

    public AddressCommand() {
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof AddressCommand that)) {
            return false;
        }

        return  Objects.equals(this.id, that.id) &&
                Objects.equals(this.recipient, that.recipient) &&
                Objects.equals(this.city, that.city) &&
                Objects.equals(this.userResponse, that.userResponse) &&
                Objects.equals(this.zip, that.zip) &&
                Objects.equals(this.street, that.street) &&
                this.defaultBillingAddress == that.defaultBillingAddress &&
                this.defaultShippingAddress == that.defaultShippingAddress;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, recipient.hashCode(), city.hashCode(), zip, street);
    }

    @Override
    public String toString() {
        return "AddressCommand {"
                + "id=" + id
                + ", recipient=" + recipient.toString()
                + ", city=" + city.getName()
                + ", region=" + city.getRegion()
                + ", zip=" + zip
                + ", street=" + street
                + ", default-billing-address" + defaultBillingAddress
                + ", default-shipping-address" + defaultShippingAddress
                + "}";
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public Recipient getRecipient() {return recipient;}
    public void setRecipient(Recipient recipient) {this.recipient = recipient;}
    public String getZip() {return zip;}
    public void setZip(String zip) {this.zip = zip;}
    public String getStreet() {return street;}
    public void setStreet(String street) {this.street = street;}
    public CityCommand getCity() {return city;}
    public void setCity(CityCommand city) {this.city = city;}
    public UserResponse getUserResponse() {return userResponse;}
    public void setUserResponse(UserResponse userResponse) {this.userResponse = userResponse;}
    public boolean isDefaultBillingAddress() {return defaultBillingAddress;}
    public void setDefaultBillingAddress(boolean defaultBillingAddress) {this.defaultBillingAddress = defaultBillingAddress;}
    public boolean isDefaultShippingAddress() {return defaultShippingAddress;}
    public void setDefaultShippingAddress(boolean defaultShippingAddress) {this.defaultShippingAddress = defaultShippingAddress;}

}
