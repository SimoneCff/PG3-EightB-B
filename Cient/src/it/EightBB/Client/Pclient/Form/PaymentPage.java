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
    private JButton Card, BankTransfer, ConfirmP, ConfirmB  = null;
    private boolean choose_p, choose_b;

    @Override
    public void setForm() {
        choose_p = false;
        choose_b = false;
        selectMethodPayment = new JLabel("Seleziona metodo di pagamento");
        //Buttons
        Card = new JButton("Carta");
        BankTransfer = new JButton("Bonifico");

        //SetButtons
        Card.setBounds(250, 100, 70, 30);
        BankTransfer.setBounds(350, 100, 100, 30);

        //set text
        selectMethodPayment.setBounds(50, 100, 200, 30);
    }

    @Override
    public void InitialiateFormIntoFrame(JFrame F) {

            F.add(Card);
            F.add(BankTransfer);
            F.add(selectMethodPayment);


        //Buttons
        F.setSize(1366, 768);
        F.getContentPane().setBackground(new Color(225,204,204));

        Card.addActionListener(e -> {
            //Remove Comp from BankTransfer
        if (choose_b){
            F.remove(BankTransferHolder);
            F.remove(BankTransferIban);
            F.remove(BankTransferMotivation);
            F.remove(ConfirmB);
            F.repaint();
        }
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

                //
                F.remove(ConfirmP);

                F.repaint();
            }
        choose_p = true;

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

            //Button
            ConfirmP = new JButton("Conferma");
            ConfirmP.setBounds(70,350,70,30);

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

            //Button
            F.add(ConfirmP);

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

                F.remove(ConfirmP);

                F.repaint();
            }
            if (choose_b){
                F.remove(BankTransferHolder);
                F.remove(BankTransferIban);
                F.remove(BankTransferMotivation);
                F.remove(ConfirmB);
                F.repaint();
            }
            choose_b = true;

            BankTransferHolder = new JLabel("<html>Nome e Cognome intestario:<br />Nome Struttura</html>");
            BankTransferIban = new JLabel("<html>IBAN:<br />IT00WASD1234567890</html>");
            BankTransferMotivation = new JLabel("<html>Motivazione:<br />Soggiorno Nome Cognome Cliente</html>");

            BankTransferHolder.setBounds(50, 160, 100, 80);
            BankTransferIban.setBounds(50, 220, 100, 80);
            BankTransferMotivation.setBounds(50, 280, 100, 80);

            ConfirmB = new JButton("Conferma");
            ConfirmB.setBounds(70,350,70,30);

            F.add(BankTransferHolder);
            F.add(BankTransferIban);
            F.add(BankTransferMotivation);
            F.add(ConfirmB);
            F.repaint();
        });
    }
}
