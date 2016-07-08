package dk.langli.jensen;

public interface InstanceLocator {
    public Object findInstance(Class<?> clazz) throws InstantiationException, IllegalAccessException;
}
