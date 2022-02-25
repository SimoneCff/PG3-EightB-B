package it.EightBB.Client.CEssentials;

import it.EightBB.Client.Authentication.AuthFactory;
import it.EightBB.Client.Interface.Factory.AbstractFactory;
import it.EightBB.Client.Pclient.PclientFactory;
import it.EightBB.Client.Powner.PownerFactory;

public class FactoryMaker {
    private static FactoryMaker Instance = null;

    public static FactoryMaker getInstance() {
        if (Instance == null) {
            Instance = new FactoryMaker();
        }
        return Instance;
    }

   public AbstractFactory getFactory(String Choise) {
        AbstractFactory fc = switch (Choise) {
            case "auth" -> new AuthFactory();
            case "pclient" -> new PclientFactory();
            case "powner" -> new PownerFactory();
            default -> null;
        };
        return fc;
    }
}
