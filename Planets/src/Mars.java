public class Mars extends Currency implements Exchangeable {

    //Constructor
    public Mars(double totalamount) {
        super("MarsMoney", totalamount);
    }

    //Conversion methods
    @Override
    public double toEarthDollars(double amount){
        //variables and calculations 
        double amounttoreturn=amount/EDtoMM;
        //return value
        return amounttoreturn;
    }
    @Override
    public double fromEarthDollars(double EarthDollars){
        //variables and calculations
        double amounttoreturn=EarthDollars*EDtoMM;
        //return value
        return amounttoreturn;
    }
}