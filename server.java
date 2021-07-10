import java.io.*;
import java.net.*;
public class server{
    String[] AdviceList={"go for a walk","wakeup early","go shopping","Do home work"};
    public void go(){
        try{
            ServerSocket serverSocket=new ServerSocket(4242);
            while(true){
                Socket socket=serverSocket.accept();
                PrintWriter writer=new PrintWriter(socket.getOutputStream());
                String advice=getAdviec();
                writer.println(advice);
                writer.close();
                System.out.println(advice);
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) {
        server a=new server();
        a.go();
    }
    private String getAdviec(){
        int k=(int)(Math.random()*AdviceList.length);
        return AdviceList[k];
    }
}