public class LocationService {
    private final LocationRepository locationRepository;


    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    Location addNewLocation(String city, String region, String country, float latitude, float longitude) {
        if (city == null || city.isEmpty()) {
            throw new RuntimeException("Tytul nie moze byc pusty");
        }
        if (country == null || country.isEmpty()) {
            throw new RuntimeException("Content nie moze byc pusty");
        }

        Location location = new Location(null, city, region, country, latitude, longitude);

        return locationRepository.save(location);
    }
}

