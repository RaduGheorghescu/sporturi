package systems.ab4.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by radug on 6/17/2017.
 */

@Entity
public class Sport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String sportName;

    @OneToMany
    private List<LocationSport> locationSportList;

    public Sport() {
        this.locationSportList = new ArrayList<>();
    }

    public Sport(String sportName) {
        this();
        this.sportName = sportName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }
}
