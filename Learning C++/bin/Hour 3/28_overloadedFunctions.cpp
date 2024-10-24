#include <iostream>

// Overloaded functions - you can have different versions
// of functions

// functions can share the same name but need to have different
// parameters

// A functions name + a functions parameter is known as a
// functions signature
// each one needs to be unique like an ID

void bakePizza();
void bakePizza(std::string topping1);
void bakePizza(std::string topping1, std::string topping2);

int main()
{
   bakePizza("pepperonis"); 
   bakePizza("Sausage", "Bacon");
   
   return 0;
}

void bakePizza()
{
   std::cout << "Here is your pizza!\n";
}

void bakePizza(std::string topping1)
{
   std::cout << "Here is your " << topping1 << " pizza!\n";
}

void bakePizza(std::string topping1, std::string topping2)
{
   std::cout << "Here is your " << topping1 << " and " <<
                topping2 << "  pizza ";
}