import java.util.Comparator;
public class LexicographicallyComparator implements Comparator{
	//�̱��� ������ ������ �̿�����.
	private static LexicographicallyComparator lc
			=new LexicographicallyComparator();
	private  LexicographicallyComparator(){} 
	public static LexicographicallyComparator getInstance(){
		return lc;
	}
	//Comparator������ ���� �� �޼���
	public int compare(Object o1, Object o2) {
   		String sc1 = ((Student)o1).getName();
   		String sc2 = ((Student)o2).getName();
   		return sc1.compareTo(sc2);
	}
	//toString�� ���� ���ϸ� Object toString���
}
