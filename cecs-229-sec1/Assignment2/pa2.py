# Name: Vincent Nguyen 
# Assignment #2
# Spring 2026


# ---------------- PROBLEM 1 ---------------- #
def b_rep(decimalNum, base):
    """ Converts decimal integer decimalNum into base and returns it as a string. The base must be an integer between 2-36."""
    binaryDigits = []  # stores the digits of the b-representation of n
    quotient = decimalNum
    while quotient != 0:
        digit = quotient % base 
        if base > 10 and digit > 9:  
            # Added values to match up to base 36
            hexDict = {10: 'A', 11: 'B', 12: 'C', 13: 'D', 14: 'E', 15: 'F', 16: 'G',
                        17: 'H', 18: 'I', 19: 'J', 20: 'K', 21: 'L', 22: 'M', 23: 'N',
                        24: 'O', 25: 'P', 26: 'Q', 27: 'R', 28: 'S', 29: 'T', 30: 'U',
                        31: 'V', 32: 'W', 33: 'X', 34: 'Y', 35: 'Z'}
            digit = hexDict[digit]
        binaryDigits.append(digit)
        quotient = quotient // base
    # Reverse then build one string character
    binaryDigits.reverse() 
    result = ""
    for digit in binaryDigits:
        result += str(digit)
    return result


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
        a_i = int(a[i]) # a_i is a single bit at the position i
        b_i = int(b[i])

        # str to concantenate result
        result = str((a_i + b_i + carry) % 2) + result # Compute bit of the result 
        carry = (a_i + b_i + carry) // 2 # Compute bit of any carry 
    if carry == 1:
        result = '1' + result 
    return result


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
            partial_products.append(b + '0' * i) 
        i += 1

    result = '0'
    while len(partial_products) > 0:
        result = binary_add(result, partial_products[0])
        del partial_products[0]
    return  result 
