package it.EightBB.Client.Powner;

import it.EightBB.Client.Interface.Factory.AbstractFactory;
import it.EightBB.Client.Interface.SwingInt.Button;
import it.EightBB.Client.Interface.SwingInt.Form;
import it.EightBB.Client.Interface.SwingInt.TextGroup;

public class PownerFactory implements AbstractFactory {
    @Override
    public Form makeForm(String type) {
        return null;
    }

    @Override
    public Button makeButton(String type) {
        return null;
    }

    @Override
    public TextGroup makeText(String type) {
        return null;
    }
}
