package weather;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class LocationRepositoryImpl implements LocationRepository{

    private SessionFactory sessionFactory;

    public LocationRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

//    public LocationRepositoryImpl(){
//        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
//        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
//    }

    @Override
    public Location save(Location location) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(location);

        transaction.commit();
        session.close();

        return location;
    }
}
