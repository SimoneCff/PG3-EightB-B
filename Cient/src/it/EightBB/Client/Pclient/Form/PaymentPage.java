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

    @Override
    public void setForm() {
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
        selectMethodPayment = new JLabel("Seleziona metodo di pagamento");
        BankTransferHolder = new JLabel("<html>Nome e Cognome intestario:<br />Nome Struttura</html>");
        BankTransferIban = new JLabel("<html>IBAN:<br />IT00WASD1234567890</html>");
        BankTransferMotivation = new JLabel("<html>Motivazione:<br />Soggiorno Nome Cognome Cliente</html>");

        //Buttons
        Card = new JButton("Carta");
        BankTransfer = new JButton("Bonifico");

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
        BankTransferHolder.setBounds(50, 160, 100, 80);
        BankTransferIban.setBounds(50, 220, 100, 80);
        BankTransferMotivation.setBounds(50, 280, 100, 80);

        //SetButtons
        Card.setBounds(250, 100, 70, 30);
        BankTransfer.setBounds(350, 100, 100, 30);

//        Card.setActionCommand("Client-BFORM-PC");
        Card.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame PayByCard = new JFrame();

                //Fields
                propcard = new JTextField();
                cvv = new JTextField();
                cardnumber = new JTextField();
                scadenza = new JTextField();

                //SetFields
                propcard.setBounds(50, 160, 70, 30);
                cvv.setBounds(50, 220, 70, 30);
                cardnumber.setBounds(50, 280, 70, 30);
                scadenza.setBounds(50, 340, 70, 30);

                PayByCard.setLayout(null);
                PayByCard.setVisible(true);
                PayByCard.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            }

        });

        BankTransfer.setActionCommand("Client-BFORM-PB");
        BankTransfer.addActionListener(new ConcreteHanlderOne());


    }

    @Override
    public void InitialiateFormIntoFrame(JFrame F) {
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
        F.add(selectMethodPayment);
        F.add(BankTransferHolder);
        F.add(BankTransferIban);
        F.add(BankTransferMotivation);

        //Buttons
        F.add(Card);
        F.add(BankTransfer);

        F.setSize(1366, 768);
        F.getContentPane().setBackground(new Color(225,204,204));
    }
}
