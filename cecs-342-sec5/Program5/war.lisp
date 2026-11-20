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

How to run:
- Install Common Lisp
- Navigate to folder where program is

Run in terminal:
sbcl --script war.lisp

Exit: either or work.

(quit) 
(sb-ext:exit)
|#

;;; Define the global suit list with defparameter * *, naming for global
(defparameter *suit-list*
   '(:spades :hearts :diamonds :clubs)) ; syntax: (:) a keyword.

;;; Define the rank to value association list.
(defparameter *rank-values* 
   '(("2" . 2) ; syntax: (') tells lisp it's for data.
     ("3" . 3)
     ("4" . 4)
     ("5" . 5)
     ("6" . 6)
     ("7" . 7)
     ("8" . 8)                                     
     ("9" . 9)
     ("10". 10)
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

;;; suit-letter - Takes in a suit keyword and converts it to a single letter.
;;; Returns: one-letter string
(defun suit-letter (suit)
   (ecase suit ; ecase is like a switch case for Lisp.
   (:spades   "S")
   (:hearts   "H")
   (:diamonds "D")
   (:clubs    "C"))
   )

;;; card-value - Takes in a card struct and looks up numeric strength of card.
;;; Returns: Integer value 
(defun card-value (card)
   ;; let creates local variables * means the steps below can use the ones above.
   (let* ((rank (card-rank card))                           ; card-rank comes from defstruct macro 
          (pair (assoc rank *rank-values* :test #'string=)) ; assoc to look through list pairs.
          (value (cdr pair)))                               ; cdr or rest - grabs right side of the pair which is a value.
      value))                                               ; return the value

;;; card-string - Takes a card and formats for printing such as 10H or AS
;;; Returns: A string
(defun card-string (card)
   (format nil "~a~a"                     ; format nil returns the string filling each ~a in order.
         (card-rank card)                 ; first element to be combined
         (suit-letter (card-suit card)))) ; second element calling suit-letter to convert the suit first.

;;; make-deck - Builds the 52-card deck, one suit at a time
;;; Returns: a list of 52 cards.
(defun make-deck ()
   ;; we use apend and not collect bc it joins each suit's 13 cards into one flat list of 52 cards.
   (loop for suit in *suit-list*                            ; suit is outer because suit is first
         append (loop for (rank . val) in *rank-values*     
               collect (make-card :rank rank :suit suit)))) ; call the make-card constructor  

;;; display-cards - Prints a list of cards, 13 per row by default
;;; Returns: nothing
;; Pass the list of cards and &optional 13 card per row by default.
(defun display-cards (cards &optional (each-row 13)) 
   (loop for card in cards                   
      for i from 1                           ; i goes up each time, just goes up until for runs out or list decides.
      do (format t "~4a "(card-string card)) ; ~4a pads 4 character wide, use card-string to convert the suit first. 
         (when (= (mod i each-row) 0)        ; when - if with no else statement checks if 0 remainder on row. 
            (terpri))))                      ; prints newline after i becomes 13, 26, 39, 52 

;;; shuffle - Mixes a list of cards keeping the original deck.
;;; Returns: a new list 
(defun shuffle (deck)  
   (let ((vec (coerce deck 'vector)))              ; copy list to new vector
      (loop for i from (1- (length vec)) downto 1  ; goes from last index down to 1 
         for j = (random (+ i 1))                  ; picks a random index from 0 to i for j so we can swap with i
         do (rotatef (aref vec i)                  ; swaps card at i with card with j 
                     (aref vec j)))
      (coerce vec 'list)))                         ; change data type from vector to list 

;;; deal - Gives player half of the deck to Player 1 and the second half to Player 2
;;; Returns: nothing
(defun deal (deck player1 player2)
   (setf (player-hand player1) (subseq deck 0 26))   ; goes from index start, up to but does not include the end
   (setf (player-hand player2) (subseq deck 26))     ; goes from start to the end of the list
   )

;;; play-game - Compares two cards, prints the game results, and adds 1 to the winner's wins.
;;; Returns: winning player or NIL for a tie.
(defun play-game (game-num p1 p2 card1 card2)
   (let ((v1 (card-value card1))                                     ; assign card values to v1 and v2, 2-14, Ace high.
         (v2 (card-value card2)))
      ;; Display winner based on sheet ~2d pads the game number, ~4a pads each player card
      (format t "Game ~2d: ~a plays ~4a   ~a plays ~4a" 
                  game-num (player-name p1) (card-string card1) (player-name p2) (card-string card2))
      (cond ((> v1 v2) (format t "-> ~a wins~%" (player-name p1))
                        (incf (player-wins p1))                      ; we increment the player wins by 1     
                           p1)                                       ; return p1 as winner 
            ((< v1 v2) (format t "-> ~a wins~%" (player-name p2))
                        (incf (player-wins p2))
                           p2)
            (t         (format t "-> Tie~%") nil))))                ; returns NIL for a tie where nobody scores.s   


;;; Runs the whole program from start to finish.
(defun main ()
(setf *random-state* (make-random-state t))

(let* ((deck (make-deck))                   ;; make the deck
      (shuffled-deck (shuffle deck))        ;; shuffle the deck
      (p1 (make-player :name "Player 1"))   ;; create the players
      (p2 (make-player :name "Player 2")))  

;; Display created new deck of 52 cards.
(format t "New deck (52 cards):~%")
(display-cards deck)
(terpri)
;; Display shuffled deck of cards of 4 rows.
(format t "Shuffled deck:~%")
(display-cards shuffled-deck)
(terpri)
;; Deal the first 26 cards to player 1 and the last 26 cards to player 2.
(deal shuffled-deck p1 p2)
;; Display Player 1 hand.
(format t "Player 1's hand: (show 26 cards)~%")
(display-cards (player-hand p1))
(terpri)
;; Display Player 2 hand.
(format t "Player 2's hand: (show 26 cards)~%")
(display-cards (player-hand p2))
(terpri)
;; Displays the result of every game.
(format t "--- Let the games begin ---~%")

;; the final score, and the match winner.

   )
      )
(main)