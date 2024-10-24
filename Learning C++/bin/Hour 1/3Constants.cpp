#include <iostream>

int main(){
   // double pi = 3.14159; 
   // pi = 420.69; // this lets people change the value 

   // const makes it read only so you cant change it
   const double PI = 3.14159;
   const int LIGHT_SPEED = 299792458; 
   const int WIDTH = 1920;
   const int HEIGHT = 1080;

   double radius = 10;
   double circumference = 2 * PI * radius;

   std::cout << "Circumference: ", circumference;
   
   std::cout << circumference << "cm";

   return 0;
}