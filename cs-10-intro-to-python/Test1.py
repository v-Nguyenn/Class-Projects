# Homework 5 problem 1
# Vincent Nguyen
# 11629380
# This program calculates and displays the total from the tea sales.

def main():
    # Open file
    tea_file = open('tea.txt', 'r')
    tea_list = []
    tea_dict = {}
    
    for tea_data in tea_file:
        # Copies and strips information
        tea_list.append(tea_data.rstrip('\n').split(':'))

    print(tea_list)
          

    # Close file     
    tea_file.close()

main()

    
