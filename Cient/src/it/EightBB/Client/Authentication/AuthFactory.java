package it.EightBB.Client.Authentication;

import it.EightBB.Client.Authentication.Button.*;
import it.EightBB.Client.Authentication.TextArea.SelectRegistrationType;
import it.EightBB.Client.Interface.Factory.AbstractFactory;
import it.EightBB.Client.Authentication.Form.Login;
import it.EightBB.Client.Authentication.Form.Register;
import it.EightBB.Client.Authentication.Form.RegisterO;
import it.EightBB.Client.Interface.Template.Button;
import it.EightBB.Client.Interface.Template.Form;
import it.EightBB.Client.Interface.Template.TextGroup;

/**
 *classe che va ad implementare una Concrete Factory che va ad implementare Abstract Factory
 * La classe è responsabile di tutti i form bottoni del sottosistema Authentication
 * {@param AuthFactory} parametro di implementazione di AbstractFactory
 */
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

    /**
     *
     * @param Type tipo di stringa per il Button
     * @return ritorno alla selezione del tipo di registrazione o al login
     */
    @Override
    public Button makeButton(String Type) {

       return switch (Type) {
            case "Registration" ->new RegistrationB();
            case "SelectC" -> new SelectClient();
            case "SelectO" -> new SelectOwner();
            case "ReturnS" -> new ReturnSel();
            case "ReturnL" -> new ReturnLog();
            default -> null;
        };
    }

    /**
     *
     * @param type tipo di stringa per il button
     * @return ritorno alla scelta del tipo di registrazione
     */
    @Override
    public TextGroup makeText(String type) {
        return switch (type){
          case "Select" -> new SelectRegistrationType();
            default -> null;
        };
    }

}
