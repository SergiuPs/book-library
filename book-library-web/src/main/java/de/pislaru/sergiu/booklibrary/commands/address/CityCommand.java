package de.pislaru.sergiu.booklibrary.commands.address;

import de.pislaru.sergiu.booklibrary.model.address.Region;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

public class CityCommand {

    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private Region region;

    public CityCommand() {
    }

    public CityCommand(String name, Region region) {
        this.name = name;
        this.region = region;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public Region getRegion() {return region;}

    public void setRegion(Region region) {this.region = region;}

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass() || !super.equals(object)) {
            return false;
        }

        CityCommand city = (CityCommand) object;

        return Objects.equals(id, city.id) &&
                Objects.equals(name, city.name) &&
                Objects.equals(region, city.region);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, region);
    }

    @Override
    public String toString() {
        return "CityCommand {"
                + "id=" + id
                + ", name=" + name
                + ", region=" + region.getName()
                + "}";
    }
}
