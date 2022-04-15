package ro.ubb.catalog.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ubb.catalog.core.model.Location;
import ro.ubb.catalog.core.repository.ILocationRepository;


import java.util.List;
@Service
public class LocationServiceImpl implements LocationService {

    private static final Logger log = LoggerFactory.getLogger(LocationServiceImpl.class);


    @Autowired
    private ILocationRepository iLocationRepository;


    @Override
    public Location saveLocation(Location entity) {
        log.trace("save: location={}", entity);
        Location result = iLocationRepository.save(entity);
        log.trace("save: location={}", result);
        return result;
    }

    @Override
    public List<Location> getAllSLocation() {
        log.trace("getAllLocation ----- method started");
        List<Location> locations = iLocationRepository.findAll();
        log.trace("getAllLocation: result() ----- method started", locations);

        return locations;
    }

    @Transactional
    @Override
    public Location updateLocation(Long id, Location newLocation) {
        Location update = iLocationRepository.findById(id).orElseThrow();
        update.setName(newLocation.getName());
        update.setAltitude(newLocation.getAltitude());
        update.setTypeOfHike(newLocation.getTypeOfHike());
        update.setCoordinates(newLocation.getCoordinates());
        update.setCity(newLocation.getCity());
        return  update;
    }

    @Override
    public void deleteLocation(Long id) {

        log.trace("delete: id={}", id);
        iLocationRepository.deleteById(id);
        log.trace("delete --- method finished");

    }
}
