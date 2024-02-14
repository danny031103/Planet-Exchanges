public class Saturn extends Currency implements Exchangeable {

    //Constructor
    public Saturn(double totalamount) {
        super("SaturnSilver", totalamount);
    }
    
    //Conversion method
    @Override
    public double toEarthDollars(double amount){
        //variable and calculation
        double amounttoreturn=amount/EDtoSS;
        //return value
        return amounttoreturn;
    }

    //Conversion method
    @Override
    public double fromEarthDollars(double EarthDollars){
        //variable and calculation
        double amounttoreturn=EarthDollars*EDtoSS;
        //return value
        return amounttoreturn;
    }
}