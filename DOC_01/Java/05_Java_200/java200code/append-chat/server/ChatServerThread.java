import   java.io.*;
import   java.util.*;
public class ChatServerThread implements Runnable{
   Vector   buffer;   //Vector<Message> buffer;
   ObjectInputStream  ois;
   ObjectOutputStream oos;
   Message  mess;
   boolean  exit;
   String   name;
   public ChatServerThread(Vector v,ObjectInputStream ois,ObjectOutputStream oos){
     buffer=v;
     this.ois=ois;
     this.oos=oos;
     exit=false;
   }
   public void run(){
     while(!exit){
       try{
            mess=(Message)ois.readObject();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Exception�� �߻�");
       }
       int state=mess.getState();
       if(state==Message.END){
             mess.setMessage("���� �����ϼ̽��ϴ�.");
             name=mess.getName();
             broadCasting();
             for (int i = 0; i < buffer.size(); i++) {
               if ( ( (Message) buffer.elementAt(i)).getName().equals(name)) {
                 buffer.removeElementAt(i);
               }
             }
             try {
               ois.close();
               oos.close();
             }
             catch (Exception x) {}
             exit = true;
			 System.out.println(name+"���� �����ϼ̽��ϴ�.");
       }else if(state==Message.INITCONTACT){

           Vector userName=new Vector(5,1);
		  // Vector<String> userName=new Vector<String>(5,1);
           mess.setObjectStream(oos);
           buffer.addElement(mess);
           for(int i=0;i<buffer.size();i++){
             userName.addElement(((Message)buffer.elementAt(i)).getName());
           }
           mess.setUserName(userName);
           System.out.println("broadCasting ����");
           broadCasting();
        }else{
           broadCasting();
        }//
      }
    }
    public void broadCasting(){
       for(int i=0;i<buffer.size();i++){
          try{
           ((Message)buffer.elementAt(i)).getObjectStream().writeObject(mess);
          }catch(IOException e){
             System.out.println("broadCasting method���� IOException.");
           e.printStackTrace();
          }
        }
    }
}//class



