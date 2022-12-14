package de.pislaru.sergiu.booklibrary.model.address;

import de.pislaru.sergiu.booklibrary.model.BaseEntityInfo;
import de.pislaru.sergiu.booklibrary.model.UserInfo;
import java.util.Objects;

public class AddressInfo extends BaseEntityInfo {

    private CityInfo cityInfo;
    private String zip;
    private String street;
    private UserInfo userInfo;

    public AddressInfo() {
    }

    public CityInfo getCityInfo() {return cityInfo;}
    public void setCityInfo(CityInfo cityInfo) {this.cityInfo = cityInfo;}
    public String getZip() {return zip;}
    public void setZip(String zip) {this.zip = zip;}
    public String getStreet() {return street;}
    public void setStreet(String street) {this.street = street;}
    public UserInfo getUserInfo() {return userInfo;}
    public void setUserInfo(UserInfo userInfo) {this.userInfo = userInfo;}

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass() || !super.equals(object)) {
            return false;
        }

        AddressInfo address = (AddressInfo) object;

        return  Objects.equals(cityInfo, address.cityInfo) &&
                Objects.equals(userInfo, address.userInfo) &&
                Objects.equals(zip, address.zip) &&
                Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cityInfo, zip, street);
    }

    @Override
    public String toString() {
        return "AddressInfo {"
                + "city=" + cityInfo.getName()
                + ", region=" + cityInfo.getRegion()
                + ", zip=" + zip
                + ", street" + street
                + "}"
                + super.toString();
    }

}
