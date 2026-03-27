# Author: Vincent Nguyen
# Due: February 4, 2026
# I filled out the TODO portions of the code 
# Function, doc string, and problem setup is done by professor Shannon Cleary

def congruent_to(a, m, low, high):
    x_vals = []
    # TODO: Use high + 1 to include the endpoint 
    for val in range(low, high + 1): 
        # TODO: Checks if val and a have the same remainder when divided by m
        if val % m == a % m:
            x_vals.append(val) 

    return x_vals

