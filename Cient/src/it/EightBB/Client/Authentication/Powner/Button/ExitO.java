package it.EightBB.Client.Authentication.Powner.Button;

import javax.swing.*;

public class ExitO {
    private JButton Exit=null;
        public void setButton(){
            Exit=new JButton("Esci");
            Exit.setBounds(50,100,70,20);
        }
        public void InitialiteButtonIntoFrame(JFrame F){
            F.add(Exit);
        }
    }

