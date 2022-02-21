package it.EightBB.Client;

import it.EightBB.Client.Authentication.AuthFactory;

public class FactoryMaker {
    private static AbstractFactory fc = null;
    private FactoryMaker Instance;

    public FactoryMaker getInstance() {
        if (Instance == null) {
            Instance = new FactoryMaker();
        }
        return Instance;
    }

    static AbstractFactory getFactory(String Choise) {
        if (Choise.equals("auth")) {
            fc = new AuthFactory();
        }
        if (Choise.equals("bo")) {
            fc = null;
        }
        return fc;
    }
}
