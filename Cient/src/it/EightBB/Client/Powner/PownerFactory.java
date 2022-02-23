package it.EightBB.Client.Powner;

import it.EightBB.Client.Interface.Factory.AbstractFactory;
import it.EightBB.Client.Interface.Template.Button;
import it.EightBB.Client.Interface.Template.Form;
import it.EightBB.Client.Interface.Template.TextGroup;
import it.EightBB.Client.Powner.Button.*;
import it.EightBB.Client.Powner.TextArea.PrivateOwner;

public class PownerFactory implements AbstractFactory {
    @Override
    public Form makeForm(String type) {
        return null;
    }

    @Override
    public Button makeButton(String type) {
        return switch (type){
            case "AllOwnStruct" -> new AllOwnerStructures();
            case "ClientReg" -> new ClientRegistration();
            case "Econm" -> new EconomicManagement();
            case "Exit" -> new ExitO();
            case "Mod" -> new ModifyProfileO();
            case "PrivAreaEnt" -> new PrivateAreaEntities();
            case "RegStruct" -> new RegisterStructure();
            default -> null;
        };

    }

    @Override
    public TextGroup makeText(String type) {
        return switch (type){
            case "Private" -> new PrivateOwner();
            default -> null;
        };
    }
}
