#include <iostream>
#include <sstream>
#include <fstream>
#include <string>

const int TABLESIZE = 10;  // Hash table size

struct VarNode {
    std::string name;
    int value;
    int scope;
    VarNode* next;  // Pointer for next element in chain
};

VarNode* hashTable[TABLESIZE];  // Array of linked lists for chaining
int currentScope = 0;           // Tracks the current scope level
int lineNumber = 0;             // Tracks the current line number

// Hash function to calculate index
int hashFunction(const std::string& varName) {
    int hash = 0;
    for (size_t i = 0; i < varName.size(); ++i) {
        hash += varName[i] * (i + 1); // multiply char value by position 
    }
    return hash % TABLESIZE;          // return index within hash table size
}

// Add a variable to hash table
void addVariable(const std::string& name, int value) {
    int hash = hashFunction(name);
    VarNode* newEntry = new VarNode{name, value, currentScope, nullptr};
    newEntry->next = hashTable[hash]; // link new entry at head
    hashTable[hash] = newEntry;       // update head of list
}

// Find a variable in hash table
VarNode* findVariable(const std::string& name) {
    int hash = hashFunction(name);
    VarNode* current = hashTable[hash];
    VarNode* closest = nullptr;      // track closest

    while (current) {
        if (current->name == name && current->scope <= currentScope) {
            if (!closest || current->scope > closest->scope) {
                closest = current;    // found variable higher priority
            }
        }
        current = current->next;      // move to next entry in chain
    }
    return closest;                   // return variable found or nullptr
}

// Remove all variables from current scope
void clearScope(int scope) {
    for (int i = 0; i < TABLESIZE; ++i) {
        VarNode* current = hashTable[i];
        VarNode* prev = nullptr;

        while (current) {
            if (current->scope == scope) {
                if (prev) {
                    prev->next = current->next;    // go next of current entry
                } else {
                    hashTable[i] = current->next;  // update head if first element
                }
                delete current;                    // free memory
                current = (prev) ? prev->next : hashTable[i];  // move to next
            } else {
                prev = current;                    // update prev pointer
                current = current->next;           // move to next
            }
        }
    }
}

int evaluateExpression(const std::string& expression) {
    // Supporting simple arithmetic: +, -, *, /
    std::istringstream iss(expression);
    int result;
    char operation;

    if (!(iss >> result)) {
        // If it's not a number, it could be a variable
        VarNode* var = findVariable(expression);
        if (var) {
            return var->value;
        } else {
            return -1;  // Variable not found return -1 
        }
    }

    while (iss >> operation) {
        int operand;
        if (!(iss >> operand)) {
            return -1;  // Couldn't process return -1
        }

        switch (operation) {
            case '+':
                result += operand;
                break;
            case '-':
                result -= operand;
                break;
            case '*':
                result *= operand;
                break;
            case '/':
                if (operand == 0) {
                    return -1;  // Division by zero
                }
                result /= operand;
                break;
            default:
                return -1;      // Not an operator we have
        }
    }

    return result;
}

// Execute a BORG program
void executeBORG(const std::string& filename) {
    std::ifstream inputFile(filename);
    if (!inputFile) {
        std::cerr << "Error: Unable to open file " << filename << "\n";
        return;
    }

    std::string line;
    while (std::getline(inputFile, line)) {
        lineNumber++;
        std::istringstream iss(line);
        std::string command;
        iss >> command;

        if (command == "COM") {
            continue;        // ignore comments
        } else if (command == "START") {
            currentScope++;  // increment scope level
        } else if (command == "FINISH") {
            clearScope(currentScope);  // clear all vars in current scope
            currentScope--;  // decrement scope level
        } else if (command == "VAR") {
            std::string varName;
            std::string potentialEquals;
            int value = 0;

            if (iss >> varName) {
                if (iss >> potentialEquals && potentialEquals == "=") {
                    if (!(iss >> value)) {
                        value = 0;  // default value if error
                    }
                }
                addVariable(varName, value);  // add var to hash table
            }
        } else if (command == "PRINT") {
            std::string expression;
            iss >> expression;

            int result = evaluateExpression(expression);
            if (result != -1) {
                static std::string lastPrinted = "";
                if (lastPrinted != expression || result != -1) {
                    std::cout << expression << " is " << result << "\n";  // print result 
                    lastPrinted = expression;
                }
            } else {
                VarNode* var = findVariable(expression);
                if (var) {
                    std::cout << expression << " is " << var->value << "\n";  // print variable value
                } else {
                    std::cout << expression << " is undefined\n";  // variable not found
                }
            }
        } else {
            std::string varName = command;
            std::string operation;
            iss >> operation;

            if (operation == "=") {
                int value;
                iss >> value;
                VarNode* var = findVariable(varName);
                if (var) {
                    var->value = value;           // update existing variable value
                } else {
                    addVariable(varName, value);  // add new variable if not found
                }
            } else if (operation == "++") {
                VarNode* var = findVariable(varName);
                if (var) {
                    var -> value++;               // increment variable value
                } else {
                    std::cout << varName << " is undefined\n";  // error if var not found
                }
            } else if (operation == "--") {
                VarNode* var = findVariable(varName);
                if (var) {
                    var -> value--;               // decrement variable value
                } else {
                    std::cout << varName << " is undefined\n";  // error if var not found
                }
            }
        }
    }

    inputFile.close();             // close file
}

// Initialize the hash table
void startHashTable() {
    for (int i = 0; i < TABLESIZE; ++i) {
        hashTable[i] = nullptr;    // set all entries to null 
    }
}

int main() {
    startHashTable();         // set up hash table

    std::string filename;
    std::cout << "Enter filename for the BORG program: ";
    std::cin >> filename;

    executeBORG(filename);  // run the program

    return 0;
}


/* Output from HelloWorld.txt
Enter filename for the BORG program: HelloWorld.txt
BORAMIR is 25
LEGOLAS is 101
GANDALF is undefined
BORAMIR is 26
GANDALF is 49
BORAMIR is 26
GANDALF is undefined
LEGOLAS is 1000
LEGOLAS is 1000
LEGOLAS is 999

 */