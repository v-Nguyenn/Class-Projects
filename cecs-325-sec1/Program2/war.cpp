// Author: Vincent Nguyen
// CECS 325-0
// Program 2 - One Card War
// Due 02/23/2026
// 
// I certify that this program is my own original work. I did not copy 
// any part of this program from any other source including AI use. I 
// did not share this program with anyone. I further certify that I typed
// each and every line of code in this program.

#include <iostream>
#include <vector>
#include <cstdlib>
#include <stdexcept>
using namespace std;

/**
 * @brief Represents a card and has functions to compare cards and display the cards
 */
class Card
{
   private:
      char rank;
      char suit;

   public:
      // constructor to create a card, setting the suit and rank
      Card(char cardRank, char cardSuit) 
      {
         rank = cardRank;
         suit = cardSuit; 
      }
      // Display and compare are public because they are used by other functions
      void display() // display the card example: AC, 10S, KD 
      {
         if (rank == 'T') // for the special case of number 10
         {
            cout << "10" << suit;
         }
         else
         {
            cout << rank << suit;
         }
      }

      // Adjusted names of variable names from program 1 to be more clear 
      int compare(Card other) // return 1 for win, 0 for tie, -1 for lose
      { 
         // Initialize two index values that will be used to compare values.
         int playerOneCardRankIndex = -1;
         int playerTwoCardRankIndex = -1;
         // Order of values to rank the value from lowest to highest.
         char rankOrder[] = {'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K'};
         // Iterates through the rankOrder[] to assign it its proper index value
         for (int i = 0; i < size(rankOrder); i++)
         {
            if (rank == rankOrder[i])
            {
               playerOneCardRankIndex = i;
            }
            if (other.rank == rankOrder[i])
            {
               playerTwoCardRankIndex = i;
            }
         }

         // Finally compare the user's value to other card value based on index
         if (playerOneCardRankIndex > playerTwoCardRankIndex)
         {
            return 1; // Player 1 wins
         }
         else if (playerOneCardRankIndex < playerTwoCardRankIndex)
         {
            return -1; // Player 1 loses
         }
         return 0; // tie 
      }

}; // I keep forgetting to put this semicolon, must do for classes and structs, but dont 
// include in main. 

/**
 * @brief A deck of 52 cards and has functions to deal, display, shuffle, and check
 * if the deck is empty.
 */
class Deck
{
   private:
      vector<Card> cards;
      char ranks[13] = {'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K'};
      char suits[4] = {'C', 'S', 'D', 'H'};

   public:
      // Deck constructor takes populates the vector of cards using the two static arrays
      Deck()
      {
         // Populate vector deck using two loops to iterate through static arrays of rank and suit
         // Changed index for more clarity from program 1 and swapped loop order for desired output
         for (int suitIndex = 0; suitIndex < 4; suitIndex++)
         {
            for (int rankIndex = 0; rankIndex < 13; rankIndex++)
            {
               cards.push_back(Card(ranks[rankIndex], suits[suitIndex]));
            }
         }
      }
      // Deals a card if you can - otherwise we raise an exception
      Card deal()
      {
         if (cards.empty())
         {
            throw out_of_range ("Deck is empty.");
         }
         Card dealtCard = cards.back(); // Get the last card
         cards.pop_back();
         return dealtCard;
      }

      // Displays the deck by using a forward loop to iterate through the size of the deck. 
      void display()
      { 
         // Iterates throug
         for (int i = 0; i < cards.size(); i++)
         {
            // Like program 1 calls the display function to show each card.
            cards[i].display();
            // Every thirteen lines goes to a new line for the row x column display.
            if ((i + 1) % 13 == 0)
            {
               cout << endl;
            }
            else // Prints a comma after each card
            {
               cout << ", ";
            }
         }
      }
      
      // Shuffles the deck using random using current time.
      void shuffle()
      {
         srand(time(0)); // Seed random number generator from in class. 
         // Start at the last index, move to the beginning placing a random card
         for (int i = cards.size() - 1; i > 0; i--)
         {
         // Pick a random index from 0 to i 
         int randomIndex = rand() % (i + 1); 
         Card temp = cards[i];
         cards[i] = cards[randomIndex];
         cards[randomIndex] = temp;  
         }
      }

      // Checks if deck is empty, returns true if deck is empty
      bool isEmpty()
      {
         if (cards.empty())
         {
            return true;
         }
      }
};

/**
 * @brief A struct to keep track of player name and statistics.
 */
struct Player
{
   string name;
   int win;
   int lose;
   int tie;
};

int main()
{
   // Initialize players
   Player player1;
   Player player2;
   int numOfGames;

   // Create deck
   Deck playDeck;

   cout << endl;
   cout << "Enter the name of the first player: ";
   cin >> player1.name;
   player1.win = 0;
   player1.lose = 0;
   player1.tie = 0;

   cout << "Enter the name of the second player: ";
   cin >> player2.name;
   player2.win = 0;
   player2.lose = 0;
   player2.tie = 0;

   // Program asks how many games user wants to play
   cout << "How many games will they play? ";
   cin >> numOfGames;
   cout << endl;

   // Display the original deck ordered
   cout << "Original Deck\n";
   playDeck.display();
   cout << endl;

   // Display the deck shuffled
   cout << "Shuffled Deck\n";
   // Shuffle deck 10 times for good measure
   for (int i = 0; i < 10; i++)
   {
      playDeck.shuffle();
   }
   playDeck.display();

   try
   {
      for(int i = 0; i < numOfGames; i++)
      {
         Card card1 = playDeck.deal();
         Card card2 = playDeck.deal();

         // Display the card to see the comparison
         cout << endl;
         cout << "Game " << i + 1 << endl;
         cout << "------" << endl;
         cout << "      " << player1.name << " => ";
         card1.display();
         cout << endl;
         cout << "      " << player2.name << " => ";
         card2.display();
         cout << endl;

         int result = card1.compare(card2);
         if (result == 1)
         {
            cout << player1.name << " ==> Winner " << endl;
            player1.win += 1;
            player2.lose += 1;
         }
         else if (result == 0)
         {
            cout << "Tie game " << endl;
            player1.tie += 1;
            player2.tie += 1;
         }
         else 
         {
            cout << player2.name << " ==> Winner " << endl;
            player2.win += 1;
            player1.lose += 1;
         } 
      }
   }
   catch (const out_of_range& e)
   {
      cout << "Error " << e.what() << endl;
   }

         // Print final stat board
         cout << endl;
         cout << "------ Final Stats ------\n";
         cout << "   " << player1.name << " vs. " << player2.name << endl;
         cout << "Wins:   " << player1.win << "     " << player2.win << endl;
         cout << "Losses: " << player1.lose << "     " << player2.lose << endl;
         cout << "Ties:   " << player1.tie << "     " << player2.tie << endl; 
   return 0;
}