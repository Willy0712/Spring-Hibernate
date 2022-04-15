package ro.ubb.catalog.web.converter;

import org.springframework.stereotype.Component;
import ro.ubb.catalog.core.model.Location;
import ro.ubb.catalog.web.dto.LocationDTO;


@Component
public class LocationConverter extends BaseConverter<Location, LocationDTO> {

    @Override
    public Location convertDtoToModel(LocationDTO dto) {
        Location location = new Location(dto.getName(), dto.getAltitude(), dto.getTypeOfHike(), dto.getCoordinates(), dto.getCity());
        location.setId(dto.getId());
        return location;
    }


    @Override
    public LocationDTO convertModelToDto(Location location) {
        LocationDTO locationDTO = new LocationDTO(location.getName(), location.getAltitude(), location.getTypeOfHike(), location.getCoordinates(), location.getCity());
        locationDTO.setId(location.getId());
        return locationDTO;
    }
}
