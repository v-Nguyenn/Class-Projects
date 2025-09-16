#Vincent Nguyen
#1162938

def main():
    # Open file
    tea_file = open('tea.txt', 'r')
    tea_list = []
    tea_dict = {}
    
    for tea_data in tea_file:
        # Copies and strips information
        tea_list.append(tea_data.rstrip('\n').split(':'))
        
    print(tea_list)
    print(tea_list[0][0])
    # Close file     
    tea_file.close()



main()
