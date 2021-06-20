package weather;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class LocationServiceTest {

    LocationService locationService;

@Before
    public void setUp() {
        LocationRepository locationRepository = new LocationRepositoryMock();
        locationService = new LocationService(locationRepository);
    }

    @Test
    public void addNewLocation_countryIsEmpty() {
        //given
        //when
        Location result = locationService.addNewLocation("xxx", "xx", "", 45.5, 56.7);
        //then
        assertThat(result.getCountry().isEmpty());
    }

    @Test
    public void addNewLocation_countryIsBlank() {
        //given
        //when
        Location result = locationService.addNewLocation("xxx", "xx", "    ", 45.5, 56.7);
        //then
        assertThat(result.getCountry().isBlank());
    }

    @Test
    public void addNewLocation_countryIsNull() {
        //given
        //when
        Location result = locationService.addNewLocation("xxx", "xx", null, 45.5, 56.7);
        //then
        assertThat(result.getCountry() == null);
    }

    @Test
    public void addNewLocation_cityIsEmpty() {
        //given
        //when
        Location result = locationService.addNewLocation("", "xx", "dsfds", 45.5, 56.7);
        //then
        assertThat(result.getCity().isEmpty());
    }

    @Test
    public void addNewLocation_cityIsBlank() {
        //given
        //when
        Location result = locationService.addNewLocation("     ", "xx", "fasd", 45.5, 56.7);
        //then
        assertThat(result.getCity().isBlank());
    }

    @Test
    public void addNewLocation_cityIsNull() {
        //given
        //when
        Location result = locationService.addNewLocation(null, "xx", "asdfsad", 45.5, 56.7);
        //then
        assertThat(result.getCity().equals(null));
    }


    @Test
    public void addNewLocation_latitudeIsNull() {
        //given
        //when
        Location result = locationService.addNewLocation("xxx", "xx", "xxxc", null, 56.1);
        //then
        assertThat(result.getLatitude().isNaN());
    }

    @Test
    public void addNewLocation_longitudeIsNull() {
        //given
        //when
        Location result = locationService.addNewLocation("xxx", "xx", "xxxc", 57.2, null);
        //then
        assertThat(result.getLongitude().isNaN());
    }

    @Test
    public void addNewLocation_latitudeIsTooHigh() {
        //given
        //when
        Location result = locationService.addNewLocation("xxx", "xx", "xxxc", 95.6, 56.1);
        //then
        assertThat(result.getLatitude() > 90);
    }
    @Test
    public void addNewLocation_latitudeIsTooLow() {
        //given
        //when
        Location result = locationService.addNewLocation("xxx", "xx", "xxxc", -105.6, 56.1);
        //then
        assertThat(result.getLatitude() < -90);
    }
    @Test
    public void whenShowingAllLocations_givenLocationList_thenShowAllLocations() {
        // when
        Location location = locationService.addNewLocation("Kielce", null, "Poland", 12.5, 45.7);
        List<Location> result = new ArrayList<>();
        result.add(location);

        // then
        assertThat(!result.isEmpty());
    }
}