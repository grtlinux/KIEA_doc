package kiea.priv.zzz.book.JavaDesignPattern.pattern.P04_FactoryMethod.t01;

public class CardProduct extends Product
{
	private String owner;
	
	public CardProduct(String owner)
	{
		this.owner = owner;
		System.out.println(this.owner + "�� ī�带 ����ϴ�.");
	}
	
	public String getOwner()
	{
		return this.owner;
	}
	
	public void use()
	{
		System.out.println(this.owner + "�� ī�带 ����մϴ�.");
	}
}
