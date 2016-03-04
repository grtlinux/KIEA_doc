package kiea.priv.zzz.book.JavaDesignPattern.pattern.P10_Strategy.t01;

public class TestMain
{
	///////////////////////////////////////////////////////////////////////////
	
	public static void main(String[] args)
	{
		Player player1 = new Player("ȫ�浿", new WinningStrategy(314));
		Player player2 = new Player("�Ӳ���", new ProbStrategy(15));
		
		for (int i=0; i < 10000; i++) {
			Hand nextHand1 = player1.nextHand();
			Hand nextHand2 = player2.nextHand();
			
			if (nextHand1.isStrongerThan(nextHand2)) {
				System.out.println("Winner: "+ player1);
				player1.win();
				player2.lose();
			} else if (nextHand2.isStrongerThan(nextHand1)) {
				System.out.println("Winner: "+ player2);
				player2.win();
				player1.lose();
			} else {
				System.out.println("Even...");
				player1.even();
				player2.even();
			}
		}
		
		System.out.println("Total result :");
		System.out.println(player1);
		System.out.println(player2);
	}
}
