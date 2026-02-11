# Name: Vincent Nguyen 
# Assignment #2
# Spring 2026


# ---------------- PROBLEM 1 ---------------- #
def b_rep(n, b):
    """ Converts decimal integer n into base b and returns it as a string. The base b must be an integer between 2-36."""
    digits = []  # stores the digits of the b-representation of n
    q = n
    while q != 0:
        digit = # TODO: update 'digit' to be the remainder of q divided by b
        if b == 16 and digit > 9:  # TODO: update for other bases > 10
            hex_dict = {10: 'A', 11: 'B', 12: 'C', 13: 'D', 14: 'E', 15: 'F'} # TODO: update for other bases > 10
            # TODO: update digit
        digits.append(digit)
        q = # TODO: update q to the correct value.
    return  # TODO: return the string of digits


# ---------------- PROBLEM 2 ---------------- #
def binary_add(a, b):
    """ Adds binary strings a and b and returns the resulting binary string. """
    # removing all whitespace from the strings
    a = a.replace(' ', '')
    b = b.replace(' ', '')

    # padding the strings with 0's so they are the same length
    if len(a) < len(b):
        diff = len(b) - len(a)
        a = "0" * diff + a
    elif len(a) > len(b):
        diff = len(a) - len(b)
        b = "0" * diff + b

    # addition algorithm
    result = ""
    carry = 0
    for i in reversed(range(len(a))):
        a_i = int(a[i])
        b_i = int(b[i])

        # TODO: update result += ....
        # TODO: update carry =
    if carry == 1:
        result += # TODO: update 'result' to the correct value."
    return  # TODO: return the appropriate string


# ---------------- PROBLEM 3 ---------------- #
def binary_mul(a, b):
    """ Multiplies binary strings a and b and returns the resulting binary string. """
    # removing all whitespace from the strings
    a = a.replace(' ', '')
    b = b.replace(' ', '')

    # multiplication algorithm
    partial_products = []
    i = 0  # index of the current bit of string 'a' beginning at 0, right-to-left
    for bit in reversed(a):
        if bit == '1':
            partial_products.append() #TODO: append the appropriate partial product
        i += 1

    result = '0'
    while len(partial_products) > 0:
        result = binary_add() #TODO: input the correct arguments
        del partial_products[0]
    return  # TODO: return the appropriate result
