
public class ComplexMain {

	public static void main(String[] args) {
		Complex z1=new Complex(3,4);
		Complex z2=new Complex(2,-5);
		Complex z3=new Complex(8,0);
		Complex z4=new Complex(-3,-4);
		
		System.out.println(ComplexUtill.bar(z1));//bar ���Ҽ�(�ӷ� ���Ҽ�)
		System.out.println(ComplexUtill.summs(z1,z2));//���Ҽ� ��
		System.out.println(ComplexUtill.minus(z1,z2));//���Ҽ� ��
		System.out.println(ComplexUtill.multi(z1,z2));//���Ҽ� ��
		System.out.println(ComplexUtill.divide(z1,z2));//���Ҽ� ������
		System.out.println(ComplexUtill.absolute(z1));//���Ҽ� ũ��
		System.out.println(ComplexUtill.size(z1));//z*(bar z)
		System.out.println(ComplexUtill.multi(z3,z4));//���Ҽ� ��(�Ǽ�)
		
		
	}
}
