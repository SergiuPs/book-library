package de.pislaru.sergiu.booklibrary.commands.address;

import de.pislaru.sergiu.booklibrary.commands.BaseEntityCommand;
import de.pislaru.sergiu.booklibrary.commands.UserCommand;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

public class AddressCommand extends BaseEntityCommand {

    @NotNull
    private CityCommand city;

    @Size(min = 1, max = 25)
    private String zip;

    @Size(min = 3, max = 255)
    private String street;

    private UserCommand userCommand;

    public AddressCommand() {
    }

    public String getZip() {return zip;}
    public void setZip(String zip) {this.zip = zip;}
    public String getStreet() {return street;}
    public void setStreet(String street) {this.street = street;}
    public CityCommand getCity() {return city;}
    public void setCity(CityCommand city) {this.city = city;}
    public UserCommand getUserCommand() {return userCommand;}
    public void setUserCommand(UserCommand userCommand) {this.userCommand = userCommand;}

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass() || !super.equals(object)) {
            return false;
        }

        AddressCommand address = (AddressCommand) object;

        return  Objects.equals(city, address.city) &&
                Objects.equals(userCommand, address.userCommand) &&
                Objects.equals(zip, address.zip) &&
                Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), city.hashCode(), zip, street);
    }

    @Override
    public String toString() {
        return "AddressCommand {"
                + "city=" + city.getName()
                + ", region=" + city.getRegion()
                + ", zip=" + zip
                + ", street=" + street
                + "}"
                + super.toString();
    }
}
