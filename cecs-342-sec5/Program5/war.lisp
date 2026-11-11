#|
Name: Vincent Nguyen
Class: CECS 342 Section 5
Project Name: Prog 5 - One Card War Lisp
Due Date: 11/19/2026

I certify that this program is my own original work. I did not
copy any part of this program from any other source including
inappropriate AI use. I did not share this program with anyone.
I further certify that I typed each and every line of code in this
program.

Description: 
A program which shuffles a standard 52-card deck and deals half
to each of the two players and plays 26 games to decide which
player wins the match.
|#

;;; Define the global suit list with defparameter * *, naming for global
(defparameter *suit-list*
   '(:spades :hearts :diamonds :clubs)) ; syntax: (:) a keyword.

;;; Define the rank to value association list.
(defparameter *rank-values* 
   '(("2" . 2) ; syntax: (') tells lisp its for data.
     ("3" . 3)
     ("4" . 4)
     ("5" . 5)
     ("6" . 6)
     ("7" . 7)
     ("8" . 8)
     ("9" . 9)
     ("10" . 10)
     ("J" . 11)
     ("Q" . 12)
     ("K" . 13)
     ("A" . 14)))

;;; Card struct: each card containing a respective rank and a suit.
(defstruct card
   rank
   suit)

;;; Player struct: Player may have a name, a list of cards, and their wins.
(defstruct player
   name
   hand
   (wins 0))

;; Converts 
(defun suit-letter (suit)
   ; Convert suit keyword to single letter
   (ecase suit
   (:spades   "S")
   (:hearts   "H")
   (:diamonds "D")
   (:clubs    "C"))
   )

(defun card-value (card)
   (card-rank, rank-values):
   )

(defun card-string (card)
   )

(defun main
;; Build an ordered 52-card deck and display it 
;; Shuffle the deck and display the shuffled deck.
;; (Optional) Ask for 2 player's names.
;; Deal the first 26 cards to player 1 and the last 26 cards to player 2
;; Display each hand, playing 26 games
;; Displays the result of every game, the final score, and the match winner.
())