package kiea.priv.zzz.book.JavaDesignPattern.pattern.P04_FactoryMethod.t02;

public class TestMain
{
	///////////////////////////////////////////////////////////////////////////
	
	public static void main(String[] args)
	{
		Factory factory = new CardFactory();
		
		Product card1 = factory.create("ȫ�浿");
		Product card2 = factory.create("�̼���");
		Product card3 = factory.create("������");
		
		card1.use();
		card2.use();
		card3.use();
	}
}
