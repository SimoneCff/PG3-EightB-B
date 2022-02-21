package it.EightBB.Client.Factory;

import it.EightBB.Client.Authentication.AuthFactory;

public class FactoryMaker {
    private static AbstractFactory fc = null;
    private static FactoryMaker Instance = null;

    public static FactoryMaker getInstance() {
        if (Instance == null) {
            Instance = new FactoryMaker();
        }
        return Instance;
    }

   public AbstractFactory getFactory(String Choise) {
        if (Choise.equals("auth")) {
            fc = new AuthFactory();
        }
        if (Choise.equals("bo")) {
            fc = null;
        }
        return fc;
    }
}
