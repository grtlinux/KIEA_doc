package kiea.priv.zzz.book.JavaDesignPattern.pattern.P07_Builder.t02;

public class Director
{
	private Builder builder;
	
	public Director(Builder builder)
	{
		this.builder = builder;
	}
	
	public String construct()
	{
		builder.makeTitle("��ħ�� ����");
		builder.makeContent("�ȳ��� �ֹ��̽��ϱ�?");
		builder.makeItems(new String[] {
				"���� ��ħ�Դϴ�.",
				"�ȳ��� �ֹ��̽��ϱ�!",
		});
		return builder.getResult();
	}
}
