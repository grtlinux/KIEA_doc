package kiea.priv.zzz.book.JavaDesignPattern.pattern.P05_Singleton.t04;

public class Test2Main
{
	///////////////////////////////////////////////////////////////////////////
	
	public static void main(String[] args)
	{
		System.out.println("Start.");
		
		/*
		 * getInstance�� ���������� ����Ǳ� ������ obj1 == obj2 �̴�.
		 */
		Singleton obj1 = Singleton.getInstance();
		Singleton obj2 = Singleton.getInstance();
		
		if (obj1 == obj2) {
			System.out.println("obj1 == obj2");
		} else {
			System.out.println("obj1 != obj2");
		}
		
		System.out.println("End.");
	}
}
