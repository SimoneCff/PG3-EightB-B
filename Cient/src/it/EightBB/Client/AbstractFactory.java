package it.EightBB.Client;


import it.EightBB.Client.SwingBB.Form;

public abstract interface AbstractFactory{

    //Instance
    public AbstractFactory getInstance();

    //Make
    public Form makeForm(String type);

}


