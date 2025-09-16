# Lab 4 problem 3
# Vincent Nguyen
# 1162938
# Program to remove all duplicates from a list.

#Allows the user to unput data into the list
def createList()-> list:
    origList = []
    for l in range(1,11):
        addNum = int(input("Enter numbers lmao: "))
        origList.append(addNum)
    return origList

#Function will remove duplicates
def removeDuplicates(origList:list)-> list:
    newList = []
    for num in origList:
        if num not in newList:
            newList.append(num)
    return newList
            
#Calls the functions above and prints
def main():
    origList = createList()
    newList = removeDuplicates(origList)
    print("Original List: ", origList)
    print("List after removing duplicates: ",newList)


if __name__ == '__main__':
    main()
