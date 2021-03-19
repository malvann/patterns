package spring;

public class Business {
    private Client client;
    public EventLogger logger;

    public Business() {}

    public Business(Client client, EventLogger logger) {
        this.client = client;
        this.logger = logger;
    }

    public void logic(String msg){
        logger.logEvent(msg + " to " + client.getId());
    }
}
