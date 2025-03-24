package fr.polytech.sim.utils;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Simplified dependency injection context.
 */
public class Context {

    /**
     * Provide an instance of the class passed in parameter if a service
     * provider exists for that class. If no such a provider exists, the method
     * return null.
     *
     * @param klass expected injection type
     * @return      instance provided by first service provider, null if none
     * @param <T>   expected instance type
     */
    public static <T> T inject(Class<T> klass) {
        Iterator<T> iterator = ServiceLoader.load(klass).iterator();
        if (iterator.hasNext()) {
            return iterator.next();
        }
        return null;
    }
}
