public class Neptune extends Currency implements Exchangeable {

    //Constructor
    public Neptune(double totalamount) {
        super("NeptuneNuggets", totalamount);
    }

    //Conversion method
    @Override
    public double toEarthDollars(double amount){
        //variables and calculations 
        double amounttoreturn=amount/EDtoNN;
        //return value
        return amounttoreturn;
    }
    //Conversion method
    @Override
    public double fromEarthDollars(double EarthDollars){
        //variables and calculations
        double amounttoreturn=EarthDollars*EDtoNN;
        //return value
        return amounttoreturn;
    }
}