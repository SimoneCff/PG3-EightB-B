package it.EightBB.Client.Interface;

import it.EightBB.Client.Pclient.Memento.PrenotationMemento;

public interface PaymentStrategy {
    public void CollectMemento(PrenotationMemento mem);
    public String SetpayToDB(String payment);
}
