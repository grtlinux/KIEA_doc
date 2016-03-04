package kiea.priv.zzz.pkg.org.hyperic.sigar.t01;

import java.util.List;

import org.hyperic.sigar.SigarException;
import org.hyperic.sigar.SigarNotImplementedException;

public class ProcModuleInfo extends SigarCommandBase
{
    public ProcModuleInfo(Shell shell) {
        super(shell);
    }

    public ProcModuleInfo() {
        super();
    }

    protected boolean validateArgs(String[] args) {
        return true;
    }

    public String getUsageShort() {
        return "Display process module info";
    }

    public boolean isPidCompleter() {
        return true;
    }

    public void output(String[] args) throws SigarException {
        long[] pids = this.shell.findPids(args);

        for (int i=0; i<pids.length; i++) {
            try {
                output(pids[i]);
            } catch (SigarException e) {
                println("(" + e.getMessage() + ")");
            }
            println("\n------------------------\n");
        }
    }

    public void output(long pid) throws SigarException {
        println("pid=" + pid);

        try {
            @SuppressWarnings("unchecked")
			List<String> modules = this.sigar.getProcModules(pid);

            for (int i=0; i<modules.size(); i++) {
                println(i + "=" + modules.get(i));
            }
        } catch (SigarNotImplementedException e) {
            throw e;
        } catch (SigarException e) {
            println("[" + e.getMessage() + "]");
        }
    }

    public static void main(String[] args) throws Exception {
        new ProcModuleInfo().processCommand(args);
    }
}
