package it.EightBB.Client.Authentication.Form;

import it.EightBB.Client.Authentication.ConcreteHanlderOne;
import it.EightBB.Client.Interface.SocketInterface;
import it.EightBB.Client.CEssentials.SocketProxy;
import it.EightBB.Client.Interface.Template.Form;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class Login implements Form {
    private static String us;
    private static JTextField Us = null;
    private static JPasswordField Ps = null;
    private JLabel Uss, Pss, Log = null;
    private JButton LogBt = null;


    @Override
    public void setForm(){
        //Fields:
        Us = new JTextField();
        Ps = new JPasswordField();

        //Button
        LogBt = new JButton("Login");

        //Label:
        Uss = new JLabel("Username");
        Pss = new JLabel("Password");
        Log = new JLabel("Login :");

        //set Fields:
        Us.setBounds(50,100,200,30);
        Ps.setBounds(50,160,200,30);

        //set Label:
        Log.setBounds(50,15,200,40);
        Log.setFont(new Font("Arial", Font.PLAIN, 30));

        Uss.setBounds(50,70,200,30);
        Pss.setBounds(50,130,200,30);


        //set pos
        LogBt.setBounds(50,230,200,30);

        LogBt.setActionCommand("Auth-BFORM-L");
        LogBt.addActionListener(new ConcreteHanlderOne());

    }

    @Override
    public void InitialiateFormIntoFrame(JFrame F) {;
        //add User Form
        F.add(Uss);
        F.add(Us);
        //add pass Form
        F.add(Log);
        F.add(Pss);
        F.add(Ps);
        //Add Button
        F.add(LogBt);
    }

    public static void getTextAndSendToDB() {
       SocketInterface SP = SocketProxy.getIstance();
       try {
           String[] req = {"AuthDBL",Us.getText(), "password",new String(Ps.getPassword())};
           SP.write(req);
           String Result = SP.read();
           System.out.println(Result);
           if (Result.equals("False")) {
               JOptionPane.showMessageDialog(new JFrame(), "Error, User or Password Not Found", "Error", JOptionPane.ERROR_MESSAGE);
           }
       } catch (IOException e) {
           JOptionPane.showMessageDialog(new JFrame(),e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
           System.exit(0);
       }
    }


}
