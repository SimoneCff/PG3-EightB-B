package it.EightBB.Client;

import it.EightBB.Client.SwingBB.Frame;


public abstract interface AbstractFactory{

    //Instance
    public AbstractFactory getInstance();

    //Make
    public Frame makeFrame(String type);

}


