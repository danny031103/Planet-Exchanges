public interface Exchangeable {

    //Exchange Rates
    double EDtoMM=1.30;
    double EDtoSS=0.87;
    double EDtoNN=2.0;

    //Exchange Method
    public void exchange(Currency other, double amount);

    //Exchange Method
    double toEarthDollars(double amount);

    //Exchange Method
    double fromEarthDollars(double EarthDollars);

}

