
/**
 * Description
 * This is a small program that calculates
 * the discount from a sale
 * ______________________
 * @author Vincent Nguyen
 * @version 09/03/24
 */

public class DiscountVincentNguyen
{
    public static void main(String[] args)
    {

    }

    public static void Discount()
    {
        double salePrice;
        double discount;
        double discountedPrice;
        double regularPrice = 59.0;
        
        // Calculate the amount of a 20% discount
        discount = 0.2;
        discountedPrice = regularPrice * discount;
        
        //Calculate the sale price by subtracting 
        // the discount from the regular price.
        salePrice = regularPrice - discountedPrice;
        
        
        // Display the results
        System.out.println("Regular price: $" + regularPrice);
        System.out.println("Discounted price:$" + discount);
        System.out.println("Sale price:$" + salePrice);
        
    }

}