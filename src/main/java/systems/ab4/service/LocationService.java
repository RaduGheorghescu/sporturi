package systems.ab4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import systems.ab4.exception.LocationNotFoundException;
import systems.ab4.exception.SportNotFoundException;
import systems.ab4.model.Location;
import systems.ab4.model.LocationSport;
import systems.ab4.model.Sport;
import systems.ab4.repository.LocationRepository;
import systems.ab4.repository.LocationSportRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by radug on 6/17/2017.
 */
@Service
public class LocationService {
    private final LocationRepository locationRepository;
    private final LocationSportRepository locationSportRepository;
    private final SportService sportService;
    @Autowired
    LocationService(LocationRepository locationRepository, LocationSportRepository locationSportRepository, SportService sportService){
        this.locationRepository = locationRepository;
        this.locationSportRepository = locationSportRepository;
        this.sportService = sportService;
    }

    public void save(Location location){
        locationRepository.save(location);
    }

    public void update(Location location){
        locationRepository.save(location);
    }

    public void delete(Long id){
        locationRepository.delete(id);
    }

    public List<Location> findAllLocations(){
        return locationRepository.findAll();
    }

    public Location findById(Long id){
        return locationRepository.findOne(id);
    }

    public void addSportToLocation(Long locationId, Long sportId, Date startDate, Date endDate, Long price){
        Location location = locationRepository.findOne(locationId);
        Sport sport = sportService.findSportById(sportId);

        if(location == null) throw new LocationNotFoundException();
        if(sport == null) throw new SportNotFoundException();
        locationSportRepository.save(new LocationSport(startDate,endDate,price,sport,location));
    }

    public List<LocationSport> findBestLocations(String[] sports, Date startDate, Date endDate){
        List<LocationSport> locationSportList = locationSportRepository.findByStartDateGreaterThanEqualAndEndDateLessThanEqual(
                startDate,endDate
        );
        List<Sport> sportList = null;
        for(int i=0; i<sports.length;i++){
            Sport sport = sportService.findBySportName(sports[i]);
            if(sport != null){
                sportList.add(sport);
            }
        }
        List<LocationSport> locationSportListForReturn= new ArrayList<>();
        locationSportList.forEach(locationSport -> {
            sportList.forEach(sport -> {
                if(locationSport.getSport().equals(sport) == true){
                    locationSport.setPrice(locationSport.getPrice() * Math.abs((endDate.getTime()-startDate.getTime())/86400000));
                    locationSportListForReturn.add(locationSport);
                }
            });
        });
        return locationSportListForReturn;
    }
}
