import java.util.Scanner;
public class Scanner2Chapt39 {

	public static void main(String[] args) {
		
		String str=readString();
		char [] charStr=str.toCharArray();
		int count=charStr.length;
		System.out.println("���ڼ�:  "+count);
		for(int i=0;i<count;i++){
			System.out.print(charStr[i]+" : ");
		}
		System.out.println();
		int num=readInt();  //���ڸ� �Է�
		System.out.println("�Էµ� �� : "+num);
	}
	public static int readInt(){
		Scanner input=new Scanner(System.in);
		return input.nextInt();
	}
	public static double readDouble(){
		Scanner input=new Scanner(System.in);
		return input.nextDouble();
	}
	public static String readString(){
		Scanner input=new Scanner(System.in);
		return input.nextLine();
	}
}
