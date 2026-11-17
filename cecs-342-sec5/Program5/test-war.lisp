#|
Name: Vincent Nguyen
Class: CECS 342 Section 5
Project Name: Prog 5 - One Card War Lisp
Due Date: 11/19/2026

Description: 
These are test cases after making every 
defstruct or function. 

How to run:
- Ensure Common Lisp is installed.

- Command to run in terminal on MAC
sbcl --script test-war.lisp 2>&1 | head -60

Exit: either or work.

(quit) 
(sb-ext:exit)

|#

;; Import or load war.lisp file reading top to bottom.
(load (merge-pathnames "war.lisp" *load-truename*))

;;; Check global variable *suit-list* prints out the list, 
;;; expected length, and the first one.
(format t "---------------------------------------------- ~%")
(format t "Testing suit-list...~%")
(format t "----------------------------------------------")
(print *suit-list*)
(terpri)
(format t "Expected length: 4 ~%")
(format t "Actual length: ~s~%" (length *suit-list*))
(format t "Expected first: :spades~%")
(format t "Actual first: ~s~%~%" (first *suit-list*))

;;; Check global variable *rank-values* prints out pairs,
;;; first pair, left half and right half, and if lookup works.
(format t "---------------------------------------------- ~%")
(format t "Testing rank-values list... ~%")
(format t "---------------------------------------------- ")
(print *rank-values*)
(terpri) ; terminate print line 
;; How many pairs
(format t "Expected length: 13 ~%")
(format t "Actual length: ~s~%" (length *rank-values*))
;; What is the first pair, and it's left and right side of the pair.
(format t "First pair: ~s~%" (first *rank-values*))
(format t "Expected key: \"2\"~%")
(format t "Actual key: ~s~%" (car (first *rank-values*)))
(format t "Expected value: 2 ~%")
(format t "Actual value: ~s~%" (cdr (first *rank-values*)))
;; Does a lookup work ?
(format t "lookup K: ~s (expect 13)~%~%"
         (cdr (assoc "K" *rank-values* :test #'string=)))

;;; card struct test   
;;; the whole card structure, rank, suit checks if card is valid.
(format t "---------------------------------------------- ~%")
(format t "Testing card struct... ~%")
(format t "----------------------------------------------")
(defparameter *c* (make-card :rank "4" :suit :spades))
(print *c*)  
(terpri)                                  ; see all
(format t "~%Expected Rank: \"4\" ~%" )       ;read first place
(format t "Actual Rank: ~s~%" (card-rank *c*)) ;read second place
(format t "Expected Suit: :spades~%")
(format t "Actual Suit: ~s~%" (card-suit *c*))
;; -p means predicated, answers a yes/no question.
(format t "Is it a card? ~s (expect T)~%" (card-p *c*))      
(format t "Is 15 a card? ~s (expect NIL)~%" (card-p 15)) ;reject non-cards

;;; Player struct test
;;; Test making a player, wins 
(format t "---------------------------------------------- ~%")
(format t "Testing player struct...~%")
(format t "---------------------------------------------- ~%")
(defparameter *p* (make-player :name "Joe"))
(format t "Expected wins: 0~%")
(format t "Actual wins: ~s~%"(player-wins *p*))
; player wins so increment by 1
(incf (player-wins *p*))
(format t "Expected wins: 1~%")
(format t "Actual wins: ~s~%"(player-wins *p*)) 
; player second win.
(incf (player-wins *p*))
(format t "Expected wins: 2~%")
(format t "Actual wins: ~s~%"(player-wins *p*))

;;; Check make-deck builds 52 cards in suit order.
;;; Make deck once, print whole deck
(format t "---------------------------------------------- ~%")
(format t "Testing make-deck function... ~%")
(format t "---------------------------------------------- ~%")
(defparameter *deck* (make-deck))
;; Checks first card
(format t "first card: ~s (expect \"2S\")~%" (card-string (first *deck*)))
;; Prints the whole deck
(format t "Whole Deck: ~%")
(print (mapcar #'card-string *deck*))
(terpri)
