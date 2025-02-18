import java.util.Random;
/**
 * Write a description of class demoCounterVNguyen here.
 * This is a demo for 11/07 Thursday Class notes regarding 
 * Chapter 6 methods and terms
 *
 * @author Vincent Nguyen
 * @version 11/07/24
 */
public class demoVNguyen{  

   // You and your friend are working the 
   // Barkley Theater at UCI.
   // You have one entrance, friend has the other. 
   public static void demoCounter()
   {    
       CounterVN ann = new CounterVN();
       CounterVN friend = new CounterVN();
       
       // Waiting for people to come in
       ann.reset();
       friend.reset();
       
       // Check that the counters are correctly reset
       System.out.println("\n" + "-----------------------");
       System.out.println("Ann has: " + ann.getCount());
       System.out.println("Friend has: " + friend.getCount());
       
       // Friend has 10 people walk through 
       for(int i = 0; i < 10; i++){
            friend.click();
       }
       
       // Ann has an random number people walk through
       Random rndNum = new Random();
       int ranPeople = rndNum.nextInt(20) + 5;
       for(int i = 0; i < ranPeople; i++){
            ann.click();
       }
      
       // Check out how many people have entered
       System.out.println("------------------------------------");
       System.out.println("Door's open and a few people come in ");
       System.out.println("Ann has: " + ann.getCount());
       System.out.println("Friend has: " + friend.getCount()); 
   }
   
   // Testing the machine 
   // create one voting machine called blue which 
   // simulates a state that is mostly democrats
   // create another voting machine called red which 
   // simulates a state mostly voting for Trump
   public static void demoVoteMachine()
   {
       VotingMachineVNguyen blue = new VotingMachineVNguyen();
       VotingMachineVNguyen red = new VotingMachineVNguyen();
       Random ran = new Random();
       
       // Make the blue machine collect 75% democrat, 25% republican
       // use a random number generator
       for(int vote = 1; vote < 1000000; vote++)
       {
       if(ran.nextDouble() <= 0.75)
       {
           blue.voteD();
       }
       else
       {
           blue.voteR();
       }
       }
       
       // Now report or print how many voted demo, vote rep in the blue state.
   }
}
