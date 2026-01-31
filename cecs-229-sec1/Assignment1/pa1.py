# Name: Vincent Nguyen 
# Assignment #1
# Spring 2026

def congruent_to(a, m, low, high):
    x_vals = []
    # Use high + 1 to include the endpoint 
    for val in range(low, high + 1): 
        # Checks if val and a have the same remainder when divided by m
        if val % m == a % m:
            x_vals.append(val) 

    return x_vals

