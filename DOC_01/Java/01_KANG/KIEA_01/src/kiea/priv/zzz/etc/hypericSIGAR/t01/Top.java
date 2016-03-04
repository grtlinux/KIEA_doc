package kiea.priv.zzz.etc.hypericSIGAR.t01;

import java.util.List;

import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.ProcCpu;
import org.hyperic.sigar.ProcStat;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.hyperic.sigar.SigarProxy;
import org.hyperic.sigar.SigarProxyCache;

public class Top
{
    private static final int SLEEP_TIME = 1000 * 5;

    private static final String HEADER =
        "PID\tUSER\tSTIME\tSIZE\tRSS\tSHARE\tSTATE\tTIME\t%CPU\tCOMMAND";

    private static String toString(ProcStat stat) {
        return 
            stat.getTotal()    + " processes: " +
            stat.getSleeping() + " sleeping, " +
            stat.getRunning()  + " running, " + 
            stat.getZombie()   + " zombie, " +
            stat.getStopped()  + " stopped... " + stat.getThreads() + " threads";
    }

    public static void main(String[] args) throws Exception {
        Sigar sigarImpl = new Sigar();

        SigarProxy sigar = 
            SigarProxyCache.newInstance(sigarImpl, SLEEP_TIME);

        while (true) {
            Shell.clearScreen();

            System.out.println(Uptime.getInfo(sigar));

            System.out.println(toString(sigar.getProcStat()));

            System.out.println(sigar.getCpuPerc());

            System.out.println(sigar.getMem());

            System.out.println(sigar.getSwap());
                               
            System.out.println();

            System.out.println(HEADER);

            long[] pids = Shell.getPids(sigar, args);

            for (int i=0; i<pids.length; i++) {
                long pid = pids[i];

                String cpuPerc = "?";

                List<String> info;
                try {
                    info = Ps.getInfo(sigar, pid);
                } catch (SigarException e) {
                    continue; //process may have gone away
                }
                try {
                    ProcCpu cpu = sigar.getProcCpu(pid);
                    cpuPerc = CpuPerc.format(cpu.getPercent());
                } catch (SigarException e) {
                }

                info.add(info.size()-1, cpuPerc);

                System.out.println(Ps.join(info));
            }

            Thread.sleep(SLEEP_TIME);
            SigarProxyCache.clear(sigar);
        }
    }
}
