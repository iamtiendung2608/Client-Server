import java.io.*;
import java.net.*;
import java.util.concurrent.RunnableScheduledFuture;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class client{
    JFrame frame;
    JTextField Text;
    PrintWriter writer;
    Socket socketClient;
    public void go(){
        frame=new JFrame("User Client");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel=new JPanel();
        JButton button=new JButton("Send");
        button.addActionListener(new SendListener());
        Font bigFont=new Font("serif",Font.BOLD,28);
        setUpNetWorking();

        Text=new JTextField(20);
        Text.requestFocus();
        Text.setFont(bigFont);

        mainPanel.add(Text);
        mainPanel.add(button);

        frame.getContentPane().add(BorderLayout.CENTER,mainPanel);
        frame.setSize(800,800);
        frame.setVisible(true);    
    }
    public class SendListener implements ActionListener{
        public void actionPerformed(ActionEvent ev){
            try{
                writer.println(Text.getText());
                writer.flush();
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
            Text.setText("");
            Text.requestFocus();
        }
    }
    public void setUpNetWorking(){
        try{
            socketClient =new Socket("127.0.0.1",4242);
            writer=new PrintWriter(socketClient.getOutputStream());
            System.out.println("Init networking");
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) {
        client g=new client();
        g.go();
    }
    public class MyRun implements Runnable{
        public void run(){
            
        }
    }
}