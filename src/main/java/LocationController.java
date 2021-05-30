public class LocationController {
    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }



    public String addNewLocation(String city, String region, String country, float latitude, float longitude) {
        try {
            Location newLocation = locationService.addNewLocation(city, region, country, latitude, longitude);
            // todo use object mapper
            return  newLocation.getCity() + " " + newLocation.getRegion() + " " + newLocation.getCountry()
                    + " " + newLocation.getLatitude() + " " + newLocation.getLongitude();
        } catch (Exception e) {
            return "{\"error message\": \"" + e.getMessage() + "\"}";
        }
    }
}

