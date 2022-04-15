package ro.ubb.catalog.core.service;



import ro.ubb.catalog.core.model.Location;

import java.util.List;

public interface LocationService {

    Location saveLocation(Location entity);

    List<Location> getAllSLocation();

    Location updateLocation(Long id, Location newLocation);

    void deleteLocation(Long id);
}
