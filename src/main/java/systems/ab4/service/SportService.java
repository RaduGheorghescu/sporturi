package systems.ab4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import systems.ab4.model.Sport;
import systems.ab4.repository.SportRepository;

import java.util.List;

/**
 * Created by radug on 6/17/2017.
 */

@Service
public class SportService {
    private final SportRepository sportRepository;

    @Autowired
    public SportService(SportRepository sportRepository){
        this.sportRepository = sportRepository;
    }

    public List<Sport> getAllSports(){
        return sportRepository.findAll();
    }

    public Sport findSportById(Long id){
        return sportRepository.findOne(id);
    }

    public Sport findBySportName(String sportName){
        return sportRepository.findBySportName(sportName);
    }

    public void addSport(Sport sport){
        sportRepository.save(sport);
    }
}
