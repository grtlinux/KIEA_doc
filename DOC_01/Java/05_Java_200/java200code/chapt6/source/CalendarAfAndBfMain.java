import java.util.*;
public class CalendarAfAndBfMain
{
	public static void main(String[] args) 
	{
		CalendarAfAndBf cal=new CalendarAfAndBf();
		//setDate�� �ּ��� Ǯ��
		Date d=cal.setDate(2005, 3,2);
		System.out.println("���س� :"+d.toString());
		System.out.println("������ :"+cal.afterOneDay(d));
		System.out.println("���س� :"+cal.beforOneDay(d));
	}
}
