package it.EightBB.Client.Authentication.Button;

import it.EightBB.Client.SwingBB.Button;

import javax.swing.*;

public class Exit {
    private JButton Exit=null;
        public void setButton(){
            Exit=new JButton("Strutture Registrate");
            Exit.setBounds(50,100,70,20);
        }
        public void InitialiteButtonIntoFrame(JFrame F){
            F.add(Exit);
        }
    }

