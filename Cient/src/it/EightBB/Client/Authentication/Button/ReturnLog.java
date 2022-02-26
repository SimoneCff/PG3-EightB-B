package it.EightBB.Client.Authentication.Button;

import it.EightBB.Client.Authentication.ConcreteHanlderOne;
import it.EightBB.Client.Interface.Template.Button;

import javax.swing.*;

/**
 * Form di implementazione del tasto Return che consente di tornare indietro alla fase di Login

 */
public class ReturnLog implements Button {
    private JButton Return;
    @Override
    public void setButton() {
        Return = new JButton("Indietro");

        Return.setBounds(140, 200, 80, 30);
        Return.setActionCommand("Auth-BP-RetGin");
        Return.addActionListener(new ConcreteHanlderOne());
    }

    @Override
    public void InitialiteButtonIntoFrame(JFrame F) {
        F.add(Return);
    }
}
