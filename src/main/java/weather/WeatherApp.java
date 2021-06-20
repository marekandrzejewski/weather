package weather;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class WeatherApp {
    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();

        SessionFactory sessionFactory = new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();

        LocationRepositoryImpl locationRepositoryImpl = new LocationRepositoryImpl(sessionFactory);
       // ForecastRepositoryImpl forecastRepositoryImpl = new ForecastRepositoryImpl(sessionFactory);

        LocationService locationService = new LocationService(locationRepositoryImpl);
        //ForecastService forecastService = new ForecastService(locationRepositoryImpl, forecastRepositoryImpl);

        LocationController locationController = new LocationController(locationService);
        //ForecastController forecastController = new ForecastController(forecastService);


//        UserInterface userInterface = new UserInterface(locationController, forecastController);
        UserInterface userInterface = new UserInterface(locationController);
        userInterface.run();

    }
}
