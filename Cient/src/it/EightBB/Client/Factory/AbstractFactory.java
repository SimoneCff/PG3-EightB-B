package it.EightBB.Client.Factory;


import it.EightBB.Client.SwingBB.Button;
import it.EightBB.Client.SwingBB.Form;

public abstract interface AbstractFactory{

    //Instance
    public AbstractFactory getInstance();

    //Make
    public Form makeForm(String type);
    public Button makeButton(String type);


}


