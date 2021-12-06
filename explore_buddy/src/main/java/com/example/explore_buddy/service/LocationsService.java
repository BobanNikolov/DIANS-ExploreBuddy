package com.example.explore_buddy.service;

import com.example.explore_buddy.model.Location;
import com.example.explore_buddy.model.enumeration.LocationType;
import com.example.explore_buddy.repository.LocationsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationsService implements ILocationsService {
//    @Autowired
    private LocationsRepository locationsRepository;
    public LocationsService(LocationsRepository locationsRepository){
        this.locationsRepository=locationsRepository;
    }
    @Override
    public List<Location> getAll() {
        return locationsRepository.findAll();
    }

    @Override
    public void post(Location location) {
        locationsRepository.save(location);
    }

    @Override
    public List<Location> getByName(String name) {
        return locationsRepository.findByName(name);
    }

    @Override
    public List<Location> getAllByType(String type) {
        return locationsRepository.findAllByLocationType(LocationType.valueOf(type));
    }

    @Override
    public List<Location> getFavourites() {
        return locationsRepository.findByFavourite(true);
    }

    @Override
    public void updateLocation(Integer id) {
        Location toupdate=locationsRepository.findById(id).orElse(null);
        if(toupdate!=null)
        {
            if(toupdate.getFavourite())
                toupdate.setFavourite(false);
            else
                toupdate.setFavourite(true);
            locationsRepository.save(toupdate);
        }
    }

    @Override
    public List<Location> getAllByNameSearch(String name) {
//        Streamable<Location> result = locationsRepository.findByNameContaining(name);
//        return result.toList();
        return locationsRepository.findByNameContains(name);
    }

}
