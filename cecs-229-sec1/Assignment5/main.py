import random
import math
import pa5
import your_tester

def main():
    print("Welcome to the PA #5 Tester")
    
    while True:
      user_in = input(
          "\n" + "-" * 50 +
          "\nWhich problem would you like to test?\n"
          "1.  Problem 1: shift_encrypt(text, k)\n"
          "2.  Problem 2: shift_decrypt(text, k)\n"
          "3.  Problem 3: rsa_encrypt(text, n, e)\n"
          "4.  Problem 4: rsa_decrypt(text, p, q, e)\n"
          "5.  Run your own tester.\n"
          "Q.  Quit\n\nEnter your selection: "
      )
    
      if user_in == '1':
        print("\n" + "-" * 50 + "\n\nTesting Problem 1...\n\n")
        try:
          expected1 = 'GAJH'
          received1 = pa5.shift_encrypt("XRay", 9)
          print(f"1 of 3: Testing shift_encrypt('XRay', 9)....\n\tExpected: {expected1} \n\tReceived: {received1}")
    
          if expected1 == received1:
            print("\tTest 1 of 3 PASSED!")
          else:
            print("\tTest 1 of 3 FAILED.")
    
          expected2 = 'NXMOW TMF'
          received2 = pa5.shift_encrypt("Black Hat", 12)
          print(f"\n2 of 3: Testing shift_encrypt('Black Hat', 12)....\n\tExpected: {expected2} \n\tReceived: {received2}")
    
          if expected2 == received2:
            print("\tTest 2 of 3 PASSED!")
          else:
            print("\tTest 2 of 3 FAILED.")
            
          expected3 = 'GJJF WZCDIY TJP'
          received3 = pa5.shift_encrypt("Look behind you", -31)
          print(f"\n3 of 3: Testing shift_encrypt('Look behind you', -31)....\n\tExpected: {expected3} \n\tReceived: {received3}")
    
          if expected3 == received3:
            print("\tTest 3 of 3 PASSED!")
          else:
            print("\tTest 3 of 3 FAILED.")
    
        except Exception as e:
          print(f"The following unexpected error occurred:\n{e}")
    
      elif user_in == '2':
        print("\n" + "-" * 50 + "\n\nTesting Problem 2...\n\n")
    
        expected1 = 'XRAY'
        received1 = pa5.shift_decrypt("GAJH", 9)
        print(f"1 of 3: Testing shift_decrypt('GAJH', 9)....\n\tExpected: {expected1} \n\tReceived: {received1}")
    
        if expected1 == received1:
          print("\tTest 1 of 3 PASSED!")
        else:
          print("\tTest 1 of 3 FAILED.")
    
        expected2 = 'BLACK HAT'
        received2 = pa5.shift_decrypt("NXMOW TMF", 12)
        print(f"\n2 of 3: Testing shift_decrypt('NXMOW TMF', 12)....\n\tExpected: {expected2} \n\tReceived: {received2}")
    
        if expected2 == received2:
          print("\tTest 2 of 3 PASSED!")
        else:
          print("\tTest 2 of 3 FAILED.")
    
        expected3 = 'LOOK BEHIND YOU'
        received3 = pa5.shift_decrypt("GJJF WZCDIY TJP", -31)
        print(f"\n3 of 3: Testing shift_decrypt('GJJF WZCDIY TJP', -31)....\n\tExpected: {expected3} \n\tReceived: {received3}")
    
        if expected3 == received3:
          print("\tTest 3 of 3 PASSED!")
        else:
          print("\tTest 3 of 3 FAILED.")
          
      elif user_in == '3':
        print("\n" + "-" * 50 + "\n\nTesting Problem 3...\n\n")
        texts = ['STOP', 'HELP', 'STOPS', 'REPEAT']
        expected = ['20812182', '09810461', '208121821346', '194319342299']
    
        for i in range(len(texts)):
          cipher = pa5.rsa_encrypt(texts[i], 2537, 13)
          print(f"Testing rsa_encrypt({texts[i]}, 2537, 13)\n\tReceived: {cipher}\n\tExpected: {expected[i]}")
          if cipher == expected[i]:
            print("\tTest PASSED!\n")
          else:
            print("\tTest FAILED.\n")
    
      elif user_in == '4':
        print("\n" + "-" * 50 + "\n\nTesting Problem 4...\n\n")
        expected = ['STOP', 'HELP', 'STOPSX', 'REPEAT']
        ciphers = ['20812182', '09810461', '208121821346', '194319342299']
    
        for i in range(len(ciphers)):
          text = pa5.rsa_decrypt(ciphers[i], 43, 59, 13)
          print(f"Testing rsa_decrypt({ciphers[i]}, 43, 59, 13)\n\tReceived: {text}\n\tExpected: {expected[i]}")
          if text == expected[i]:
            print("\tTest PASSED!\n")
          else:
            print("\tTest FAILED.\n")
    
      elif user_in == '5':
          print("\n" + "-" * 50 + "\n\nRunning your own tester...\n\n")
          your_tester.test()
    
      elif user_in.upper() == 'Q':
        break
      else:
        print("Invalid selection.  Please try again.")
main()