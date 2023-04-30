package agentes;

import java.util.Enumeration;

import principal.Ra;
import principal.RaAddress;

/**
 * Utility agent that prints out a list of all servers connected to the domain.
 * Note how easy it is to extend an existing program with agents.
 * Future versions of kaariboga will probably contain special agents that
 * are automatically integrated into the menu structure.
 */
public class ServerLister extends Ra {
    /**
     * Just initialize the super class.
     *
     * @param name The name of the agent. This name has to be
     *             unique. Normally the Kaaribogaagency class provides some
     *             method to generate a unique name.
     */
    public ServerLister(String name) {
        super("ServerLister_" + name);
    }

    /**
     * Prints out the names of all servers connected to the domain.
     */
    public void run() {
        RaAddress address;
        Enumeration<RaAddress> enumVar = agency.getServers(this).elements();
        System.out.println("---------------------------------------------");
        System.out.println("Servers connected to the domain:");
        while (enumVar.hasMoreElements()) {
            address = (RaAddress) enumVar.nextElement();
            System.out.println(address.host.toString() + ":" + Integer.toString(address.port));
        }
        System.out.println("---------------------------------------------");
        fireDestroyRequest();
    }

}
