public class SystemTestJava5 {

	public static void main(String[] args) {
		long namotime=System.nanoTime();
		for(int i=0;i<10000;i++){
			System.out.print("");
		}
		long namotime2=System.nanoTime();//10^-9 nano java5
		System.out.println((namotime2-namotime));//1/1000000000��			
		//java2������ deprecate�Ǿ���. java5 �������.
		System.out.println(System.getenv("JAVA_HOME")); //java 5
		//��� env���ϱ�
		java.util.Map map=System.getenv();  //java5�� �������.
		java.util.Iterator iter= map.keySet().iterator();
		int j=0;
		while(iter.hasNext()){
			String keys=(String)iter.next();
			System.out.println((++j+" ")+keys+" : "+map.get(keys));
		}
	}//main
}

