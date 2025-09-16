# Thompson Tran and Vincent Nguyen
# 9/8/25
#

import check_input
import dictionary
import random
from dictionary import words

def main():
    print("-Hangman-\n")

    continue_play = True
    incorrect_guesses = ['F', 'Z']
    correct_guesses = ['_', '_', '_', '_', '_']
    num_correct = 0
    num_incorrect = 0

    while(num_correct < 5 and num_incorrect < 6):
        print("Incorrect selections: ", end='')
        display_letters(incorrect_guesses)
        print()

        display_gallows(num_incorrect)

        display_letters(correct_guesses)
        print()

        print("Letters remaining: ", end='')
        display_letters(get_letters_remaining(incorrect_guesses, correct_guesses))
        print()
        
        while continue_play:
            letter_guess = input("Enter a letter: ").strip().upper()
            if len(letter_guess) != 1 or not letter_guess.isalpha():
                print("That is not a letter.")
                continue
            
            if letter_guess in incorrect_guesses or letter_guess in correct_guesses:
                print("You have already used that letter.")
                
        
        
        

        random.randint(0, len(words))

#
def display_gallows(num_incorrect):
    print("========")
    print("||/   |")
    match(num_incorrect):
        case(0):
            print("||")
            print("||")
            print("||")
        case(1):
            print("||    o")
            print("||")
            print("||")
            print("||")
        case(2):
            print("||    o")
            print("||    |")
            print("||")
        case(3):
            print("||    o")
            print("||    |")
            print("||   /")
        case(4):
            print("||    o")
            print("||    |")
            print("||   / \\")
        case(5):
            print("||   \\o")
            print("||    |")
            print("||   / \\")
        case(6):
            print("||   \\o/")
            print("||    |")
            print("||   / \\")
    print("||\n")

#
def display_letters(letters):
    for letter in letters:
        print(letter, end=' ')

    print()
#
def get_letters_remaining(incorrect, correct):
    remaining_letters = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N','O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z']

    for letter in incorrect:
        remaining_letters.remove(letter)

    for letter in correct:
        if letter != '_':
            remaining_letters.remove(letter)

    return remaining_letters


main()