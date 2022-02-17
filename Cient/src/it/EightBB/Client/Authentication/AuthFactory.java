package it.EightBB.Client.Authentication;
import it.EightBB.Client.AbstractFactory;
import it.EightBB.Client.SwingBB.Frame;

import javax.swing.*;

public class AuthFactory implements AbstractFactory {
    private AuthFactory Instance;
    private static Frame ft = null;

    @Override
    public AuthFactory getInstance() {
        if (Instance==null){
            Instance = new AuthFactory();
        }
        return Instance;
    }

    @Override
    public Frame makeFrame(String Type) {
        if (Type.equals("Login")){
            ft = new Login();
        }
        return ft;
    }

}
