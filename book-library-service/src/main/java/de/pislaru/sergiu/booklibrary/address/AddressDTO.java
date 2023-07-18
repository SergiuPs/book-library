package de.pislaru.sergiu.booklibrary.address;

import java.util.Objects;

public class AddressDTO {

    private Long id;
    private Long version;
    private RecipientDTO recipient;
    private CityDTO city;
    private String zip;
    private String street;
    private boolean defaultBillingAddress;
    private boolean defaultShippingAddress;

    public AddressDTO() {
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof AddressDTO that)) {
            return false;
        }

        return  Objects.equals(this.id, that.id) &&
                Objects.equals(this.version, that.version) &&
                Objects.equals(this.recipient, that.recipient) &&
                Objects.equals(this.city, that.city) &&
                Objects.equals(this.zip, that.zip) &&
                Objects.equals(this.street, that.street) &&
                this.defaultBillingAddress == that.defaultBillingAddress &&
                this.defaultShippingAddress == that.defaultShippingAddress;
    }

    @Override
    public int hashCode() {
        return  Objects.hash(id, version, recipient.hashCode(), city.hashCode(),
                zip, street, defaultBillingAddress, defaultShippingAddress);
    }

    @Override
    public String toString() {
        return "AddressDTO {"
                + "id=" + id
                + ", version=" + version
                + ", recipient=" + recipient.toString()
                + ", city=" + city.getName()
                + ", region=" + city.getRegion()
                + ", zip=" + zip
                + ", street" + street
                + ", default-billing-address" + defaultBillingAddress
                + ", default-shipping-address" + defaultShippingAddress
                + "}";
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public Long getVersion() {return version;}
    public void setVersion(Long version) {this.version = version;}
    public CityDTO getCity() {return city;}
    public void setCity(CityDTO city) {this.city = city;}
    public RecipientDTO getRecipient() {return recipient;}
    public void setRecipient(RecipientDTO recipient) {this.recipient = recipient;}
    public String getZip() {return zip;}
    public void setZip(String zip) {this.zip = zip;}
    public String getStreet() {return street;}
    public void setStreet(String street) {this.street = street;}
    public boolean isDefaultBillingAddress() {return defaultBillingAddress;}
    public void setDefaultBillingAddress(boolean defaultBillingAddress) {this.defaultBillingAddress = defaultBillingAddress;}
    public boolean isDefaultShippingAddress() {return defaultShippingAddress;}
    public void setDefaultShippingAddress(boolean defaultShippingAddress) {this.defaultShippingAddress = defaultShippingAddress;}
}
