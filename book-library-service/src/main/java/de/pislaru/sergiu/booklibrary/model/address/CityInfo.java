package de.pislaru.sergiu.booklibrary.model.address;

import de.pislaru.sergiu.booklibrary.model.BaseEntityInfo;

import java.util.Objects;

public class CityInfo extends BaseEntityInfo {

    private String name;
    private Region region;

    public CityInfo() {
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public Region getRegion() {return region;}
    public void setRegion(Region region) {
        this.region = region;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass() || !super.equals(object)) {
            return false;
        }

        CityInfo city = (CityInfo) object;

        return  Objects.equals(name, city.name) &&
                Objects.equals(region, city.region);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, region);
    }

    @Override
    public String toString() {
        return "CityInfo {"
                + "name=" + name
                + ", region=" + region.getName()
                + "}"
                + super.toString();
    }

}
