package it.EightBB.Client.Authentication;

import it.EightBB.Client.Authentication.Button.RegistrationB;
import it.EightBB.Client.Authentication.Button.SelectClient;
import it.EightBB.Client.Authentication.Button.SelectOwner;
import it.EightBB.Client.Authentication.TextArea.SelectRegistrationType;
import it.EightBB.Client.Interface.Factory.AbstractFactory;
import it.EightBB.Client.Authentication.Form.Login;
import it.EightBB.Client.Authentication.Form.Register;
import it.EightBB.Client.Authentication.Form.RegisterO;
import it.EightBB.Client.Interface.Template.Button;
import it.EightBB.Client.Interface.Template.Form;
import it.EightBB.Client.Interface.Template.TextGroup;

public class AuthFactory implements AbstractFactory {

    @Override
    public Form makeForm(String Type) {
        return switch (Type) {
            case "Login" -> new Login();
            case "Register" -> new Register();
            case "RegisterO" -> new RegisterO();
            default -> null;
        };
    }

    @Override
    public Button makeButton(String Type) {

       return switch (Type) {
            case "Registration" ->new RegistrationB();
            case "SelectC" -> new SelectClient();
            case "SelectO" -> new SelectOwner();
            default -> null;
        };
    }

    @Override
    public TextGroup makeText(String type) {
        return switch (type){
          case "Select" -> new SelectRegistrationType();
            default -> null;
        };
    }


}
