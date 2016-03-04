package kiea.priv.zzz.etc.hypericSIGAR.t01;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.hyperic.sigar.SigarException;
import org.hyperic.sigar.win32.Service;
import org.hyperic.sigar.win32.Win32Exception;

public class Win32Service extends SigarCommandBase
{
    private static final List<String> COMMANDS = 
        Arrays.asList(new String[] {
            "state",
            "start",
            "stop",
            "pause",
            "resume",
            "restart",
        });
    
    public Win32Service() {
        super();
    }

    public Win32Service(Shell shell) {
        super(shell);
    }

    public String getSyntaxArgs() {
        return "[name] [action]";
    }

    public String getUsageShort() {
        return "Windows service commands";
    }

    protected boolean validateArgs(String[] args) {
        return (args.length == 1) || (args.length == 2);
    }

    public Collection<?> getCompletions() {
        try {
            return Service.getServiceNames();
        } catch (Win32Exception e) {
            return null;
        }
    }

    public void output(String[] args) throws SigarException {
        Service service = null;
        String name = args[0];
        String cmd = null;

        if (args.length == 2) {
            cmd = args[1];
        }
        
        try {
            service = new Service(name);
        
            if ((cmd == null) || cmd.equals("state")) {
                service.list(this.out);
            }
            else if (cmd.equals("start")) {
                service.start();
            }
            else if (cmd.equals("stop")) {
                service.stop();
            }
            else if (cmd.equals("pause")) {
                service.pause();
            }
            else if (cmd.equals("resume")) {
                service.resume();
            }
            else if (cmd.equals("delete")) {
                service.delete();
            }
            else if (cmd.equals("restart")) {
                service.stop(0);
                service.start();
            }
            else {
                println("Unsupported service command: " + args[1]);
                println("Valid commands: " + COMMANDS);
            }
        } finally {
            if (service != null) {
                service.close();
            }
        }
    }
}
