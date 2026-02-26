# Name: Vincent Nguyen 
# Assignment #4
# Spring 2026

import math

# Place any necessary functions from Assignment 3 here.

def gcd(a, b):
  """ Uses the Euclidian Algorithm to compute the greatest common divisor of two integers, where a >= b.
        :param a: a non-zero integer (positive or negative).
        :param b: a non-zero integer (positive or negative) that is less than or equal to a.
        :returns: the gcd of a and b.
        :raises: ValueError if a or b is 0 or b > a.
  """
  # Update a and b for the Euclidian Algorithm
  a = abs(a)
  b = abs(b)
  
  # throw an exception if the parameters a and/or b have invalid values
  if a == 0 or b == 0:
    raise ValueError("Invalid parameter value.")
  if b > a:
    a, b = b, a
    
  # Use the Euclidian Algorithm to iteratively find the gcd of a and b.
  while b != 0:
    temp = a % b
    a = b
    b = temp

  # return the gcd of a and b.
  return a 

def bezout_coeffs(a, b):
  """ Uses the Extended Euclidian Algorithm to compute the Bezout coefficients of two given positive integers.
      :param a: positive integer > 0
      :param b: positive integer > 0
      :returns: tuple of the bezout coefficients (s, t).
  """
  # Iteratively or recursively calculate the values s and t using the Extended Euclidian Algorithm.
  old_s, s = 1, 0
  old_t, t = 0, 1
  old_r, r = a, b
  
  while r != 0:
    quotient = old_r // r
    old_r, r = r, old_r - quotient * r
    old_s, s = s, old_s - quotient * s
    old_t, t = t, old_t - quotient * t

  #Return the final values for s and t as a tuple (s, t)
  return (old_s, old_t)

""" ----------------- PROBLEM 1 ----------------- """

def mod_inv(a, m):
  """ Computes the inverse of value a under modulus m.
    :param a (int) - the value to find the inverse of under modulus m.
    :param m (int) - the modulus that is > 0.
    :returns the integer inverse of a under modulus m in range [0, m-1].
    :raises: ValueError if m < 1 or if a and m are not relatively prime.
  """
  if m < 1: # TODO: check modulus m for validity.
    raise ValueError(f"mod_inv(a, m) does not support 0 or negative modulus m = {m}.")

  if gcd(a, m) != 1 : # TODO: check that the gcd is relatively prime 
    raise ValueError(f"mod_inv(a, m) does not support integers that are not relatively prime.")
  
  # TODO: reduce value a to be in range [0, m-1]
  

  # TODO: use the Extended Euclidian Algorithm to find the Bezout coefficient of value a.
  # s is coefficient for a and b is coefficient for t: a * s + b * t = gcd(a.b)
  a = a % m
  s, t = bezout_coeffs(a, m)
  inverse = s % m

  # TODO: reduce the calculated inverse to be in range [0, m-1]
  return inverse


""" ----------------- PROBLEM 2 ----------------- """

def solve_linear_congruence(a, b, m, low, high):
  """ Computes all solutions to the equivalence ax ≡ b (mod m) that are in the range [low, high].
    :param a (int) - the coefficient of variable x.
    :param b (int) - the value that a * x is congruent to under modulus m.
    :param m (int) - the modulus that is > 0.
    :param low (int) - the lower bound for the solution range.
    :param high (int) - the upper bound for the solution range.
    :raises: ValueError if high < low or if m < 1.
    """
  if high < low: # TODO: check if high < low.
    raise ValueError(f"solve_linear_congruence() does not support the upper bound {high} less than the lower bound {low}")
  if  m < 1: # TODO: check modulus m for validity.
    raise ValueError(f"solve_linear_congruence() does not support 0 or negative modulus m = {m}")
  
  # TODO: generate a list of solutions to the linear congruence a*x=b(mod m) by iterating through the range and testing each value to see if it is a solution and adding it to the list.
  solutions = []
  for x in range (low, high + 1):
    if (a * x) % m == b % m:
      solutions.append(x)
  return solutions
