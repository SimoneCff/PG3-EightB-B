package it.EightBB.Client.Pclient.Strategy;

import it.EightBB.Client.Interface.PaymentStrategy;
import it.EightBB.Client.Pclient.Memento.PrenotationMemento;

public class PayCardStrategy implements PaymentStrategy {
    private PrenotationMemento mem;


    @Override
    public void CollectMemento(PrenotationMemento mem) {
        this.mem = mem;
    }

    @Override
    public void SetpayToDB() {

    }
}
