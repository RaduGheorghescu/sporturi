package systems.ab4.controller.mobile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import systems.ab4.model.LocationSport;
import systems.ab4.service.LocationService;

import java.util.Date;
import java.util.List;

/**
 * Created by radug on 6/17/2017.
 */
@RestController
@RequestMapping("/mobile")
public class MobileBestLocations {
    private final LocationService locationService;
    @Autowired
    public MobileBestLocations(LocationService locationService){
        this.locationService = locationService;
    }
    @GetMapping("/bestLocations")
    public List<LocationSport> findBestLocations(@RequestParam(value = "sport", required = true) String[] sports,
                                                 @RequestParam(value = "startDate", required = true) @DateTimeFormat(pattern = "dd/MM/yyyy") Date startDate,
                                                 @RequestParam(value = "endDate", required = true) @DateTimeFormat(pattern = "dd/MM/yyyy") Date endDate){
        return locationService.findBestLocations(sports,startDate,endDate);
    }
}
