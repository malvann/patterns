package multithrading;

import java.util.logging.Logger;

public class Slipper {
    private static final Logger LOGGER = Logger.getLogger(Slipper.class.getName());

    public void sleep(long millis){
        try{
            Thread.sleep(millis);
        } catch (InterruptedException e){
            LOGGER.warning("Thread interrupted!" + e);
            Thread.currentThread().interrupt();
        }
    }
}
