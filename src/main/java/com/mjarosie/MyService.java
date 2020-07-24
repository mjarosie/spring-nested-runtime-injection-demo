package com.mjarosie;

public class MyService {
    private final MyAuthService myAuthService;
    private final String environment;

    public MyService(MyAuthService myAuthService, String environment) {
        this.myAuthService = myAuthService;
        this.environment = environment;
    }

    public void doSomething() {
        String token = myAuthService.getToken();
        callSomeApi(token);
    }

    private void callSomeApi(String token) {
        System.out.println("Calling " + this.environment + " API with token: " + token);
    }
}
