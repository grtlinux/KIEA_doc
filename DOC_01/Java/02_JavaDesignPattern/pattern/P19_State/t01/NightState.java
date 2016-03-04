package kiea.priv.zzz.book.JavaDesignPattern.pattern.P19_State.t01;

public class NightState implements State
{
	private NightState() {}
	
	private static NightState instance = new NightState();
	
	public static State getInstance()
	{
		return instance;
	}
	
	public void doClock(Context context, int hour)
	{
		if (9 <= hour && hour < 17) {
			context.changeState(DayState.getInstance());
		}
	}
	
	public void doUse(Context context)
	{
		context.callSecurityCenter("���:�߰��� �ݰ���");
	}
	
	public void doAlarm(Context context)
	{
		context.callSecurityCenter("���(�߰�)");
	}
	
	public void doPhone(Context context)
	{
		context.recordLog("�߰��� ��ȭ����");
	}
	
	public String toString()
	{
		return "[�߰�] ";
	}
}
