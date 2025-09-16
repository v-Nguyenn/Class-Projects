# Lab 4 problem 1
# Vincent Nguyen
# 1162938
# Program checks whether country is part of BRICS or not

def main():
    #Input/ Intialize
    BRICS = ["Brazil", "Russia", "India", "China", "Sri Lanka"]
    name = input("Enter the name of country: " )

    #Loop Keeps going unto user inputs n
    while name != "n":
        #Checks whether country is part of BRICS
        if name in BRICS:
            print(name, "is a member of BRICS")
            print()
        else:
            print(name, "is not a member of BRICS")
            print()
        name = input("Enter the name of country: " )

if __name__ == '__main__':
    main()



    
##Test case 1
##============ RESTART: C:\Users\vince\OneDrive\Desktop\Homework.py ============
##Enter the name of country: India
##India is a member of BRICS
##
##Enter the name of country: Pakistan
##Pakistan is not a member of BRICS
##
##Enter the name of country: n
##>>> 
  
##Test case 2
##============ RESTART: C:\Users\vince\OneDrive\Desktop\Homework.py ============
##Enter the name of country: Russia
##Russia is a member of BRICS
##
##Enter the name of country: Sri Lanka
##Sri Lanka is a member of BRICS
##
##Enter the name of country: n
##>>>

##Test case 3
##============ RESTART: C:\Users\vince\OneDrive\Desktop\Homework.py ============
##Enter the name of country: USA
##USA is not a member of BRICS
##
##Enter the name of country: lusitania
##lusitania is not a member of BRICS
##
##Enter the name of country: n
##>>>

##Test case 4
##============ RESTART: C:\Users\vince\OneDrive\Desktop\Homework.py ============
##Enter the name of country: Pakistand
##Pakistand is not a member of BRICS
##
##Enter the name of country: lusitania
##lusitania is not a member of BRICS
##
##Enter the name of country: n
##>>> 

##Test case 5
##============ RESTART: C:\Users\vince\OneDrive\Desktop\Homework.py ============
##Enter the name of country: yolo
##yolo is not a member of BRICS
##
##Enter the name of country: Ruissa
##Ruissa is not a member of BRICS
##
##Enter the name of country:  
##  is not a member of BRICS
##
##Enter the name of country: n
##>>> 
