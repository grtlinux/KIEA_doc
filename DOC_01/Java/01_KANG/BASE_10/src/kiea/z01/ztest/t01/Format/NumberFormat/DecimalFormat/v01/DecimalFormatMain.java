package kiea.z01.ztest.t01.Format.NumberFormat.DecimalFormat.v01;

import java.text.DecimalFormat;
import java.util.Scanner;

import kiea.kr.co.tain.base.Flag;

public class DecimalFormatMain
{
	/*
	 * ��) val = 78.53981633
	 * 0.###  -> 78.54 (78.540�̹Ƿ� 0�� ��µ��� �ʴ´�.)
	 * 000.## -> 078.54
	 * 00.#   -> 78.5
	 */
	
	///////////////////////////////////////////////////////////////////////////
	
	private static void test01()
	{
		if (Flag.TRUE) {
			int radius;
			double area, circumference;
			
			if (Flag.TRUE) {
				@SuppressWarnings("resource")
				Scanner scan = new Scanner(System.in);
				
				System.out.print("���� �������� �Է��ϼ���. :");
				radius = scan.nextInt();
			}
			
			if (Flag.TRUE) {
				area = Math.PI * Math.pow(radius, 2);
				circumference = 2 * Math.PI * radius;
				
				System.out.println("���� ���� : " + area);
				System.out.println("���� ���� : " + circumference);
				System.out.println();
			}
			
			if (Flag.TRUE) {
				DecimalFormat fmt = new DecimalFormat("0.###");
				System.out.println("DecimalFormat(0.###) ���� ��");
				
				System.out.println("���� ���� : " + fmt.format(area));
				System.out.println("���� ���� : " + fmt.format(circumference));
				System.out.println();
			}
			
			if (Flag.TRUE) {
				DecimalFormat fmt = new DecimalFormat("000.#");
				System.out.println("DecimalFormat(000.#) ���� ��");
				
				System.out.println("���� ���� : " + fmt.format(area));
				System.out.println("���� ���� : " + fmt.format(circumference));
				System.out.println();
			}
		}
	}
	
	public static void main(String[] args)
	{
		if (Flag.TRUE) test01();
	}
}
