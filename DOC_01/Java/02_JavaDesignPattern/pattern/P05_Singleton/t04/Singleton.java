package kiea.priv.zzz.book.JavaDesignPattern.pattern.P05_Singleton.t04;

public class Singleton
{
	private static Singleton instance = null;
	
	private Singleton()
	{
		System.out.println("!�ν��Ͻ��� �����մϴ�.");
		slowdown();
		System.out.println("\t!�ν��Ͻ��� �����߽��ϴ�.");
	}
	
	private void slowdown()
	{
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
	}
	
	public static Singleton getInstance()
	{
		/*
		 * ������ �߻���.
		 */
		if (Singleton.instance == null) {
			Singleton.instance = new Singleton();
		}
		
		return Singleton.instance;
	}
}
