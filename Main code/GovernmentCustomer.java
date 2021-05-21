package part1;

/**
 * This class implements all the methods needed for a government customer.
 * It inherit from the Customer class.
 */
public class GovernmentCustomer extends Customer {
    /**
     *Constructor, it calls its super class ,i.e Customer.
     * @param id
     */
    GovernmentCustomer(int id){

        super(id);
    }

    /**
     *This method returns the monthly total payment for a government customer.
     * A government customer pays the subtracted cost, the base charge - (the provider's payment to the government)
     * @return
     */
    @Override
    double calculateMonthlyPayment() {
        double billForInternet = 0;
        double billForInfra = 0;
        double totalBill = 0;
        final double InternetPayment = 150;
        final double InfraPayment = 200;
        for (InternetProvider provider : internetProviders){
            billForInternet += provider.getBaseCharge() - InternetPayment;
        }
        for ( InfraStructureProvider provider : infraStructureProviders){
            billForInfra += provider.getBaseCharge() - InfraPayment;
        }
        totalBill = billForInfra + billForInternet;
        if(totalBill > 0){
            return  totalBill;
        }
        return 0;
    }
}
