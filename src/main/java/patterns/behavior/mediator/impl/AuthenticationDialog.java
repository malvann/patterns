package patterns.behavior.mediator.impl;

import patterns.behavior.mediator.Mediator;

public class AuthenticationDialog implements Mediator {
    private String title;
    private String login;
    private String password;
    private boolean isRegistered;

    public AuthenticationDialog(String title, String login, String password, boolean isRegistered) {
        this.title = title;
        this.login = login;
        this.password = password;
        this.isRegistered = isRegistered;
    }

    @Override
    public void notifyComponent() {

    }
}
