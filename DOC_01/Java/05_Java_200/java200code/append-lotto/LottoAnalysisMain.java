
public class LottoAnalysisMain {

	public static void main(String[] args) {
		LottoAnalysis lan=new LottoAnalysis();
		//1ȸ�� 10  23  29  33  37  40 16 2002.12.07 2003.03.10
		//���� �ζ� 6���� ���ʽ� 1���� �����´�. 
		System.out.println(lan.getLottos(lan.lottos[0]));
		
		//System.out.println(09+"");// ���� 8���� 
		//09�� ���� 0���� �����ϴ� ���� 10�� ���ڷ� ��ȯ
		System.out.println(lan.to10("09"));
		
		int a[]=lan.toInt(lan.getLottos(lan.lottos[0]));
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
	}
}
