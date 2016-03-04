package kiea.priv.zzz.etc.thread.synchronize.t01;

/**
 * 
 * @author KangSeok
 *

class Something
{
	public synchronized void method() {
		.....
	}
	
	// ���� ����.
	public void method() {
		synchronized (this) {
			.....
		}
	}
	
	public static synchronized void method() {
		.....
	}
	
	// ���� ����
	public static void method() {
		synchronized (Something.class) {
			.....
		}
	}
}


 */
public class BankSynchronized
{
	private int money;
	private String name;
	
	public BankSynchronized(String name, int money)
	{
		this.name = name;
		this.money = money;
	}
	
	// �����Ѵ�.
	public synchronized void deposit(int m)
	{
		this.money += m;
	}
	
	// �����Ѵ�.
	public synchronized boolean withdraw(int m)
	{
		if (this.money >= m) {
			this.money -= m;
			return true;
		} else {
			return false;
		}
	}
	
	public String getName()
	{
		return this.name;
	}
}
