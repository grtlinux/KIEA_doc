package kiea.priv.zzz.book.JavaDesignPattern.pattern.P18_Memento.t01;

public class TestMain
{
	///////////////////////////////////////////////////////////////////////////
	
	public static void main(String[] args)
	{
		Gamer gamer = new Gamer(100);  // ó���� ���� 100
		Memento memento = gamer.createMemento();
		
		for (int i=0; i < 100; i++) {
			System.out.println("===== " + i);
			System.out.println("�� ����:" + gamer);
			
			gamer.bet();
			
			System.out.println("���� " + gamer.getMoney() + "���� �Ǿ����ϴ�.");
			
			// Memento�� ��� ����
			if (gamer.getMoney() > memento.getMoney()) {
				System.out.println("     (���� ���������� ������ ���¸� �����ص���)");
				memento = gamer.createMemento();
			} else if (gamer.getMoney() < memento.getMoney() / 2) {
				System.out.println("     (���� �پ����� ������ ���·� ��������)");
				gamer.restoreMemento(memento);
			}
			
			// ��ٸ�.
			try { Thread.sleep(1000); } catch (InterruptedException e) {}
			
			System.out.println();
		}
	}
}
