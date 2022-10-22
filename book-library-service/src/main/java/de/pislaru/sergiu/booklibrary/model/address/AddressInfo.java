package de.pislaru.sergiu.booklibrary.model.address;

import java.util.Objects;

public class AddressInfo {

    private Long id;
    private CityInfo cityInfo;
    private String zip;
    private String street;

    public AddressInfo() {
    }

    public AddressInfo(Long id, CityInfo cityInfo, String zip, String street) {
        this.id = id;
        this.cityInfo = cityInfo;
        this.zip = zip;
        this.street = street;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CityInfo getCityInfo() {
        return cityInfo;
    }

    public void setCityInfo(CityInfo cityInfo) {
        this.cityInfo = cityInfo;
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

        AddressInfo address = (AddressInfo) object;

        return Objects.equals(id, address.id) &&
                Objects.equals(cityInfo, address.cityInfo) &&
                Objects.equals(zip, address.zip) &&
                Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityInfo.hashCode(), zip, street);
    }

    @Override
    public String toString() {
        return "AddressInfo {"
                + "id=" + id
                + ", city=" + cityInfo.getName()
                + ", region=" + cityInfo.getRegion()
                + ", zip=" + zip
                + ", street" + street
                + "}";
    }

}
