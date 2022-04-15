package ro.ubb.catalog.web.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.catalog.core.model.Location;
import ro.ubb.catalog.core.service.LocationService;
import ro.ubb.catalog.web.converter.LocationConverter;
import ro.ubb.catalog.web.dto.LocationDTO;
import ro.ubb.catalog.web.dto.LocationsDTO;

import java.util.List;
import java.util.Set;

@RestController
public class LocationController {
    private static final Logger log = LoggerFactory.getLogger(LocationController.class);

    @Autowired
    private LocationService locationService;

    @Autowired
    private LocationConverter locationConverter;

    @RequestMapping(value = "/locations")
    LocationsDTO getAllStudents() {
        //todo: logs
        List<Location> locations = locationService.getAllSLocation();
        Set<LocationDTO> dtos = locationConverter.convertModelsToDtos(locations);
        return new LocationsDTO(dtos);
    }

    @RequestMapping(value = "/locations", method = RequestMethod.POST)
    LocationDTO saveLocation(@RequestBody LocationDTO dto) {
        log.trace("saveLocation: dto={}", dto);
        return locationConverter.convertModelToDto(locationService.saveLocation(
                locationConverter.convertDtoToModel(dto)
        ));
    }

    @RequestMapping(value = "/locations/{id}", method = RequestMethod.PUT)
    LocationDTO updateLocation(@PathVariable Long id, @RequestBody LocationDTO dto) {
        //todo: logs
        return locationConverter.convertModelToDto(
                locationService.updateLocation(
                        id,
                        locationConverter.convertDtoToModel(dto)));
    }

    @RequestMapping(value = "/locations/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteLocation(@PathVariable Long id) {
        locationService.deleteLocation(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
