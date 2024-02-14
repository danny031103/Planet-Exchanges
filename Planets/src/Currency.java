public abstract class Currency implements Exchangeable{
    //Data members
    protected String name_of_curr;
    protected double totalamount;

    //Constructor
    public Currency(String name_of_curr, double amount){
        this.name_of_curr=name_of_curr;
        this.totalamount=amount;
    }

    //Getter-name_of_curr
    public String getName(){
        return name_of_curr;
    }

    //Getter-amount
    public double getAmount(){
        return this.totalamount;
    }

    //Add Currency
    public void addCurrency(double amountadd){ 
        this.totalamount+=amountadd;
    }

    //Subtract currency
    public void subtractCurrency(double amountsubtract){
        if (amountsubtract>this.totalamount){
            System.out.println("Can't withdraw more than balance.");
        }
        else{
            this.totalamount-=amountsubtract;
        }
    }

    //Conversion methods
    //Abstract because each method needs to define it for their own currency/conversion
    public abstract double toEarthDollars(double amount);
    public abstract double fromEarthDollars(double EarthDollars);

    //Fee method
    public double getFee(double amount){
        double feepercent=0;
        double fee=0;
        if(this instanceof Mars){
            feepercent=0.10;
            fee=amount*feepercent;
        }
        else if (this instanceof Neptune){
            fee=5;
        }
        else if (this instanceof Saturn){
            fee=0;
        }
        return fee;
    }

    //Exchange method
    public void exchange(Currency other, double amount){
        if (other instanceof Currency){
            //Variables
            double fee=getFee(amount);
            //Calculations
            double amountinEarth=toEarthDollars(amount);
            double feeamountinotherplanet=other.fromEarthDollars(amountinEarth);
            double totalamountinotherplanet=other.fromEarthDollars(amountinEarth)+other.getAmount();
            //Formatting- Name Variables
            String nameofthis=this.getClass().getName();
            String nameofother=other.getClass().getName();
            //Formatting-Capitalization
            String capname=nameofthis.substring(0,1).toUpperCase()+nameofthis.substring(1);
            String capthatname=nameofother.substring(0,1).toUpperCase()+nameofother.substring(1);

            //Output
            if (this.totalamount>amount){
                this.totalamount-=(amount+fee);
                other.totalamount=totalamountinotherplanet;
                System.out.println("Converting from "+this.name_of_curr+" to "+other.name_of_curr +" and initiating transfer…");
                System.out.println(String.format("%.2f", amount)+" "+this.name_of_curr+" = "+String.format("%.2f", amountinEarth)+" EarthDollars = "+String.format("%.2f", feeamountinotherplanet)+" "+other.name_of_curr);
                System.out.println(capname+" exchange fee is "+String.format("%.2f", fee)+" "+this.name_of_curr);
                System.out.println(capname+" has a total of "+ String.format("%.2f", this.totalamount) +" "+this.name_of_curr);
                System.out.println(capthatname+" has a total of "+ String.format("%.2f", totalamountinotherplanet) +" "+other.name_of_curr);
                System.out.println();
            }
            else{
                System.out.println("Uh oh - "+capname+" only has an available balance of "+String.format("%.2f", this.totalamount)+", which is less than "+String.format("%.2f", amount)+"!");
                System.out.println();
            }
        }
        else{
            System.out.println("Can't exchange with non-currency object.");
        }
    }
}


