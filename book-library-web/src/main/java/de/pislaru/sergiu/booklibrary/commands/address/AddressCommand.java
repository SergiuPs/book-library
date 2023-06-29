package de.pislaru.sergiu.booklibrary.commands.address;

import de.pislaru.sergiu.booklibrary.commands.BaseEntityCommand;
import de.pislaru.sergiu.booklibrary.commands.UserCommand;
import de.pislaru.sergiu.booklibrary.model.address.Recipient;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

public class AddressCommand extends BaseEntityCommand {

    @NotNull
    private Recipient recipient;

    @NotNull
    private CityCommand city;

    @Size(min = 1, max = 25)
    private String zip;

    @Size(min = 3, max = 255)
    private String street;

    private UserCommand userCommand;

    @NotNull
    private boolean defaultBillingAddress;

    @NotNull
    private boolean defaultShippingAddress;

    public AddressCommand() {
    }

    public Recipient getRecipient() {return recipient;}
    public void setRecipient(Recipient recipient) {this.recipient = recipient;}
    public String getZip() {return zip;}
    public void setZip(String zip) {this.zip = zip;}
    public String getStreet() {return street;}
    public void setStreet(String street) {this.street = street;}
    public CityCommand getCity() {return city;}
    public void setCity(CityCommand city) {this.city = city;}
    public UserCommand getUserCommand() {return userCommand;}
    public void setUserCommand(UserCommand userCommand) {this.userCommand = userCommand;}
    public boolean isDefaultBillingAddress() {return defaultBillingAddress;}
    public void setDefaultBillingAddress(boolean defaultBillingAddress) {this.defaultBillingAddress = defaultBillingAddress;}
    public boolean isDefaultShippingAddress() {return defaultShippingAddress;}
    public void setDefaultShippingAddress(boolean defaultShippingAddress) {this.defaultShippingAddress = defaultShippingAddress;}

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass() || !super.equals(object)) {
            return false;
        }

        AddressCommand that = (AddressCommand) object;

        return  Objects.equals(this.recipient, that.recipient) &&
                Objects.equals(this.city, that.city) &&
                Objects.equals(this.userCommand, that.userCommand) &&
                Objects.equals(this.zip, that.zip) &&
                Objects.equals(this.street, that.street) &&
                this.defaultBillingAddress == that.defaultBillingAddress &&
                this.defaultShippingAddress == that.defaultShippingAddress;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), recipient.hashCode(), city.hashCode(), zip, street);
    }

    @Override
    public String toString() {
        return "AddressCommand {"
                + "recipient=" + recipient.toString()
                + ", city=" + city.getName()
                + ", region=" + city.getRegion()
                + ", zip=" + zip
                + ", street=" + street
                + ", default-billing-address" + defaultBillingAddress
                + ", default-shipping-address" + defaultShippingAddress
                + "}"
                + super.toString();
    }
}
