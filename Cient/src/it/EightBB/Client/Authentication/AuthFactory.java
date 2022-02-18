package it.EightBB.Client.Authentication;
import it.EightBB.Client.AbstractFactory;
import it.EightBB.Client.Authentication.Form.Login;
import it.EightBB.Client.Authentication.Frame.LoginFrame;
import it.EightBB.Client.SwingBB.Form;
import it.EightBB.Client.SwingBB.Frame;

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
    public Frame makeFrame(String type){
        Frame frmt = null;
        if (type.equals("Login")){
            frmt = new LoginFrame();
        }
        return frmt;
    }

}