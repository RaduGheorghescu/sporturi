package systems.ab4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import systems.ab4.model.LocationSport;

import java.util.Date;
import java.util.List;

/**
 * Created by radug on 6/17/2017.
 */
public interface LocationSportRepository extends JpaRepository<LocationSport, Long> {
    List<LocationSport> findByStartDateGreaterThanEqualAndEndDateLessThanEqual(Date startDate, Date endDate);
}
