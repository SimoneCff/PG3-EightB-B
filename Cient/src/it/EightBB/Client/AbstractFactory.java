package it.EightBB.Client;


import it.EightBB.Client.SwingBB.Form;
import it.EightBB.Client.SwingBB.Frame;

import javax.swing.*;

public abstract interface AbstractFactory{

    //Instance
    public AbstractFactory getInstance();

    //Make
    public Form makeForm(String type);

    public Frame makeFrame(String type);

}


