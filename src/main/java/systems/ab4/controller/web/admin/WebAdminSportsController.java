package systems.ab4.controller.web.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import systems.ab4.model.Sport;
import systems.ab4.service.SportService;

import java.util.List;

/**
 * Created by radug on 6/17/2017.
 */
@RestController
@RequestMapping("/admin")
public class WebAdminSportsController {

    private final SportService sportService;
    @Autowired
    public WebAdminSportsController(SportService sportService){
        this.sportService = sportService;
    }

    @GetMapping("/sports")
    public List<Sport> getAllSports(){
        return sportService.getAllSports();
    }

    @PostMapping("/sports")
    public void addSport(@RequestBody Sport sport){
        sportService.addSport(sport);
    }
}
