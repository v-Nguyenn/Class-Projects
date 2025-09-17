# Thompson Tran and Vincent Nguyen
# 9/8/25
# user plays hangman and gest 6 incorrect guesses before losing

import check_input
import dictionary
import random
from dictionary import words

def main():
    # checks if user wants to play again
    play_again = True
    while play_again:
        print("-Hangman-\n")

        continue_play = True
        incorrect_guesses = []
        correct_guesses = ['_', '_', '_', '_', '_']
        num_incorrect = 0

        # randomizes the hangman word from the list in dictionary
        hangman_word = words[random.randint(0, len(words) - 1)]
        #print(hangman_word) # used to test code

        # checking to see if the user is still alive (under 6 incorrect and haven't guessed the word)
        while continue_play:
            print("Incorrect selections: ", end='')
            display_letters(incorrect_guesses)
            print()

            display_gallows(num_incorrect)

            display_letters(correct_guesses)
            print()

            print("Letters remaining: ", end='')
            display_letters(get_letters_remaining(incorrect_guesses, correct_guesses))
            print()

            # checks if user has guessed incorrectly 6 times
            if (num_incorrect == 6):
                print("You lose!")

                # breaks out of loop because lost
                continue_play = False

                # asks user to play again
                play_again = check_input.get_yes_no("Play again? (Y/N): ")
                break

            # checks if user has guessed the word
            if (not '_' in correct_guesses):
                print("You win!")

                # asks user to play again
                play_again = check_input.get_yes_no("Play again? (Y/N): ")
                continue_play = play_again
                break


            letter_guess = ""

            # checks user input is a valid letter and not repeated in incorrect or correct guesses
            continue_guess = False
            while not continue_guess:
                # prompts user for a letter input
                letter_guess = input("Enter a letter: ").strip().upper()
                continue_guess = True

                # checks if input is a letter
                if not letter_guess.isalpha() or len(letter_guess) != 1:
                    print("That is not a letter.")
                    continue_guess = False
                    continue

                # checks if input is repeated
                if letter_guess in correct_guesses or letter_guess in incorrect_guesses:
                    print("You have already used that letter.")
                    continue_guess = False

            # if guessed letter is in the hangman word, adds the letter to the correct list
            if letter_guess in hangman_word:
                # puts the letter into the hangman word replacing '_'
                for i in range(len(hangman_word)):
                    if letter_guess == hangman_word[i]:
                        correct_guesses[i] = letter_guess
                print("Correct!\n")
            else:
                # adds letter to incorrect list and updates incorrect counter
                incorrect_guesses.append(letter_guess)
                num_incorrect += 1

# displays the gallows with the number of incorrect guesses through the hanging man
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

# prints the letters in the lists without ' or ,
def display_letters(letters):
    for letter in letters:
        print(letter, end=' ')

    print()

# returns a list of the alphabet without letters guessed
def get_letters_remaining(incorrect, correct):
    remaining_letters = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N','O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z']

    # removes the incorrectly guessed letters from the alphabet
    for letter in incorrect:
        remaining_letters.remove(letter)

    # creates a set of unique letters to remove from the alphabet
    correct_guesses = set()
    for letter in correct:
        correct_guesses.add(letter)

    # removes the correctly guessed letter from the alphabet
    for letter in correct_guesses:
        if letter != '_':
            remaining_letters.remove(letter)

    return remaining_letters

main()