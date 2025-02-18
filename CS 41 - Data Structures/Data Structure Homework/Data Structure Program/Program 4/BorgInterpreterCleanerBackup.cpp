#include <iostream>
#include <sstream>
#include <fstream>
#include <string>

const int TABLESIZE = 10;  // Hash table size

struct VariableEntry {
    std::string name;
    int value;
    int scope;
    VariableEntry* next;  // Pointer 
};

VariableEntry* hashTable[TABLESIZE];  // Array of linked lists 
int currentScope = 0;                 // Tracks the current scope
int lineNumber = 0;                   // Tracks the current line number

// Hash function
int hashFunction(const std::string& varName) {
    int hash = 0;
    for (size_t i = 0; i < varName.size(); ++i) {
        hash += varName[i] * (i + 1);  // Implicit conversion from char to int
    }
    return hash % TABLESIZE;
}

// Add a variable to the hash table
void addVariable(const std::string& name, int value) {
    int hash = hashFunction(name);
    VariableEntry* newEntry = new VariableEntry{name, value, currentScope, nullptr};
    newEntry->next = hashTable[hash];
    hashTable[hash] = newEntry;
}

// Find a variable in the hash table
VariableEntry* findVariable(const std::string& name) {
    int hash = hashFunction(name);
    VariableEntry* current = hashTable[hash];
    VariableEntry* closest = nullptr;

    while (current) {
        if (current->name == name && current->scope <= currentScope) {
            if (!closest || current->scope > closest->scope) {
                closest = current;
            }
        }
        current = current->next;
    }
    return closest;
}

// Remove all variables from the current scope
void clearScope(int scope) {
    for (int i = 0; i < TABLESIZE; ++i) {
        VariableEntry* current = hashTable[i];
        VariableEntry* prev = nullptr;

        while (current) {
            if (current->scope == scope) {
                if (prev) {
                    prev->next = current->next;
                } else {
                    hashTable[i] = current->next;
                }
                delete current;
                current = (prev) ? prev->next : hashTable[i];
            } else {
                prev = current;
                current = current->next;
            }
        }
    }
}

// Parse and evaluate arithmetic expressions
int evaluateExpression(const std::string& expression) {
    size_t pos = expression.find('*');  // Only supports multiplication for now
    if (pos != std::string::npos) {
        std::string varName = expression.substr(0, pos);
        int multiplier = std::stoi(expression.substr(pos + 1));
        VariableEntry* var = findVariable(varName);
        if (var) {
            return var->value * multiplier;
        } else {
            std::cerr << "Error: Variable " << varName << " is not defined.\n";
            return -1;
        }
    }
    return -1;
}

// Execute a BORG program
void executeBORGProgram(const std::string& filename) {
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
            continue;  // ignore comments
        } else if (command == "START") {
            currentScope++;
        } else if (command == "FINISH") {
            clearScope(currentScope);
            currentScope--;
        } else if (command == "VAR") {
            std::string varName;
            std::string potentialEquals;
            int value = 0;

            if (iss >> varName) {
                if (iss >> potentialEquals && potentialEquals == "=") {
                    if (!(iss >> value)) {
                        std::cerr << "Error: Expected a value after '=' at line " << lineNumber << "\n";
                        value = 0;  // Default value
                    }
                }
                addVariable(varName, value);
            } else {
                std::cerr << "Error: Missing variable name at line " << lineNumber << "\n";
            }
        } else if (command == "PRINT") {
            std::string expression;
            iss >> expression;

            int result = evaluateExpression(expression);
            if (result != -1) {
                std::cout << expression << " IS " << result << "\n";
            } else {
                VariableEntry* var = findVariable(expression);
                if (var) {
                    std::cout << expression << " IS " << var->value << "\n";
                } else {
                    std::cout << expression << " IS UNDEFINED\n";
                }
            }
        } else {
            std::string varName = command;
            std::string operation;
            iss >> operation;

            if (operation == "=") {
                int value;
                iss >> value;
                VariableEntry* var = findVariable(varName);
                if (var) {
                    var->value = value;
                } else {
                    addVariable(varName, value);
                }
            } else if (operation == "++") {
                VariableEntry* var = findVariable(varName);
                if (var) {
                    var->value++;
                } else {
                    std::cout << varName << " IS UNDEFINED\n";
                }
            } else if (operation == "--") {
                VariableEntry* var = findVariable(varName);
                if (var) {
                    var->value--;
                } else {
                    std::cout << varName << " IS UNDEFINED\n";
                }
            }
        }
    }

    inputFile.close();
}

// Initialize the hash table
void initializeHashTable() {
    for (int i = 0; i < TABLESIZE; ++i) {
        hashTable[i] = nullptr;
    }
}

int main() {
    initializeHashTable();

    std::string filename;
    std::cout << "Enter the filename for the BORG program: ";
    std::cin >> filename;

    executeBORGProgram(filename);

    return 0;
}
