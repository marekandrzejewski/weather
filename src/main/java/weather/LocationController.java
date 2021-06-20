package weather;

import com.fasterxml.jackson.databind.ObjectMapper;

public class LocationController {
    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }



    public String addNewLocation(String city, String region, String country, Double latitude, Double longitude) {
        try {
            Location newLocation = locationService.addNewLocation(city, region, country, latitude, longitude);
            // todo use new object mapper alt+enter add maven dependency
            //  fail on unknown property - false
            ObjectMapper objectMapper = new ObjectMapper();
            return  newLocation.getCity() + " " + newLocation.getRegion() + " " + newLocation.getCountry()
                    + " " + newLocation.getLatitude() + " " + newLocation.getLongitude();
        } catch (Exception e) {
            return "{\"error message\": \"" + e.getMessage() + "\"}";
        }
    }
}

