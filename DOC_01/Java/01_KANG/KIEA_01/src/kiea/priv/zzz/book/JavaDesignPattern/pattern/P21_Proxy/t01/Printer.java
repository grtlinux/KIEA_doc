package kiea.priv.zzz.book.JavaDesignPattern.pattern.P21_Proxy.t01;

public class Printer implements Printable
{
	private String name;
	
	public Printer()
	{
		heavyJob("Printer�� �ν��Ͻ��� ������..");
	}
	
	public Printer(String name)
	{
		this.name = name;
		heavyJob("Printer�� �ν��Ͻ�(" + this.name + ")�� ������...");
	}
	
	public void setPrinterName(String name)
	{
		this.name = name;
	}
	
	public String getPrinterName()
	{
		return this.name;
	}
	
	public void print(String string)
	{
		System.out.println("---- " + this.name + " ----");
		System.out.println(string);
	}
	
	private void heavyJob(String msg)
	{
		System.out.print(msg);
		
		try { Thread.sleep(1000); } catch (InterruptedException e) {}

		System.out.println("�Ϸ�");
	}
}
