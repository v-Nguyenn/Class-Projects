# Name: Vincent Nguyen
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
  if a <= 1 or b < a:  
    raise ValueError("Invalid range.")

  # TODO: initialize a list called 'potential_primes' that contains all integers in the range [a, b]
  potential_primes = list(range(a, b + 1))


  # TODO: initialize variable 'stop' which is the stopping point for the loop in the Sieve of Eratosthenes
  stop = int(math.sqrt(b)) + 1


  # TODO: use a nested set of loops or list comprehensions to iterate through all divisors
  # up to the stop value and each of the potential_primes and test each value to see if it is not prime.
  # Remove any values that are not prime.
  for i in range(2, stop):
    new_list = []
    for p in potential_primes:
      if p == i or p % i != 0:
        new_list.append(p)
    potential_primes = new_list
 
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
  a = abs(a)
  b = abs(b)
  
  # TODO: throw an exception if the parameters a and/or b have invalid values
  if a == 0 or b == 0 or b > a:  
    raise ValueError("Invalid parameter value.")
    
  # TODO: Use the Euclidian Algorithm to iteratively find the gcd of a and b.
  while b != 0:
    temp = a % b
    a = b
    b = temp

  # TODO: return the gcd of a and b.
  return a 


# ----------------- PROBLEM 3 ----------------- #

def bezout_coeffs(a, b):
  """ Uses the Extended Euclidian Algorithm to compute the Bezout coefficients of two given positive integers.
      :param a: positive integer > 0
      :param b: positive integer > 0
      :returns: tuple of the bezout coefficients (s, t).
  """
  # TODO: Iteratively or recursively calculate the values s and t using the Extended Euclidian Algorithm.
  old_s, s = 1, 0
  old_t, t = 0, 1
  old_r, r = a, b
  
  while r != 0:
    quotient = old_r // r
    old_r, r = r, old_r - quotient * r
    old_s, s = s, old_s - quotient * s
    old_t, t = t, old_t - quotient * t
 
  # TODO: Return the final values for s and t as a tuple (s, t)
  return (old_s, old_t)
        
    

    



