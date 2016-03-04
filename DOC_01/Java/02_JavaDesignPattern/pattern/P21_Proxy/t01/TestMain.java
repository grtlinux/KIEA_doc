package kiea.priv.zzz.book.JavaDesignPattern.pattern.P21_Proxy.t01;

public class TestMain
{
	///////////////////////////////////////////////////////////////////////////
	
	public static void main(String[] args)
	{
		Printable printable;
		
		printable = new PrinterProxy("Alice");
		System.out.println("������ �̸��� " + printable.getPrinterName() + " �Դϴ�.");
		
		printable.setPrinterName("Bob");
		System.out.println("������ �̸��� " + printable.getPrinterName() + " �Դϴ�.");
		
		printable.print("Hello, world");
	}
}
