import java.util.Comparator;

public class ProductComparator implements Comparator {
	private static ProductComparator lc
			=new ProductComparator();
	private  ProductComparator(){} 
	public static ProductComparator getInstance(){
		return lc;
	}
	//Comparator������ ���� �� �޼���
	public int compare(Object o1, Object o2) {
		Product sg1=(Product)o1;
		Product sg2=(Product)o2;
		int pMoney1=sg1.getPMoney();
		int pMoney2=sg2.getPMoney();
		int pPoint1=sg1.getPPoint();
		int pPoint2=sg2.getPPoint();
		int prodNum1=sg1.getProdNum();
		int prodNum2=sg2.getProdNum();
		if(pMoney1>pMoney2){   //Comparable�� ��������
			return -1;  //��������
		}else if(pMoney1==pMoney1){
			if(pPoint1>pPoint2){
				return -1;//��������
			}else if(pPoint1==pPoint2){
				if(prodNum1>prodNum2){
					return 1;//��������
				}else if(prodNum1==prodNum2){
					return 0;//�����̸Ӹ�Ű�ϱ� �̷� ���� ���� ��
				}else{
					return -1;//��������
				}
			}else{
				return 1;//��������
			}
		}else {
			return 1;//��������
		}
	}
}
