package part1;

import exceptions.CustomerNotListedException;
import exceptions.IllegalOperationRequest;

import java.util.ArrayList;

/**
 * This Class Implements all the needed method for a generic customer
 * Note that it is an abstract class, because there is no real need to create an object of this class.
 */
public abstract class Customer {
    protected int id;
    protected ArrayList<InfraStructureProvider> infraStructureProviders = new ArrayList<>();
    protected ArrayList<InternetProvider> internetProviders = new ArrayList<>();

    /**
     * Constructor, it fills the customer id with its given value.
     * @param id
     */
    Customer(int id){
        this.id = id;
    }

    /**
     * This method returns the customer id.
     * @return
     */
    int getId(){
        return  this.id;
    }

    /**
     * This method manage the customer actions.
     * It recieved a command from the customer and followes it.
     * It makes sure that if a customer asks to add/remove an Internet provider it works as he wants.
     * If the command can't be fullfiiled, it prints a warning massage or throws an exception.
     * @param command
     * @param provider
     * @throws IllegalOperationRequest
     */

    void handleInternetProvider(String[] command, InternetProvider provider)
            throws IllegalOperationRequest{
        if(provider!=null){
            if(command[0].equals("add") && (command[1].equals(provider.getName()))){
                if(internetProviders.contains(provider)){
                    System.out.println("Customer " + this.getId() + "is already connected to " + provider.getName());
                }
                else {
                    provider.addCustomer(this);
                    internetProviders.add(provider);
                }
            }
            else if(command[0].equals("remove") && command[1].equals(provider.getName())){
                if(!(internetProviders.contains(provider))){
                    System.out.println("Customer " + this.getId() + " does not have " + provider.getName() +" as Internet Provider");
                }
                try{
                    provider.removeCustomer(this);
                    internetProviders.remove(provider);
                }
                catch (CustomerNotListedException e){
                    System.out.println("Customer " +this.getId()+ " is not listed in "+ provider.getName()+" customers list");
                }
            }
            else {
                throw new IllegalOperationRequest();
            }
        }
        else{
            throw new IllegalOperationRequest();
        }
    }
    /**
     * This method works the same as the last method, only for Infra Structure provider.
     */
    void handleInfrastructureProvider(String [] command, InfraStructureProvider provider) throws IllegalOperationRequest {
        if(provider != null){
            if (command[0].equals("add") && command[2].equals(provider.getName())) {
                if (infraStructureProviders.contains(provider)) {
                    System.out.println("Customer " + this.getId() + " is already connected to " + provider.getName());
                }
                else {
                    provider.addCustomer(this);
                    infraStructureProviders.add(provider);
                }
            } else if (command[0].equals("remove") && command[2].equals(provider.getName())) {
                if(!(infraStructureProviders.contains(provider))){
                    System.out.println("Customer " + this.getId() + " does not have " + provider.getName() +" as Infra Provider");
                }
                try {
                    provider.removeCustomer(this);
                    infraStructureProviders.remove(provider);
                } catch (CustomerNotListedException e) {
                    System.out.println("Customer " + this.getId() + " is not listed in " + provider.getName() + " customers list");
                }
            } else {
                throw new IllegalOperationRequest();
            }
        }
        else{
            throw new IllegalOperationRequest();
        }
    }
    abstract double calculateMonthlyPayment();
}

