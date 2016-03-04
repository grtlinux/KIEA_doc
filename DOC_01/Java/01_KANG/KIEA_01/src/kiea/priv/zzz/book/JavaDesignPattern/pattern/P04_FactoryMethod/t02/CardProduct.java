package kiea.priv.zzz.book.JavaDesignPattern.pattern.P04_FactoryMethod.t02;

public class CardProduct extends Product
{
	private String owner;
	private int serial;
	
	public CardProduct(String owner, int serial)
	{
		this.owner = owner;
		this.serial = serial;
		System.out.println(this.owner + " (" + this.serial + ") �� ī�带 ����ϴ�.");
	}
	
	public void use()
	{
		System.out.println(this.owner + " (" + this.serial + ") �� ī�带 ����մϴ�.");
	}
	
	public String getOwner()
	{
		return this.owner;
	}
	
	public int getSerial()
	{
		return this.serial;
	}
}
