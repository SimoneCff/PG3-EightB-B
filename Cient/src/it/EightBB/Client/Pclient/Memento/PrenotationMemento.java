package it.EightBB.Client.Pclient.Memento;

import it.EightBB.Client.Interface.Memento;

public class PrenotationMemento implements Memento {
    private String mail, nome, n_persone, n_children, data_start, data_end = null;
    private static PrenotationMemento Instance;

    public static PrenotationMemento getIstance(){
        if (Instance==null){
            Instance= new PrenotationMemento();
        } return Instance;
    }

    public void setPrenotationMemento(String mail, String n_persone, String n_children, String data_start, String date_end){
        this.mail = mail;
        this.n_persone = n_persone;
        this.n_children = n_children;
        this.data_start = data_start;
        this.data_end = date_end;
    }

    public void setnome(String nome){
        this.nome= nome;
    }

    @Override
    public void restoreState() {

    }
}
