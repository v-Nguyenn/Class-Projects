import random
from pa1 import congruent_to
import your_tester

def main():
  print("Welcome to the Assignment #1 Tester")

  while True:
    user_in = input(
      "\n" + "-" * 50 +
      "\nWhich problem would you like to test?\n1.  Problem 1: congruent_to(a, m, low, high)\n2.  Run your own tester.\nQ.  Quit\n\nEnter your selection: ")
    if user_in == '1':
      print("\n" + "-" * 50 + "\n\nTesting Problem 1...\n\n")
      a = random.randint(-20, 20)
      m = random.randint(4, 15)
      low = random.randint(-30, 30)
      high = random.randint(low + 10, low + 20)

      x_vals = congruent_to(a, m, low, high)
      print(
        f"Range [{low}, {high}], congruent to {a} under modulo {m}...\nReturned: {x_vals}"
      )

      print("\nChecking the correctness of the returned values...")
      for x in x_vals:
        is_correct = (x - a) % m == 0
        print(
          f"\nReturned value: {x}\n\t\tIs {x} congruent to {a} under modulo {m}?"
        )
        if is_correct:
          print(f"\t\t\tYes, {x} is divisible by {m}")
          if x <= high and x >= low:
            print(
              f"\n\t\tIs {x} in the range [{low}, {high}]?\n\t\t\t\tYes.  Test passed!"
            )
          else:
            print(
              f"\n\t\tIs {x} in the range [{low}, {high}]?\n\t\t\tNo.  Test failed."
            )
        else:
          print(f"which is not divisible by {m}  Test failed.")

    elif user_in == '2':
      your_tester.test()
    elif user_in.upper() == 'Q':
      print("Goodbye!")
      break
    else:
      print("Invalid selection.  Please try again.")


if __name__ == "__main__":
  main()
