package it.EightBB.Client;

import it.EightBB.Client.Authentication.AuthFactory;

public class FactoryMaker {
    private static AbstractFactory fc = null;
    static AbstractFactory getFactory(String choise) {
        if (choise.equals("auth")) {
            fc = new AuthFactory();
        }
        return fc;
    }
}
