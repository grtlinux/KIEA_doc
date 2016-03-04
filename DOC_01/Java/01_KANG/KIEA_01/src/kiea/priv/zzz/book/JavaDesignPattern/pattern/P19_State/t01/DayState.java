package kiea.priv.zzz.book.JavaDesignPattern.pattern.P19_State.t01;

public class DayState implements State
{
	private DayState() {}
	
	private static DayState instance = new DayState();
	
	public static State getInstance()
	{
		return instance;
	}
	
	public void doClock(Context context, int hour)
	{
		if (hour < 9 || 17 <= hour) {
			context.changeState(NightState.getInstance());
		}
	}
	
	public void doUse(Context context)
	{
		context.recordLog("�ݰ���(�ְ�)");
	}
	
	public void doAlarm(Context context)
	{
		context.callSecurityCenter("���(�ְ�)");
	}
	
	public void doPhone(Context context)
	{
		context.callSecurityCenter("�Ϲݵ�ȭ(�ְ�)");
	}
	
	public String toString()
	{
		return "[�ְ�] ";
	}
}
