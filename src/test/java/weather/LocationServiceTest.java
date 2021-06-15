package weather;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class LocationServiceTest {

    LocationService locationService;


    public void function() {
        LocationRepository locationRepository = new LocationRepositoryMock();
        locationService = new LocationService(locationRepository);
    }

    @Test
    public void addNewLocation_countryIsEmpty(){
            //given
        //when
           Location result = locationService.addNewLocation("xxx", "xx", "", 45, 56);
            //then
            assertThat(result.getCountry().isEmpty());
    }
}
