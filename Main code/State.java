package part1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * This class provides the needed Infra Structure and Internet providers data in the state we are dealing with
 */
public class State {
    private String stateName;
    private ArrayList<InfraStructureProvider> infraStructureProviders;
    private ArrayList<InternetProvider> internetProviders;
    private ArrayList<Customer> customers;
    private ArrayList<String> customerTypes;

    /**
     * The constructor of the class, which fills the state name instance with its name.
     * @param stateName
     */
    State(String stateName){
        this.stateName = stateName;
    }

    /**
     * This method sets the Infra structures providers list to its instance
     * @param lst
     */
    void setInfraStructureProviders(ArrayList<InfraStructureProvider> lst){
        this.infraStructureProviders = lst;
    }

    /**
     * This method sets the Internet providers list to its instance
     * @param lst
     */
    void setInternetProviders(ArrayList<InternetProvider> lst){
        this.internetProviders = lst;
    }

    /**
     * This method fills the needed data about the providers for the state we are in.
     * It also calls for the set methods to put the needed data in its instances.
     */
    void init(){
        internetProviders = new ArrayList<>();
        infraStructureProviders = new ArrayList<>();
        customerTypes = new ArrayList<>();
        InternetProvider Cellcom = new InternetProvider("Cellcom",100);
        InternetProvider Benleumi = new InternetProvider("Benleumi",150);
        InternetProvider Partner = new InternetProvider("Partner",90);
        internetProviders.add(Cellcom);
        internetProviders.add(Benleumi);
        internetProviders.add(Partner);
        setInternetProviders(internetProviders);
        InfraStructureProvider Bezeq = new InfraStructureProvider("Bezeq",70);
        InfraStructureProvider Hot = new InfraStructureProvider("HOT",100);
        infraStructureProviders.add(Bezeq);
        infraStructureProviders.add(Hot);
        setInfraStructureProviders(infraStructureProviders);
        customerTypes.add("Regular");
        customerTypes.add("Government");
        customerTypes.add("VIP");

    }

    /**
     * This method gets a String name of an Internet provider, and if it belongs to the state it returns the InternetProvider object
     * @param name
     * @return
     */
    InternetProvider getInternetProvider(String name){
        for(InternetProvider provider : this.internetProviders) {
            if (provider.getName().equals(name)) {
                return provider;
            }
        }
        return null;
    }

    /**
     *This method gets a String name of an Infra structure provider.
     * If it belongs to the state it returns an InfraStructureProvider object
     * @param name
     * @return
     */
    InfraStructureProvider getInfraStructureProvider(String name){
        for(InfraStructureProvider infraProvider : this.infraStructureProviders) {
            if (infraProvider.getName().equals(name)) {
                return infraProvider;
            }
        }
        return null;
    }

    /**
     * This method returns the ArrayList of the InfraStructureProviders
     * @return
     */
    ArrayList<InfraStructureProvider> getInfraStructureProviders(){
        return this.infraStructureProviders;
    }

    /**
     * This method returns the ArrayList of the InternetProviders
     * @return
     */
    ArrayList<InternetProvider> getInternetProviders(){
        return this.internetProviders;
    }
}
