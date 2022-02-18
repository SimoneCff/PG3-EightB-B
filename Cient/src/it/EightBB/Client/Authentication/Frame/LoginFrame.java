package it.EightBB.Client.Authentication.Frame;

import it.EightBB.Client.SwingBB.Frame;

import javax.swing.*;

public class LoginFrame implements Frame {
    private final JFrame F = new JFrame();

    @Override
    public JFrame getFrame() {
        return F;
    }

    @Override
    public void setFrame(){
        F.setSize(400,400);
    }

    @Override
    public void InitializeFrm(JFrame F) {

        F.setVisible(true);
        F.setLayout(null);
    }
}
