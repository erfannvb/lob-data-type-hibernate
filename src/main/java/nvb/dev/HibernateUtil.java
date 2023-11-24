package nvb.dev;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

    private HibernateUtil() {
    }

    private static final StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
            .configure("hibernate.cfg.xml").build();

    private static final Metadata metadata = new MetadataSources().getMetadataBuilder(serviceRegistry).build();

    private static final SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
