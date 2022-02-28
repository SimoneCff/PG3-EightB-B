package it.EightBB.Client.Pclient.Strategy;

import it.EightBB.Client.CEssentials.SocketProxy;
import it.EightBB.Client.Interface.PaymentStrategy;
import it.EightBB.Client.Interface.SocketInterface;
import it.EightBB.Client.Pclient.Memento.PrenotationMemento;

import java.io.IOException;

public class PayCardStrategy implements PaymentStrategy {
    private PrenotationMemento mem;


    @Override
    public void CollectMemento(PrenotationMemento mem) {
        this.mem = mem;
    }

    @Override
    public String SetpayToDB(String payment) {
        String res = "False";
        String req = "Client,Prenot,booking,"+mem.restoreState()+"Payment_type,card,Payment_data,"+payment;
        try{
            SocketInterface SP = SocketProxy.getIstance();
            SP.write(req);
            res = SP.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
}
