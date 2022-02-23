package it.EightBB.Client.Interface.Factory;


import it.EightBB.Client.Interface.Template.Button;
import it.EightBB.Client.Interface.Template.Form;
import it.EightBB.Client.Interface.Template.TextGroup;

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


