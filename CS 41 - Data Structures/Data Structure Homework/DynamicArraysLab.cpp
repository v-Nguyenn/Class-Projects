#include <iostream>

int main() {
    
    // User inputs array size
    std::cout << "Enter the size of the array: ";
    int size;
    std::cin >> size;
    int* numberArray = new int[size];
    int count = 0;

    // Gets numbers from user through loop
    for (int i = 0; i < size; i++) {
        std::cout << "Enter your numbers: ";
        int number;
        std::cin >> number;
        numberArray[count] = number;
        count++;
    }

    // print list
    std::cout << "The array is: ";
    for (int i = 0; i < count; i++) {
        std::cout << numberArray[i] << " ";
    }
    std::cout << std::endl;
    return 0;
}