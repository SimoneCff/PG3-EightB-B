package it.EightBB.Client.Interface.Pclient.Button;

import it.EightBB.Client.Interface.Template.Button;

import javax.swing.*;

public class ExitC implements Button{
    private JButton Exit=null;
        public void setButton(){
            Exit=new JButton("Esci");
            Exit.setBounds(1000,25,70,25);
        }
        public void InitialiteButtonIntoFrame(JFrame F){
            F.add(Exit);
        }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
    }

