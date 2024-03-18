package ch.heig.mcr.bouncers.display;

public final class DisplayerSingleton {

    private static Displayer instance;

    private DisplayerSingleton() throws Exception {
        throw new IllegalAccessException("This class should not be instantiated");
    }

    public static Displayer registerInstance(Class<? extends Displayer> impl) throws Exception {
        if (instance != null) {
            throw new Exception("Instance already registered");
        }

        instance = impl.getDeclaredConstructor().newInstance();
        return instance;
    }

    public static Displayer getInstance() {
        if (instance == null) {
            throw new IllegalStateException("Instance not registered");
        }

        return instance;
    }
}
