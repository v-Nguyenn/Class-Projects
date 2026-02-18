# Name: 
# Assignment #3
# Spring 2026

import math

# ----------------- PROBLEM 1 ----------------- #

def primes(a, b):
  """ Returns all primes in the inclusive range [a, b] using the Sieve of Eratosthenes.
      :param a: a positive integer greater than 1
      :param b: a positive integer greater than or equal to a.
      :return: a list of all primes in the inclusive range [a, b]
      :raises: ValueError if a <= 1 or b < a 
  """
  # TODO: throw an exception when the parameters a and/or b have invalid values
  if :  
    raise ValueError("Invalid range.")

  # TODO: initialize a list called 'potential_primes' that contains all integers in the range [a, b]
  potential_primes = []


  # TODO: initialize variable 'stop' which is the stopping point for the loop in the Sieve of Eratosthenes
  stop = 


  # TODO: use a nested set of loops or list comprehensions to iterate through all divisors
  # up to the stop value and each of the potential_primes and test each value to see if it is not prime.
  # Remove any values that are not prime. 
 
 
 
 
 
  # return the remaining primes
  return potential_primes


# ----------------- PROBLEM 2 ----------------- #

def gcd(a, b):
  """ Uses the Euclidian Algorithm to compute the greatest common divisor of two integers, where a >= b.
        :param a: a non-zero integer (positive or negative).
        :param b: a non-zero integer (positive or negative) that is less than or equal to a.
        :returns: the gcd of a and b.
        :raises: ValueError if a or b is 0 or b > a.
  """
  # TODO: Update a and b for the Euclidian Algorithm
  a = 
  b = 
  
  # TODO: throw an exception if the parameters a and/or b have invalid values
  if :  
    raise ValueError("Invalid parameter value.")
    
  # TODO: Use the Euclidian Algorithm to iteratively find the gcd of a and b.


  # TODO: return the gcd of a and b.
  return 


# ----------------- PROBLEM 3 ----------------- #

def bezout_coeffs(a, b):
  """ Uses the Extended Euclidian Algorithm to compute the Bezout coefficients of two given positive integers.
      :param a: positive integer > 0
      :param b: positive integer > 0
      :returns: tuple of the bezout coefficients (s, t).
  """
  # TODO: Iteratively or recursively calculate the values s and t using the Extended Euclidian Algorithm.
 
 
 
  # TODO: Return the final values for s and t as a tuple (s, t)
  return (s, t)
        
    

    



