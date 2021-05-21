package part1;

import exceptions.CustomerNotListedException;

import java.util.ArrayList;

/**
 * This class implements all the methods needed for an Internet provider.
 */
public class InternetProvider {
    private String name;
    private double baseCharge; // The monthly charge of the provider.
    private ArrayList<Customer> customers = new ArrayList<>();

    /**
     * The constructor of the class, It fills the name and base charge instances with the given values.
     * @param providerName
     * @param baseCharge
     */
    InternetProvider(String providerName, double baseCharge){
        this.name = providerName;
        this.baseCharge = baseCharge;
    }

    /**
     * This method returns the provider's name
     * @return
     */
    String getName(){
        return this.name;
    }

    /**
     * This method returns the monthly charge of the provider.
     * @return
     */
    double getBaseCharge(){
        return this.baseCharge;
    }

    /**
     * This method adds a customer given to it to the provider's customers Arraylist.
     * If the customer already exists in the Arraylist, It prints a warning massage.
     * @param customer
     */
    void addCustomer (Customer customer){
        if(customers.contains(customer)){
            System.out.println("Customer " + String.valueOf(customer.getId()) + " already connected to " + this.getName());
        }
        customers.add(customer);
    }

    /**
     * This method removes the customer given to it from the provider's Arraylist.
     * If the customer doesn't exists in the provider's Arraylist, it throws an exception.
     * @param customer
     * @throws CustomerNotListedException
     */
    void removeCustomer(Customer customer) throws CustomerNotListedException{
        if(customers.contains(customer)){
            customers.remove(customer);
        }
        else {
            throw new CustomerNotListedException();
        }
    }

    /**
     * This method returns the provides's customers Arraylist.
     * @return
     */
    ArrayList<Customer> getCustomersList(){
        return customers;
    }
}

