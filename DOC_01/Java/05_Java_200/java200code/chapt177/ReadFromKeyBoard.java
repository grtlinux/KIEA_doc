import java.io.*;
public class ReadFromKeyBoard {

	public static void main(String[] args) {
		try{
			InputStreamReader isr=new InputStreamReader(System.in);
			BufferedReader br=new BufferedReader(isr);
			String s="";
		    System.out.println("������ �ʹٸ� ctrl+c�� �Է��Ͻÿ�");//ctrl+c
			//while(!(s=br.readLine()).equals("@esc")){//@esc
			while((s=br.readLine())!=null){//ctrl+c
				 System.out.println(s);//���
			}
			br.close();
			isr.close();
		}catch(Exception ee){
			System.out.println(ee.toString());
		}
	}
}
