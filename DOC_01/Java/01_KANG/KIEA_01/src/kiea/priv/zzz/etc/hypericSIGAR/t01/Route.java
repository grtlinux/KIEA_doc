package kiea.priv.zzz.etc.hypericSIGAR.t01;

import java.util.ArrayList;
import java.util.List;

import org.hyperic.sigar.NetFlags;
import org.hyperic.sigar.NetRoute;
import org.hyperic.sigar.SigarException;

public class Route extends SigarCommandBase
{
    private static final String OUTPUT_FORMAT =
            "%-15s %-15s %-15s %-5s %-6s %-3s %-s";

    //like route -n
    private static final String[] HEADER = new String[] {
        "Destination",
        "Gateway",
        "Genmask",
        "Flags",
        "Metric",
        "Ref",
        "Iface"
    };

    public Route(Shell shell) {
        super(shell);
        setOutputFormat(OUTPUT_FORMAT);
    }

    public Route() {
        super();
        setOutputFormat(OUTPUT_FORMAT);
    }

    private static String flags(long flags) {
        StringBuffer sb = new StringBuffer();
        if ((flags & NetFlags.RTF_UP) != 0) {
            sb.append('U');
        }
        if ((flags & NetFlags.RTF_GATEWAY) != 0) {
            sb.append('G');
        }
        return sb.toString();
    }

    public String getUsageShort() {
        return "Kernel IP routing table";
    }

    //netstat -r
    public void output(String[] args) throws SigarException {
        NetRoute[] routes = this.sigar.getNetRouteList();

        printf(HEADER);

        for (int i=0; i<routes.length; i++) {
            NetRoute route = routes[i];

            List<String> items = new ArrayList<String>();
            items.add(route.getDestination());
            items.add(route.getGateway());
            items.add(route.getMask());
            items.add(flags(route.getFlags()));
            items.add(String.valueOf(route.getMetric()));
            items.add(String.valueOf(route.getRefcnt()));
            items.add(route.getIfname());

            printf(items.toArray());
        }
    }

    public static void main(String[] args) throws Exception {
        new Route().processCommand(args);
    }
}
