package de.pislaru.sergiu.booklibrary.commands.address;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

public class AddressCommand {

    private Long id;

    @NotBlank
    private CityCommand cityCommand;

    @NotBlank
    private String zip;

    @NotBlank
    private String street;

    public AddressCommand() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CityCommand getCityCommand() {
        return cityCommand;
    }

    public void setCityCommand(CityCommand cityCommand) {
        this.cityCommand = cityCommand;
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

        AddressCommand address = (AddressCommand) object;

        return Objects.equals(id, address.id) &&
                Objects.equals(cityCommand, address.cityCommand) &&
                Objects.equals(zip, address.zip) &&
                Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityCommand.hashCode(), zip, street);
    }

    @Override
    public String toString() {
        return "AddressCommand {"
                + "id=" + id
                + ", city=" + cityCommand.getName()
                + ", region=" + cityCommand.getRegion()
                + ", zip=" + zip
                + ", street" + street
                + "}";
    }
}
