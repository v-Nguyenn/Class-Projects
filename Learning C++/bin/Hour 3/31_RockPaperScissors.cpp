#include <iostream>
#include <ctime> // for random number

char getUserChoice();
char getComputerChoice();
void showChoice(char choice);
void chooseWinner(char player, char computer);

int main()
{
   char player; 
   char computer;

   player = getUserChoice();
   std::cout << "Your choice: ";
   showChoice(player);

   if(player == 'x'){
      std::cout << "Thank you for playing!";
   }
   else{
   computer = getComputerChoice();
   std::cout << "Computer's choice: ";
   showChoice(computer);

   chooseWinner(player, computer);
   }
   
   return 0;
}

char getUserChoice(){ 

   char player;
   std::cout << "Rock-Paper-Scissors Game!\n";
  
   do{
   std::cout << "Choose one of the following:\n";
   std::cout << "****************************\n";
   std::cout << "'r' for rock\n";
   std::cout << "'p' for paper\n";
   std::cout << "'s' for scissors\n";
   std::cout << "'x' for exit\n";
   std::cin >> player;
      
   }while (player != 'r' && player != 's' && player != 'p' && player != 'x');
  
   return player;
}

char getComputerChoice(){

   srand(time(0));
   int num = rand() % 3 + 1; // + 1 is so it starts at one then goes to 3

   switch(num)
   {
   case 1: return 'r';
   case 2: return 'p';
   case 3: return 's';
   }   
   return 0;
}

void showChoice(char choice){

   switch (choice)
   {
   case 'r': std::cout << "Rock\n";
             break;
   case 's': std::cout << "Scissors\n";
             break;
   case 'p': std::cout << "Paper\n";
             break; 
   }
}

void chooseWinner(char player, char computer){
      
      switch (player)
      {
      case 'r': if(computer == 'r'){
                     std::cout << "It's a tie!\n";
               }  
                else if(computer == 'p'){
                     std::cout << "You lose!\n";
               }
               else{
                     std::cout << "You win!\n";
               }
               break;
               
      case 's': if(computer == 's'){
                     std::cout << "It's a tie!\n";
               }
                  else if(computer == 'p'){
                     std::cout << "You win!\n";
               }
                  else{
                     std::cout << "You lose!\n";
               }
               break;
      
      case 'p': if(computer == 'p'){
                     std::cout << "It's a tie!\n";
               }
               else if(computer == 's'){
                     std::cout << "You lose!\n";
               }
               else{
                     std::cout << "You win!\n";
               }
               break;
      }
}