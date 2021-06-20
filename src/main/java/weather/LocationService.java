package weather;

public class LocationService {
    private final LocationRepository locationRepository;
    private LocationValidation locationValidation;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }


    public Location addNewLocation(String city, String region, String country, Double latitude, Double longitude) {
           locationValidation.validate();
            // todo more data validations
        Location location = new Location(null, city, region, country, latitude, longitude);
            // todo region -> "   "
            //  set region if value is correct newLocation.setRegion(value);
            // streams Optional.ofNullable(region).filter(...).ifPresent(...);

        return locationRepository.save(location);
    }
}

