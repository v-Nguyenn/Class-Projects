/**
* Description
* This program calculates the amount of pay that
* will be contributed to a retirement plan if 5%,
* 8%, or 10 % of monthly pay is withheld.
* ref: pg __________
* @author Vincent Nguyen
* @version 09/03/24
*/
public class ContributionVincentNguyen
{
    public static void main(String[] args)
    {
    // Variables to hold the monthly pay and
    // the amount of contribution.
    int monthlyPay = 6000;
    double contribution;
    
    // Calculate and display a 5% contribution.
    contribution = monthlyPay * 0.05;
    System.out.println("5 percent is $" +
        contribution +
            " per month.");
            
    // Calculate and display a 8% contribution.
    contribution = monthlyPay * 0.08;
    System.out.println("8 percent is $" +
    contribution +
    " per month.");
    
    // Calculate and display a 10% contribution.
    contribution = monthlyPay * 0.1;
    System.out.println("10 percent is $" +
    contribution +
    " per month.");
    }
}
//Expected output ====================
//5 percent is $300.0 per month.
//8 percent is $480.0 per month.
//10 percent is $600.0 per month.
