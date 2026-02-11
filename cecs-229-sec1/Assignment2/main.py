import random
from pa2 import b_rep
from pa2 import binary_add
from pa2 import binary_mul
import your_tester


def main():
  print("Assignment #2 Tester:")

  while True:
    user_in = input(
      "\n" + "-" * 50 +
      "\nWhich problem would you like to test?\n1.  Problem 1: b_rep(n, b)\n2.  Problem 2: binary_add(a, b)\n3.  Problem 3: binary_mul(a, b)\n4.  Run your own tester.\nQ.  Quit\n\nEnter your selection: "
    )

    if user_in == '1':
      print("\n" + "-" * 50 + "\n\nTesting Problem 1...\n\n")
      a = random.randint(10, 50)
      print(f"Decimal integer: {a}")
      expected2 = bin(a)[2:]
      returned2 = b_rep(a, 2)

      expected8 = oct(a)[2:]
      returned8 = b_rep(a, 8)
      expected16 = hex(a)[2:].upper()
      returned16 = b_rep(a, 16)

      print()
      print("%-20s %-20s%10s%-20s%-20s" %
            ('b-representation', 'Returned Value', ' ', 'Expected Value',
             'Test Passed?'))
      print("%-20s %-20s%10s%-20s%-15s" % ('2-representation', returned2, ' ',
                                           expected2, returned2 == expected2))
      print("%-20s %-20s%10s%-20s%-15s" % ('8-representation', returned8, ' ',
                                           expected8, returned8 == expected8))
      print("%-20s %-20s%10s%-20s%-15s" %
            ('16-representation', returned16, ' ', expected16, returned16
             == expected16))

    elif user_in == '2':
      print("\n" + "-" * 50 + "\n\nTesting Problem 2...\n\n")
      a = random.randint(4, 10)
      b = random.randint(2, 10)

      a2 = bin(a)[2:]
      b2 = bin(b)[2:]

      expected = b_rep(a + b, 2)
      returned = binary_add(a2, b2)
      print("%-30s%-20s%-20s%-20s" %
            (' ', 'Integer a', 'Integer b', 'Expected sum'))
      print("%-30s%-20s%-20s%-20s" % ('Decimal representation', a, b, a + b))
      print("%-30s%-20s%-20s%-20s" %
            ('Binary representation', a2, b2, expected))

      print("\n\nReturned sum:", returned)

      if expected == returned:
        print("Test passed.")
      else:
        print("Test failed.")

    elif user_in == '3':
      print("\n" + "-" * 50 + "\n\nTesting Problem 3...\n\n")
      a = random.randint(4, 10)
      b = random.randint(2, 10)

      a2 = bin(a)[2:]
      b2 = bin(b)[2:]

      expected = b_rep(a * b, 2)
      returned = binary_mul(a2, b2)
      print("%-30s%-20s%-20s%-20s" %
            (' ', 'Integer a', 'Integer b', 'Expected Product'))
      print("%-30s%-20s%-20s%-20s" % ('Decimal representation', a, b, a * b))
      print("%-30s%-20s%-20s%-20s" %
            ('Binary representation', a2, b2, expected))

      print("\n\nReturned product:", returned)

      if expected == returned:
        print("Test passed.")
      else:
        print("Test failed.")
    elif user_in == '4':
      your_tester.test()
    elif user_in.upper() == 'Q':
      print("Goodbye!")
      break
    else:
      print("Invalid selection.  Please try again.")


main()
