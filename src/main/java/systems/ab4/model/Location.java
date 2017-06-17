package systems.ab4.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by radug on 6/17/2017.
 */

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String locationName;

    @OneToMany
    private List<LocationSport> locationSports;

    public Location() {
        this.locationSports = new ArrayList<>();
    }

    public Location(String locationName) {
        this();
        this.locationName = locationName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public List<LocationSport> getLocationSports() {
        return locationSports;
    }

    public void setLocationSports(List<LocationSport> locationSports) {
        this.locationSports = locationSports;
    }
}
