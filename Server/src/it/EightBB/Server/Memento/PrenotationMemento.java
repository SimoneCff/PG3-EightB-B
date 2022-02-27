package it.EightBB.Server.Memento;

public class PrenotationMemento {
    private String mail, nome, n_persone, n_children, data_start, data_end = null;

    public PrenotationMemento(String mail, String nome, String n_persone, String n_children, String data_start, String date_end){
        this.mail = mail;
        this.nome = nome;
        this.n_persone = n_persone;
        this.n_children = n_children;
        this.data_start = data_start;
        this.data_end = date_end;
    }

    public void Ripristina(){

    }
}
