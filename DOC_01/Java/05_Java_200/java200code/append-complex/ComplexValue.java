
public class ComplexValue {
	
	public static double firstTheta(Complex z){
		double theta=0;
		double abs=ComplexUtill.absolute(z);
		double a=z.getReal();
		theta=Math.acos(a/abs);
		return theta;  //����
	}
	public static double size(int n,Complex z){
		return Math.pow(ComplexUtill.absolute(z),1.0/n);
		//(a*a+b*b)^( 1/(2n) )
	}
	
	public static Complex[] compRoot(int n,Complex z){
		Complex[] comp=new Complex[n];
		for(int i=0;i<comp.length;i++){
			double first=firstTheta(z);//���۰�
			double theta=first+Math.toRadians(360.0/n*i);  //���۰�+��а�
			double size=size(n,z);  //ũ�� ���ϱ�
			double cos=Math.cos(theta);//���� ���ϱ�
			double sin=Math.sin(theta);//���� ���ϱ�
			comp[i]=new Complex(size*cos,size*sin);
		}
		return comp;
	}
	public static double[] thetas(int n,Complex z){
		double[] comp=new double[n];
		for(int i=0;i<comp.length;i++){
			double first=firstTheta(z);
			double theta=first+Math.toRadians(360.0/n*i);
			comp[i]=theta;
		}
		return comp;
	}
	
}
