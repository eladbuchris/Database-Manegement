package part1;

import csv.CSVRecord;
import csv.Constants;
import csv.SEFileUtil;
import exceptions.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * The Main class of our software, it implements a main method and a parseData method.
 */
public class Main {
    HashMap<Integer,Customer> customers = new HashMap<>();
    /**
     * This method reads from the outside data and works with all the other classes to get the wanted result.
     * It receives a path to the csv file and a State Object.
     * It goes over the data, row after row, and calls the needed method at each iteration.
     * It fills a HashMap, its keys are the Customer Id, and its values are Customer objects.
     * If an eligle command is given, it catches an IllegalOperationRequest Exception and prints a warning by the given exception.
     * @param path
     * @param state
     */
    void parseData(String path, State state){
        SEFileUtil customersData = new SEFileUtil(path);
        for (CSVRecord record : customersData.getCSVParser()){
            if (customers.containsKey(Integer.parseInt(record.get(0)))) {
            } else if (record.get(1).equals("Regular")) {
                customers.put(Integer.parseInt(record.get(0)), new RegularCustomer(Integer.parseInt(record.get(0))));
            } else if (record.get(1).equals("Government")) {
                customers.put(Integer.parseInt(record.get(0)), new GovernmentCustomer(Integer.parseInt(record.get(0))));
            } else if(record.get(1).equals("VIP")) {
                customers.put(Integer.parseInt(record.get(0)), new VIPCustomer(Integer.parseInt(record.get(0))));
            }
            else{
                System.out.println("Illegal customer type");
                continue;
            }
            String[] commandInternetArray = record.get(2).split(" ");
            String[] commandInfraArray = record.get(3).split(" ");
            try{
                customers.get(Integer.parseInt(record.get(0))).handleInternetProvider(commandInternetArray,
                       state.getInternetProvider(commandInternetArray[1]));
                customers.get(Integer.parseInt(record.get(0))).handleInfrastructureProvider(commandInfraArray,
                        state.getInfraStructureProvider(commandInfraArray[2]));
            }
            catch (IllegalOperationRequest e){
                if((!(commandInternetArray[0].equals("add")))&&(!(commandInternetArray[0].equals("remove")))) {
                    System.out.println("Command not legal");
                }
                else if (!(state.getInternetProviders().contains(state.getInternetProvider(commandInternetArray[1])))){
                    System.out.println(commandInternetArray[1] + " is not an internet provider");
                    }
                else if(!(state.getInfraStructureProviders().contains(state.getInfraStructureProvider(commandInfraArray[2])))){
                    System.out.println(commandInfraArray[2] + " is not an infrastructure provider");
                }
            }
        }
    }

    /**
     * The main method calls the parseData method and initiate new Main and State objects.
     * It as well prints the first 10 customers of a given Internet provided and Infra Structure provider.
     * @param args
     */
    public static void main(String[] args){
        Main m = new Main();
        State state = new State("IL");
        state.init();
        m.parseData(args[0], state);
        ArrayList<Customer> partnerCustomers = state.getInternetProvider(Constants.PARTNER).getCustomersList();
        System.out.println("First 10 customers of Partner are: ");
        for(int i=0 , count=0 ; i< partnerCustomers.size() && count<10; i++, count++){
            System.out.print(partnerCustomers.get(i).getId() + " ");
        }
        ArrayList<Customer> hotCustomers = state.getInfraStructureProvider(Constants.HOT).getCustomersList();
        System.out.println("\n First 10 customers of Hot are: ");
        for(int i=0, count=0; i<hotCustomers.size() && count<10; i++ , count++){
            System.out.print(hotCustomers.get(i).getId()+ " ");
        }
    }
}

