package kiea.priv.zzz.book.JavaDesignPattern.pattern.P12_Decorator.t01;

public class TestMain
{
	///////////////////////////////////////////////////////////////////////////
	
	public static void main(String[] args)
	{
		Display display1 = new StringDisplay("Hello, world!!!");
		Display display2 = new SideBorder(display1, '#');
		Display display3 = new FullBorder(display2);
		
		display1.show();
		display2.show();
		display3.show();
		
		Display display4 = 
			new SideBorder(
				new FullBorder(
					new FullBorder(
						new SideBorder(
							new FullBorder(
								new StringDisplay("�ȳ��ϼ���")
							), '*'
						)
					)
				), '/'
			);
		
		display4.show();
	}
}
