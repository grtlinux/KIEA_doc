package kiea.priv.zzz.book.JavaDesignPattern.pattern.P18_Memento.t01;

import java.util.Random;
import java.util.Vector;

public class Gamer
{
	private int money;
	private Vector<String> fruits = new Vector<String>();
	private Random random = new Random();
	
	private static String[] fruitsName = {
		"���", "����", "�ٳ���", "��",
	};
	
	public Gamer(int money)
	{
		this.money = money;
	}
	
	public int getMoney()
	{
		return money;
	}
	
	public void bet()
	{
		int dice = random.nextInt(6) + 1;
		if (dice == 1) {
			money += 100;
			System.out.println("���� �����߽��ϴ�.");
		} else if (dice == 2) {
			money /= 2;
			System.out.println("���� ������ �پ����ϴ�.");
		} else if (dice == 6) {
			String fruit = getFruit();
			System.out.println("���� " + fruit + "�� �޾ҽ��ϴ�.");
			fruits.add(fruit);
		} else {
			System.out.println("�ƹ��ϵ� �Ͼ�� �ʾҽ��ϴ�.");
		}
	}
	
	public Memento createMemento()
	{
		Memento memento = new Memento(money);
		for (String fruit : fruits) {
			if (fruit.startsWith("���̴�.")) {
				memento.addFruit(fruit);
			}
		}
		return memento;
	}
	
	public void restoreMemento(Memento memento)
	{
		this.money = memento.getMoney();
		this.fruits = memento.getFruits();
	}
	
	public String toString()
	{
		return "[money = " + money + ", fruits = " + fruits + "]";
	}
	
	private String getFruit()
	{
		String prefix = "";
		if (random.nextBoolean()) {
			prefix = "���ִ�.";
		}
		return prefix + fruitsName[random.nextInt(fruitsName.length)];
	}
}
