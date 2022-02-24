package it.EightBB.Client.Interface.Pclient;

import it.EightBB.Client.Authentication.TextArea.SelectRegistrationType;
import it.EightBB.Client.Interface.Factory.AbstractFactory;
import it.EightBB.Client.Interface.Template.Button;
import it.EightBB.Client.Interface.Template.Form;
import it.EightBB.Client.Interface.Template.TextGroup;
import it.EightBB.Client.Interface.Pclient.Button.ExitC;
import it.EightBB.Client.Interface.Pclient.Button.ModifyProfileC;
import it.EightBB.Client.Interface.Pclient.Form.PrenotationOne;
import it.EightBB.Client.Interface.Pclient.Form.RicercaLuogo;

public class PclientFactory implements AbstractFactory {

    @Override
    public Form makeForm(String type) {
        return switch(type) {
            case "Prenot" -> new PrenotationOne();
            case "Search" -> new RicercaLuogo();
            default -> null;
        };
    }

    @Override
    public Button makeButton(String type) {
        return switch(type) {
            case "exit" -> new ExitC();
            case "Modify" -> new ModifyProfileC();
            default -> null;
        };
    }

    @Override
    public TextGroup makeText(String type) {
        return  switch (type){
            case "Select" -> new SelectRegistrationType();
            default -> null;
        };
    }
}
