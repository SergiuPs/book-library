package de.pislaru.sergiu.booklibrary.commands.address;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

public class AddressCommand {

    private Long id;

    private CityCommand city;

    @NotBlank
    private String zip;

    @NotBlank
    private String street;

    public AddressCommand() {
    }

    public Long getId() {return id;}

    public void setId(Long id) {
        this.id = id;
    }


    public String getZip() {return zip;}

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getStreet() {return street;}

    public void setStreet(String street) {
        this.street = street;
    }

    public CityCommand getCity() {return city;}

    public void setCity(CityCommand city) {this.city = city;}

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass() || !super.equals(object)) {
            return false;
        }

        AddressCommand address = (AddressCommand) object;

        return Objects.equals(id, address.id) &&
                Objects.equals(city, address.city) &&
                Objects.equals(zip, address.zip) &&
                Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city.hashCode(), zip, street);
    }

    @Override
    public String toString() {
        return "AddressCommand {"
                + "id=" + id
                + ", city=" + city.getName()
                + ", region=" + city.getRegion()
                + ", zip=" + zip
                + ", street=" + street
                + "}";
    }
}
