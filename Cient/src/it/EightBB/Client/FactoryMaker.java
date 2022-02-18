package it.EightBB.Client;

import it.EightBB.Client.Authentication.AuthFactory;

public class FactoryMaker {
    private static AbstractFactory fc = null;
    static AbstractFactory getFactory(String Choise) {
        if (Choise.equals("auth")) {
            System.out.println("Choose Auth");
            fc = new AuthFactory();
        }
        if (Choise.equals("bo")){ fc = null;}
        return fc;
    }
}
