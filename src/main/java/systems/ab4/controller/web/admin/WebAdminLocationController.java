package systems.ab4.controller.web.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import systems.ab4.model.Location;
import systems.ab4.service.LocationService;

import java.util.Date;
import java.util.List;

/**
 * Created by radug on 6/17/2017.
 */

@RestController
@RequestMapping("/admin")
public class WebAdminLocationController {
    private final LocationService locationService;
    @Autowired
    public WebAdminLocationController(LocationService locationService){
        this.locationService = locationService;
    }

    @GetMapping("/location/{id}")
    public Location getLocationByLocationName(@PathVariable("id") Long id){
        return locationService.findById(id);
    }

    @GetMapping("/locations")
    public List<Location> getAllLocations(){
        return locationService.findAllLocations();
    }

    @PostMapping("/locations")
    public void addLocation(@RequestBody Location location){
        locationService.save(location);
    }

    @PutMapping("/location/{id}")
    public void updateLocation(@RequestBody Location location, @PathVariable("id") Long id){
        locationService.update(location);
    }

    @DeleteMapping("/location/{id}")
    public void deleteLocation(@RequestBody Location location, @PathVariable("id") Long id){
        locationService.delete(id);
    }

    @PutMapping("/locations/{locationId}/{sportId}")
    public void addSportToLocation(@PathVariable("locationId") Long locationId, @PathVariable("sportId") Long sportId,
                                   @RequestParam(value = "startDate", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date startDate,
                                   @RequestParam(value = "endDate", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date endDate,
                                   @RequestParam(value = "price", required = false) Long price){
        locationService.addSportToLocation(locationId,sportId, startDate, endDate, price);

    }
}
