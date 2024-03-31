package util;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import model.Course;
import model.CourseDefinition;
import model.Semester;

public class HibernateUtilCourseDefinition {

    private static SessionFactory sessionFactory;

    public static synchronized SessionFactory getSessionFactory() {
        if (sessionFactory == null) { // Check for null only (isClosed() might be unnecessary here)
            try {
                Configuration configuration = new Configuration();

                // Hibernate settings
                Properties settings = new Properties();
                // ... (set your driver, URL, user, password, dialect, etc.)
              
                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver"); // Replace with your driver
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/23668_mid?useSSL=false"); // Replace with your details
                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, ""); // Password if needed
                // **New line:**
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect"); // Replace with your dialect
                settings.put(Environment.SHOW_SQL, "true"); // Enable SQL logging for debugging (optional)
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                settings.put(Environment.HBM2DDL_AUTO, "update");

                configuration.setProperties(settings);
                // Ensure both entities are added
                configuration.addAnnotatedClass(Course.class);
                configuration.addAnnotatedClass(Semester.class);
                configuration.addAnnotatedClass(CourseDefinition.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                // Handle exceptions properly, log errors, and potentially rethrow
                // Consider logging detailed messages for debugging
                throw new RuntimeException("Error creating SessionFactory: " + e.getMessage(), e);
            }
        }
        return sessionFactory;
    }

    public static Session getSession() {
        // Ensure sessionFactory is initialized before attempting to open a session
        if (sessionFactory == null) {
            sessionFactory = getSessionFactory();
        }
        return sessionFactory.getCurrentSession(); // Use getCurrentSession() for thread-bound sessions
    }

    public static void closeSessionFactory() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
