# Author: Vincent Nguyen
# Due: March 26, 2026s
# I filled out the TODO portions of the code.
# Function, doc string, and problem setup is done by professor Shannon Cleary 

import math


""" ----------------- PROBLEM 1 ----------------- """

class Vec:
    def __init__(self, contents=[]):
        """ Constructor defaults to empty vector
        :param contents: list type; list of elements to initialize a vector object, defaults to empty list
        """
        self.elements = contents

    def __abs__(self):
        """ Overloads the built-in function abs(v) to return the Euclidean norm of the vector.
        :returns: float type; the Euclidean norm of the vector.
        """
        # TODO: Find the Euclidian norm of the vector.
        sum_of_squares = 0
        for x in self.elements:
            sum_of_squares += x * x 
        # TODO: Return correct result.
        return math.sqrt(sum_of_squares)

    def __add__(self, other):
        """ Overloads the + operator to support Vec + Vec
        :raises: ValueError if vectors are not same length.
        :returns: Vec type; a Vec object that is the sum vector of this Vec and 'other' Vec
        """
        # Check if the vectors are the same size to add
        if len(self.elements) != len(other.elements):
            raise ValueError("Vectors are not the same size.")
        # TODO: Add self and other vector objects.
        result = []
        # Zip allows use to create a pair from two sets of data
        for self_component, other_component in zip(self.elements, other.elements):
            result.append(self_component + other_component)
        # TODO: Return resulting vector object
        return Vec(result)

    def __sub__(self, other):
        """ Overloads the - operator to support Vec - Vec
        :raises: ValueError if vectors are not same length
        :returns: Vec type; a Vec object that is the difference vector of this Vec and 'other' Vec
        """
        if len(self.elements) != len(other.elements):
            raise ValueError("Vectors are not the same size.")
        # TODO: Subtract self and other vector objects.
        result = []
        for self_component, other_component in zip(self.elements, other.elements):
            result.append(self_component - other_component)
        # TODO: Return resulting vector object
        return Vec(result)

    def __mul__(self, other):
        """ Overloads the * operator to support
              - Vec * Vec (dot product) raises ValueError if vectors are not
                same length in the case of dot product; returns scalar
              - Vec * float (component-wise product); returns Vec object
              - Vec * int (component-wise product); returns Vec object
        """
        
        if type(other) == Vec:  # define dot product
            if len(self.elements) != len(other.elements):
                raise ValueError("Vectors are not the same size.")
            # TODO: Implement dot product
            total = 0
            for self_component, other_component in zip(self.elements, other.elements):
                total += self_component * other_component
            # TODO: Return resulting scalar value
            return total

        elif type(other) == float or type(other) == int:  # scalar-vector multiplication
            # TODO: Implement scalar multiplication.
            result = []
            for self_component in self.elements:
                result.append(self_component * other)
            # TODO: Return the resulting vector.
            return Vec(result) 

    def __rmul__(self, other):
        """ Overloads the * operation to support
              - float * Vec; returns Vec object
              - int * Vec; returns Vec object
        """
        # TODO: Implement scalar multiplication.
        # TODO: Return the resulting vector.
        return self * other

    def __str__(self):
        """Returns string representation of this Vec object."""
        return str(self.elements)
