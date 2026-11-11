#|
Name: Vincent Nguyen
Class: CECS 342 Section 5
Project Name: Prog 5 - One Card War Lisp
Due Date: 11/19/2026

Description: These are test cases after making every 
             defstruct or function. 

How to run:
- Ensure Common Lisp is installed.

sbcl --script test-war.lisp 2>&1 | head -30

Exit: either or work.

(quit) 
(sb-ext:exit)

|#

;; Import or load war.lisp file reading top to bottom.
(load "war.lisp")

;;; Check global variable *suit-list* prints out the list, 
;;; expected length, and the first one.
(format t "---------------------------------------------- ~%")
(format t "suit-list:~%")
(print *suit-list*)
(terpri)
(format t "Expected length: 4 ~%")
(format t "Actual length: ~s~%" (length *suit-list*))
(format t "Expected first: :spades~%")
(format t "Actual first: ~s~%~%" (first *suit-list*))


;;; Check global variable *rank-values* prints out pairs,
;;; first pair, left half and right half, and if lookup works.
(format t "---------------------------------------------- ~%")
(format t "rank-values list: ~% ")
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
(format t "lookup K: ~s (expect 13)~%"
         (cdr (assoc "K" *rank-values* :test #'string=)))
