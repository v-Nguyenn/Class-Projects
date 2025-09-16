# Lab 4 problem 2
# Vincent Nguyen
# 1162938
# Program creates a list of numbers in a range of 1 to 10 then deletes
# all the even number from the list and print the final list.

#Function to create th list of numbers from 1 to 10
def makeList():
    numList = []
    for i in range (1,11):
       numList.append(i)
    return(numList)
#Function to delete even numbers from list
def delEven(numList:list)-> list:
    newList = []
    newList = newList + numList
    for even in newList:
        if even % 2 == 0:
           newList.remove(even)
    return(newList)

#Calls the functions above and prints the results
def main():
    numList = makeList()
    newList = delEven(numList)
    print("Origrinal List = ", numList)
    print("List after deleting even numbers: ", newList)

if __name__ == '__main__':
    main()

