# Homework 4
# Vincent Nguyen
# 1162938
# Program set 1
# A list of functions for items a to j that carry out the following tasks
# for a list of integers


# Program to test functions a to j.
#
# Define constant variables.
ONE_TEN = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

def main() :
 print("The original data for all functions is: ", ONE_TEN)
 #a. Demonstrate swapping the first and last element.
 data = list(ONE_TEN)
 swapFirstLast(data)
 print("After swapping first and last: ", data)
 
 #b. Demonstrate shifting to the right.
 data = list(ONE_TEN)
 shiftRight(data)
 print("After shifting right: ", data)
 
 #c. Demonstrate replacing even elements with zero.
 data = list(ONE_TEN)
 replaceEven(data)
 print("After replacing even elements: ", data)
 
 #d. Demonstrate replacing values with the larger of their neighbors.
 data = list(ONE_TEN)
 replaceNeighbors(data)
 print("After replacing with neighbors: ", data)
 
 #e. Demonstrate removing the middle element.
 data = list(ONE_TEN)
 removeMiddle(data)
 print("After removing the middle element(s): ", data)
 
 #f. Demonstrate moving even elements to the front of the list.
 data = list(ONE_TEN)
 evenToFront(data)
 print("After moving even elements: ", data)
 
 #g. Demonstrate finding the second largest value.
 print("The second largest value is: ", secondLargest(ONE_TEN))
 
 #h. Demonstrate testing if the list is in increasing order.
 print("The list is in increasing order: ", isIncreasing(ONE_TEN))
 
 #i. Demonstrate testing if the list contains adjacent duplicates.
 print("The list has adjacent duplicates: ", hasAdjacentDuplicate(ONE_TEN))
 
 #j. Demonstrate testing if the list contains duplicates.
 print("The list has duplicates: ", hasDuplicate(ONE_TEN))
 

def swapFirstLast(data:list) -> list :
    ''' a. Swap the first and last element'''
    #Put into Temporary values
    first = data[0]
    last = data[-1]

    #Replaces their index with each other
    data[0] = last
    data[-1] = first
   

def shiftRight(data:list) -> list :
    ''' b. Shifts elements by one and moves the last one into the first position'''
    #Inserts the last number to the front
    last = data[-1]
    data.insert(0, last)
    
    #Deletes the last one
    del data[-1]


def replaceEven(data:list) -> list :
    ''' c. Replaces all even elements with 0 (zeroes)'''
    #Iterates through
    for n in range(len(data)):
        
        #if it gets a remainder two, it is even. Replace with 0
        if data[n] % 2 == 0:
            data[n] = 0


def replaceNeighbors(data:list) -> list :
    ''' d. Replace each element except the first and last by its larger neighbor'''
    #Iterates through
    for n in range(1, len(data) - 1):
        
        #If index 1 is > index 3 then
        if data[n - 1] > data[n + 1]:
            data[n] = data[n - 1]
        else:
            data[n] = data[n + 1]


def removeMiddle(data:list) -> list :
    ''' e. Remove the middle element if length odd, or the middle 2 element if even'''
    if len(data) % 2 == 0:
        #
        temp = int(len(data)) / 2
        del data[int(temp)]
        del data[int(temp) - 1]
    else:
        del data[int(temp)]

        
def evenToFront(data:list) -> list :
    ''' f. Move all even element to the front, otherwise preserve order of elements'''
    lmao = [] + data
    thirdList = [] + data

    #Removes even first, so ODDS are here
    for ch in thirdList:
        if ch % 2 == 0:
            thirdList.remove(ch)
            
    #Removes odds from the two lists first, so EVENS are here
    for n in (lmao):
        if n % 2 != 0:
            lmao.remove(n)
            data.remove(n)
            
    #With only evens left in data. Loop here appends the odds from the 3rd list to data
    for n in thirdList:
        data.append(n)


def secondLargest(data:list) -> list :
    ''' g. Find the second largest value within the list'''
    data.remove(max(data))
    largest = max(data)
    return largest


def isIncreasing(data:list) -> list :
    ''' h. Return true if the list is currently sorted in increasing order.'''
    increasing = data
    temp = data.sort
    if increasing == data:
        return True
    else:
        return False

def hasAdjacentDupplicate(data:list) -> list :
    ''' i. Return true if the list contains adjacnet duplicates'''
    


main()
