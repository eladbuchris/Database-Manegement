package part1;

/**
 * This class implements all the method a regular customer needs to be able to do.
 * It inherit all the methods and instances from the Customer class.
 */
public class RegularCustomer extends Customer {
    /**
     * Constructor, it calls its super class ,i.e Customer.
     * @param id
     */
    RegularCustomer(int id){
        super(id);
    }

    /**
     * This method returns the monthly total payment for a regular customer.
     * A regular customer must pay 20% more than the base charge of the provider.
     * @return
     */
    @Override
    double calculateMonthlyPayment() {
        double billForInternet = 0;
        double billForInfra = 0;
        double totalBill = 0;
        double precent = 0.2;
        for (InternetProvider provider : internetProviders){
            billForInternet += (1+precent) * provider.getBaseCharge();
        }
        for ( InfraStructureProvider provider : infraStructureProviders){
            billForInfra += (1+precent) *provider.getBaseCharge();
        }
        totalBill = billForInfra + billForInternet;
        return  totalBill;
    }
}

