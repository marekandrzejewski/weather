package weather;

public class LocationValidation {
    Location location;
    public void validate(){
        if (location.getCity() == null || location.getCity().isEmpty()
                || location.getCity().isBlank()) {
            throw new RuntimeException("Miasto nie moze byc puste");
        }
        if (location.getCountry() == null || location.getCountry().isEmpty()
                || location.getCountry().isBlank()) {
            throw new RuntimeException("Kraj nie moze byc pusty");
        }
        if (location.getLatitude() < -90 || location.getLatitude() > 90
                || location.getLatitude() == null || location.getLatitude().isNaN()){
            throw new RuntimeException("Nieprawidłowa szerokość geograficzna");
        }
        if (location.getLongitude() < -180 || location.getLongitude() > 180
                || location.getLongitude() == null || location.getLongitude().isNaN()) {
            throw new RuntimeException("Nieprawidłowa długość geograficzna");
        }

    }
}
