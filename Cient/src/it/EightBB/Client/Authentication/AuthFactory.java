package it.EightBB.Client.Authentication;
import it.EightBB.Client.AbstractFactory;
import it.EightBB.Client.SwingBB.Form;

import javax.swing.*;

public class AuthFactory implements AbstractFactory {
    private AuthFactory Instance;
    private static Form ft = null;
    private static JFrame frmt;


    @Override
    public AuthFactory getInstance() {
        if (Instance==null){
            Instance = new AuthFactory();
        }
        return Instance;
    }

    @Override
    public Form makeForm(String Type) {
        if (Type.equals("Login")){
            ft = new Login();
        }
        return ft;
    }

    @Override
    public JFrame makeFrame(String type){
        if (type.equals("Login")){
            frmt.setSize(400,400);
        }
        return frmt;
    }

}
