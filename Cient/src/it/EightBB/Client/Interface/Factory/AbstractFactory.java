package it.EightBB.Client.Interface.Factory;


import it.EightBB.Client.Interface.SwingInt.Button;
import it.EightBB.Client.Interface.SwingInt.Form;
import it.EightBB.Client.Interface.SwingInt.TextGroup;

public abstract interface AbstractFactory{

    //Instance
    public static AbstractFactory getInstance() {
        return null;
    }
    //Make
    public Form makeForm(String type);
    public Button makeButton(String type);
    public TextGroup makeText(String type);


}


