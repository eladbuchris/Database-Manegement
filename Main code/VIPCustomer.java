package part1;
/**
 * This class implements all the methods needed for a Vip customer.
 * It inherit from the Customer class.
 */
public class VIPCustomer extends Customer{
    /**
     *Constructor, it calls its super class ,i.e Customer.
     * @param id
     */
    VIPCustomer(int id){
        super(id);
    }
    /**
     *This method returns the monthly total payment for a VIP customer.
     * A VIP customer pays a random amount between 0 to base charge.
     * @return
     */
    @Override
    double calculateMonthlyPayment() {
        double billForInternet = 0;
        double billForInfra = 0;
        double totalBill;
        for (InternetProvider provider : internetProviders){
            billForInternet += (Math.random())*(provider.getBaseCharge());
        }
        for ( InfraStructureProvider provider : infraStructureProviders){
            billForInfra += (Math.random())*(provider.getBaseCharge());
        }
        totalBill = billForInfra + billForInternet;
        return  totalBill;
    }
}

