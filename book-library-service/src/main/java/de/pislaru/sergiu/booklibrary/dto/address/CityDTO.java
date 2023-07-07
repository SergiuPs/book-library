package de.pislaru.sergiu.booklibrary.dto.address;

import de.pislaru.sergiu.booklibrary.model.address.Region;

import java.util.Objects;

public class CityDTO {

    private Long id;
    private String name;
    private Region region;

    public CityDTO() {
    }
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof CityDTO that)) {
            return false;
        }

        return  Objects.equals(this.id, that.id) &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.region, that.region);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, region);
    }

    @Override
    public String toString() {
        return "CityDTO {"
                + "id=" + id
                + ", name=" + name
                + ", region=" + region.getName()
                + "}";
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public Region getRegion() {return region;}
    public void setRegion(Region region) {this.region = region;}
}
