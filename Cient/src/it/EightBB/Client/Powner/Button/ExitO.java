package it.EightBB.Client.Powner.Button;

import it.EightBB.Client.Interface.Template.Button;

import javax.swing.*;

public class ExitO implements Button {
    private JButton Exit=null;
        public void setButton(){
            Exit=new JButton("Esci");
            Exit.setBounds(50,100,70,20);
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

