package kiea.priv.zzz.etc.hypericSIGAR.t02;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hyperic.sigar.SigarException;
import org.hyperic.sigar.SigarNotImplementedException;
import org.hyperic.sigar.SigarProxy;
import org.hyperic.sigar.util.PrintfFormat;

public class Uptime extends SigarCommandBase
{
	private static boolean flag = true;
	
	private static Object[] loadAvg = new Object[3];
	
	private static PrintfFormat formatter = new PrintfFormat("%.2f, %.2f, %.2f");
	
	public Uptime(Shell shell)
	{
		super(shell);
	}
	
	public Uptime()
	{
		super();
	}
	
	public String getUsageShort()
	{
		return "Display how long the system has been running.";
	}
	
	public void output(String[] args) throws SigarException
	{
		System.out.println(getInfo(this.sigar));
	}
	
	public static String getInfo(SigarProxy sigar) throws SigarException
	{
		double uptime = sigar.getUptime().getUptime();
		
		String loadAverage;
		
		try {
			double[] avg = sigar.getLoadAverage();
			loadAvg[0] = new Double(avg[0]);
			loadAvg[1] = new Double(avg[1]);
			loadAvg[2] = new Double(avg[2]);
			
			loadAverage = "load average: " + formatter.sprintf(loadAvg);
			
		} catch (SigarNotImplementedException e) {
			loadAverage = "(load average unknown)";
		}
		
		return
				"  " + getCurrentTime() +
				"  up " + formatUptime(uptime) + 
				", " + loadAverage;
	}
	
	private static String formatUptime(double uptime)
	{
		String retval = "";
		
		int days = (int) uptime / (60*60*24);
		int minutes, hours;
		if (days != 0) {
			retval += days + " " + ((days > 1) ? "days" : "day") + ", ";
		}
		
		minutes = (int) uptime / 60;
		hours = minutes / 60;
		hours %= 24;
		minutes %= 60;
		
		if (hours != 0) {
			retval += hours + ":" + minutes;
		} else {
			retval += minutes + " min";
		}
		
		return retval;
	}
	
	private static String getCurrentTime()
	{
		return new SimpleDateFormat("h:mm a").format(new Date());
	}
	
	///////////////////////////////////////////////////////////////////////////
	
	private static void test01(String[] args) throws Exception
	{
		if (flag) {
			try {
				new Uptime().processCommand(args);
				try { Thread.sleep(1000); } catch (InterruptedException e) {}
				new Uptime().processCommand(args);
				try { Thread.sleep(1000); } catch (InterruptedException e) {}
				new Uptime().processCommand(args);
			} catch (Exception e) {
				// e.printStackTrace();
				throw e;
			}
		}
	}
	
	public static void main(String[] args) throws Exception
	{
		if (flag) test01(args);
	}
}
