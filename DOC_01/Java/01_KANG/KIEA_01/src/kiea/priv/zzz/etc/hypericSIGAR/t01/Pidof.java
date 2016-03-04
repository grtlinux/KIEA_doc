package kiea.priv.zzz.etc.hypericSIGAR.t01;

import org.hyperic.sigar.SigarException;

public class Pidof extends SigarCommandBase
{
    public Pidof(Shell shell) {
        super(shell);
    }

    public Pidof() {
        super();
    }

    protected boolean validateArgs(String[] args) {
        return args.length > 0;
    }

    public String getSyntaxArgs() {
        return "query";
    }

    public String getUsageShort() {
        return "Find the process ID of a running program";
    }

    public void output(String[] args) throws SigarException {
        long[] pids = this.shell.findPids(args);

        for (int i=0; i<pids.length; i++) {
            this.out.print(pids[i]);
            this.out.print(' ');
        }
        this.out.println();
    }
}
