package it.EightBB.Client.Pclient.Memento;

import it.EightBB.Client.Interface.Memento;

/**
 * Pattern utilizzato per conservare temporaneamente i dati presi
 * utilizzato durante la fase di prenotazione di una struttura e nel caso di prenotazione,
 * i dati vengono inviati al database
 * {@param PrenotationMemento} implementa il pattern Memento
 */
public class PrenotationMemento implements Memento {
    private String mail, nome, n_persone, n_children, data_start, data_end = null;
    private static PrenotationMemento Instance;

    public static PrenotationMemento getIstance(){
        if (Instance==null){
            Instance= new PrenotationMemento();
        } return Instance;
    }

    public void setPrenotationMemento(String mail, String n_persone, String n_children, String data_start, String date_end){
        this.mail = mail.trim();
        this.n_persone = n_persone;
        this.n_children = n_children;
        this.data_start = data_start;
        this.data_end = date_end;
    }

    public void setnome(String nome){
        this.nome= nome;
    }

    /**
     * @return invio dei dati al database nel caso di prenotazione.
     */
    @Override
    public String restoreState() {
        return "name,"+nome+",mail,"+mail+",n_person,"+n_persone+",n_children,"+n_children+",data_start,"+data_start+
                ",data_end,"+data_end+",";
    }
}
