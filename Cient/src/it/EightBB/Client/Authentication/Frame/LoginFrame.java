package it.EightBB.Client.Authentication.Frame;

import it.EightBB.Client.SwingBB.Frame;

import javax.swing.*;

public class LoginFrame implements Frame {
    private final JFrame F = new JFrame();

    @Override
    public JFrame submit() {
        return F;
    }

    @Override
    public void InitializeFrm(JFrame F) {
        F.setSize(400,400);
        F.setVisible(true);
        F.setLayout(null);
    }
}
