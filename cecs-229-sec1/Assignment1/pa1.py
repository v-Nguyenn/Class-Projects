# Name: Vincent Nguyen 
# Assignment #1
# Spring 2026

def congruent_to(a, m, low, high):
    x_vals = []
    for val in range(low, high + 1): # TODO: define the range to iterate through.
        if val % m == a % m: # TODO: check if the value is congruent to a (mod m).
            x_vals.append(val) # TODO: add the value to x_vals
    return x_vals

