package it.EightBB.Client.Pclient.Form;

import it.EightBB.Client.Authentication.ConcreteHanlderOne;
import it.EightBB.Client.Interface.Template.Form;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentPage implements Form {
    private JTextField propcard, cvv, cardnumber, scadenza = null;
    private JLabel propcardd, cvvv, cardnumberr, scadenzaa, selectMethodPayment, BankTransferHolder, BankTransferIban, BankTransferMotivation = null;
    private JButton Card, BankTransfer = null;
    private boolean choose_p, choose_b = false;

    @Override
    public void setForm() {
        selectMethodPayment = new JLabel("Seleziona metodo di pagamento");
        //Buttons
        Card = new JButton("Carta");
        BankTransfer = new JButton("Bonifico");

        //SetButtons
        Card.setBounds(250, 100, 70, 30);
        BankTransfer.setBounds(350, 100, 100, 30);
    }

    @Override
    public void InitialiateFormIntoFrame(JFrame F) {
        if (choose_b){
            F.add(Card);
            F.add(BankTransfer);
            F.add(selectMethodPayment);
        } else choose_p = true;

        //Buttons
        F.setSize(1366, 768);
        F.getContentPane().setBackground(new Color(225,204,204));



        Card.addActionListener(e -> {
            //Remove Comp from BankTransfer
            F.remove(BankTransferHolder);
            F.remove(BankTransferIban);
            F.remove(BankTransferMotivation);

            //Fields
            propcard = new JTextField();
            cvv = new JTextField();
            cardnumber = new JTextField();
            scadenza = new JTextField();

            //Labels
            propcardd = new JLabel("Nome e Cognome proprietario");
            cvvv = new JLabel(("CVV"));
            cardnumberr = new JLabel("Numero carta");
            scadenzaa = new JLabel("Scadenza");

            //SetFields
            propcard.setBounds(50, 160, 70, 30);
            cvv.setBounds(50, 220, 70, 30);
            cardnumber.setBounds(50, 280, 70, 30);
            scadenza.setBounds(50, 340, 70, 30);

            //SetLabels
            propcardd.setBounds(50, 140, 70, 30);
            cvvv.setBounds(50, 200, 70, 30);
            cardnumberr.setBounds(50, 260, 70, 30);
            scadenzaa.setBounds(50, 320, 70, 30);
            selectMethodPayment.setBounds(50, 100, 200, 30);


            //Fields
            F.add(propcard);
            F.add(cvv);
            F.add(cardnumber);
            F.add(scadenza);

            //Labels
            F.add(propcardd);
            F.add(cvvv);
            F.add(cardnumberr);
            F.add(scadenzaa);
            F.repaint();
        });

        BankTransfer.addActionListener(e ->{
            if(choose_p){
                //Fields
                F.remove(propcard);
                F.remove(cvv);
                F.remove(cardnumber);
                F.remove(scadenza);

                //Labels
                F.remove(propcardd);
                F.remove(cvvv);
                F.remove(cardnumberr);
                F.remove(scadenzaa);
            } else choose_b = true;

            BankTransferHolder = new JLabel("<html>Nome e Cognome intestario:<br />Nome Struttura</html>");
            BankTransferIban = new JLabel("<html>IBAN:<br />IT00WASD1234567890</html>");
            BankTransferMotivation = new JLabel("<html>Motivazione:<br />Soggiorno Nome Cognome Cliente</html>");

            BankTransferHolder.setBounds(50, 160, 100, 80);
            BankTransferIban.setBounds(50, 220, 100, 80);
            BankTransferMotivation.setBounds(50, 280, 100, 80);


            F.add(BankTransferHolder);
            F.add(BankTransferIban);
            F.add(BankTransferMotivation); F.repaint();
        });
    }
}
