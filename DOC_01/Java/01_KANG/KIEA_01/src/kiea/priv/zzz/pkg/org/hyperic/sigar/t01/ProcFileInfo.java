package kiea.priv.zzz.pkg.org.hyperic.sigar.t01;

import org.hyperic.sigar.ProcExe;
import org.hyperic.sigar.ProcFd;
import org.hyperic.sigar.SigarException;
import org.hyperic.sigar.SigarNotImplementedException;
import org.hyperic.sigar.SigarPermissionDeniedException;

public class ProcFileInfo extends SigarCommandBase
{
    public ProcFileInfo(Shell shell) {
        super(shell);
    }

    public ProcFileInfo() {
        super();
    }

    protected boolean validateArgs(String[] args) {
        return true;
    }

    public String getUsageShort() {
        return "Display process file info";
    }

    public boolean isPidCompleter() {
        return true;
    }

    public void output(String[] args) throws SigarException {
        long[] pids = this.shell.findPids(args);

        for (int i=0; i<pids.length; i++) {
            try {
                output(pids[i]);
            } catch (SigarPermissionDeniedException e) {
                println(this.shell.getUserDeniedMessage(pids[i]));
            } catch (SigarException e) {
                println("(" + e.getMessage() + ")");
            }
            println("\n------------------------\n");
        }
    }

    public void output(long pid) throws SigarException {
        println("pid=" + pid);

        try {
            ProcFd fd = sigar.getProcFd(pid);
            println("open file descriptors=" + fd.getTotal());
        } catch (SigarNotImplementedException e) {}

        ProcExe exe = sigar.getProcExe(pid);
        String name = exe.getName();
        if (name.length() == 0) {
            name = "unknown";
        }
        println("name=" + name);

        println("cwd=" + exe.getCwd());
    }

    public static void main(String[] args) throws Exception {
        new ProcFileInfo().processCommand(args);
    }
}
