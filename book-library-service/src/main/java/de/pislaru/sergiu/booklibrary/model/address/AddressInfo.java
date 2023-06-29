package de.pislaru.sergiu.booklibrary.model.address;

import de.pislaru.sergiu.booklibrary.model.BaseEntityInfo;
import de.pislaru.sergiu.booklibrary.model.UserInfo;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class AddressInfo extends BaseEntityInfo {

    private Recipient recipient;
    private CityInfo cityInfo;
    private String zip;
    private String street;
    @JsonIgnore
    private UserInfo userInfo;
    private boolean defaultBillingAddress;
    private boolean defaultShippingAddress;

    public AddressInfo() {
    }

    public Recipient getRecipient() {return recipient;}
    public void setRecipient(Recipient recipient) {this.recipient = recipient;}
    public CityInfo getCityInfo() {return cityInfo;}
    public void setCityInfo(CityInfo cityInfo) {this.cityInfo = cityInfo;}
    public String getZip() {return zip;}
    public void setZip(String zip) {this.zip = zip;}
    public String getStreet() {return street;}
    public void setStreet(String street) {this.street = street;}
    public UserInfo getUserInfo() {return userInfo;}
    public void setUserInfo(UserInfo userInfo) {this.userInfo = userInfo;}
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

        AddressInfo that = (AddressInfo) object;

        return  Objects.equals(this.recipient, that.recipient) &&
                Objects.equals(this.cityInfo, that.cityInfo) &&
                Objects.equals(this.userInfo, that.userInfo) &&
                Objects.equals(this.zip, that.zip) &&
                Objects.equals(this.street, that.street) &&
                this.defaultBillingAddress == that.defaultBillingAddress &&
                this.defaultShippingAddress == that.defaultShippingAddress;
    }

    @Override
    public int hashCode() {
        return  Objects.hash(super.hashCode(), recipient.hashCode(), cityInfo,
                zip, street, defaultBillingAddress, defaultShippingAddress);
    }

    @Override
    public String toString() {
        return "AddressInfo {"
                + "recipient=" + recipient.toString()
                + ", city=" + cityInfo.getName()
                + ", region=" + cityInfo.getRegion()
                + ", zip=" + zip
                + ", street" + street
                + ", default-billing-address" + defaultBillingAddress
                + ", default-shipping-address" + defaultShippingAddress
                + "}"
                + super.toString();
    }

}
