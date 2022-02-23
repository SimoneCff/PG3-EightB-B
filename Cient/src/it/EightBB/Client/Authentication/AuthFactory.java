package it.EightBB.Client.Authentication;

import it.EightBB.Client.Authentication.TextArea.SelectRegistrationType;
import it.EightBB.Client.Interface.Factory.AbstractFactory;
import it.EightBB.Client.Authentication.Button.RegConfirm;
import it.EightBB.Client.Authentication.Button.RegistrationB;
import it.EightBB.Client.Authentication.Form.Login;
import it.EightBB.Client.Authentication.Form.Register;
import it.EightBB.Client.Authentication.Form.RegisterO;
import it.EightBB.Client.Interface.SwingInt.Button;
import it.EightBB.Client.Interface.SwingInt.Form;
import it.EightBB.Client.Interface.SwingInt.TextGroup;

public class AuthFactory implements AbstractFactory {

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

    @Override
    public TextGroup makeText(String type) {
        return new SelectRegistrationType();
    }


}
