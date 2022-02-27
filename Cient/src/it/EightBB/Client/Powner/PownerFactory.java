package it.EightBB.Client.Powner;

import it.EightBB.Client.Interface.Factory.AbstractFactory;
import it.EightBB.Client.Interface.Template.Button;
import it.EightBB.Client.Interface.Template.Form;
import it.EightBB.Client.Interface.Template.TextGroup;
import it.EightBB.Client.Powner.Button.*;
import it.EightBB.Client.Powner.Form.*;
import it.EightBB.Client.Powner.TextArea.PrivateOwner;

public class PownerFactory implements AbstractFactory {
    @Override
    public Form makeForm(String type) {
        return switch (type){
            case "ModRegStr" -> new ModifyRegisteredStructure();
            case "RegNewStr" -> new RegisterNewStructure();
            case "Mod" -> new ModifyProfile();
            case "Client" -> new RegClientLive();
            case "Doc" -> new DocumentTourism();
            default -> null;
        };
    }

    @Override
    public Button makeButton(String type) {
        return switch (type){
            case "AllOwnStruct" -> new AllOwnerStructures();
            case "Econm" -> new EconomicManagement();
            case "Mod" -> new ModifyProfileO();
            case "PrivAreaEnt" -> new PrivateAreaEntities();
            case "RegStruct" -> new RegisterStructure();
            case "ModBack" -> new GoBackO();
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
