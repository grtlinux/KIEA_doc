
public class ComplexValueMain {

	public static void main(String[] args) {
		double t1=ComplexValue.firstTheta(new Complex(1,1));//���ȱ⺻
		t1=Math.toDegrees(t1);
		System.out.println(t1);
		//ComplexValue
		double t2=ComplexValue.size(3,new Complex(1,1)); //z^3=1+1i
		System.out.println(t2);
		
		//�� ���ϱ� 
		Complex[] comp=ComplexValue.compRoot(3,new Complex(1,1));
		//z^3=1+1 i�� ���� 
		for(int i=0;i<comp.length;i++){
			System.out.println(comp[i]);
		}
		///�� ���ϱ� 
		
		double[] thetas=ComplexValue.thetas(3,new Complex(1,1));
		//z^3=1+1 i�� ���� 
		for(int i=0;i<thetas.length;i++){
			System.out.println(Math.toDegrees(thetas[i])+" degree");
		}
	}
}
