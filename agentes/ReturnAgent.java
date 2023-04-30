package agentes;

import principal.Ra;

/**
 * Example of a simple Ra that travels to another agency
 * returns and destroys itself.
 */
public class ReturnAgent extends Ra {
    /**
     * Number of trips.
     */
    int trips = 0;

    /**
     * Just initialize the super class.
     *
     * @param name The name of the agent. This name has to be
     *             unique. Normally the Raagency class provides some
     *             method to generate a unique name.
     */
    public ReturnAgent(String name) {
        super("ReturnAgent_" + name);
    }

    /**
     * This method is called when agency has done some
     * initialisation on the agent and before run.
     */
    public void onCreate() {
        destination = agency.getAgencyAddress(this);
    }

    /**
     * Run is called every time an agent get's loaded or
     * arrives on a agency.
     */
    public void run() {
        System.out.println("ReturnAgent: I am running! ");
        if (trips == 1) {
            System.out.println("ReturnAgent: Here I am.");
            fireDispatchRequest();
        }
        if (trips > 1) {
            System.out.println("ReturnAgent: Request for destruction.");
            fireDestroyRequest();
        }
    }

    /**
     * This is called before run when the agent arrives from a trip.
     */
    public void onArrival() {
        System.out.println("ReturnAgent: I have arrived from my journey.");
        ++trips;
    }

    /**
     * This method is called before the agent gets dispatched to another agency.
     * The method should be used to do clean up when the agent has
     * locked some resources.
     */
    public void onDispatch() {
        System.out.println("ReturnAgent: Sorry, I have to leave you.");
    }
}