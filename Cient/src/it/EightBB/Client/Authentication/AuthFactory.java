package it.EightBB.Client.Authentication;

import it.EightBB.Client.AbstractFactory;
import it.EightBB.Client.Authentication.Button.LoginB;
import it.EightBB.Client.Authentication.Form.Login;
import it.EightBB.Client.SwingBB.Button;
import it.EightBB.Client.SwingBB.Form;


public class AuthFactory implements AbstractFactory {
    private AuthFactory Instance;
    private boolean True;


    @Override
    public AuthFactory getInstance() {
        if (Instance==null){
            Instance = new AuthFactory();
        }
        return Instance;
    }

    @Override
    public Form makeForm(String Type) {
        Form ft = null;
        if (Type.equals("Login")){
            ft = new Login();
        }
        return ft;
    }

    @Override
    public Button makeButton(String Type) {
        Button bt = null;
        if (Type.equals("Login")) {
            bt = new LoginB();
        }
        return bt;
    }


}
