package it.EightBB.Client.Authentication;

import it.EightBB.Client.Factory.AbstractFactory;
import it.EightBB.Client.Authentication.Button.RegConfirm;
import it.EightBB.Client.Authentication.Button.RegistrationB;
import it.EightBB.Client.Authentication.Form.Login;
import it.EightBB.Client.Authentication.Form.Register;
import it.EightBB.Client.Authentication.Form.RegisterO;
import it.EightBB.Client.SwingBB.Button;
import it.EightBB.Client.SwingBB.Form;

public class AuthFactory implements AbstractFactory {
    private AuthFactory Instance;
    private boolean True;


    @Override
    public AuthFactory getInstance() {
        if (Instance == null) {
            Instance = new AuthFactory();
        }
        return Instance;
    }

    @Override
    public Form makeForm(String Type) {
        Form ft = switch (Type) {
            case "Login" -> new Login();
            case "Register" -> new Register();
            case "RegisterO" -> new RegisterO();
            default -> null;
        };
        return ft;
    }

    @Override
    public Button makeButton(String Type) {

        Button bt = switch (Type) {
            case "Registration" -> new RegistrationB();
            case "RegConfirm" -> new RegConfirm();
            default -> null;
        };
        return bt;
    }


}
