/*
Name: Vincent Nguyen
Class: CECS 342 Section 5
Project Name: Prog 3 - Language History in Prolog
Due Date: 10/15/2026

I certify that this program is my own original work. I did
not copy any part of this program from any other source
including inappropriate AI use. I did not share this program
with anyone. I further certify that I typed 
each and every line of code in this program.

Run Program:
- (Tested on SWI-Prolog 10.0.2)

- swipl tree.pl
- ?- (Run query).
- e.g created('Language', Year desired)
- created(X, Y). % Gives you first language followed by year.


Queries run in program:
- Show all languages older than the year 2000.
older_than(L, 2000). See line 178 for rule.

- Show all ancestors of C++.
setof(A, ancestor(A, 'C++'), Ancestors).

- Show all the siblings of C++
- Show all the cousins of C++
- Show all the descendants of FORTRAN.

- Is Rust related to Common Lisp? If so, how?
setof(A, (ancestor(A, 'Rust'), ancestor(A, 'Common Lisp')), Related).

- Is Swift a descendant of Lisp?

Description:
This is a Prolog program that represents the language history in the 
figure provided, building facts that identify when each language
was created, as well as the relationships between languages.
*/

% Create a timeline matching when languages were spawned.
created('Fortran 1',         1956).
created('Lisp',              1958).
created('COBOL',             1960).
created('Algol 60',          1960).
created('PL/1',              1964).
created('Smalltalk',         1968).
created('Pascal',            1970).
created('Prolog',            1970).
created('Scheme',            1974).
created('ML',                1976).
created('Fortran 77',        1976).
created('C (K&R)',           1978).
created('Smalltalk 80',      1980).
created('Ada 83',            1982).
created('C++',               1984).
created('Common Lisp',       1984).
created('SML',               1984).
created('Perl',              1986).
created('Eiffel',            1986).
created('Caml',              1986).
created('Tcl',               1988).
created('Python',            1990).
created('Fortran 90',        1990).
created('Java',              1994).
created('JavaScript',        1994).
created('Ruby',              1994).
created('Perl 5',            1994).
created('OCaml',             1996).
created('C++ (ISO)',         1998).
created('Scheme R5RS',       1998).
created('Haskell 98',        1998).
created('C#',                2000).
created('Python 2.0',        2000).
created('Java 5',            2004).
created('C# 2.0',            2004).
created('Go',                2008).
created('Kotlin',            2010).
created('Rust',              2010).
created('Haskell 2010',      2010).
created('C# 5.0',            2012).
created('Java 8',            2014).
created('Swift',             2014).
created('JavaScript ES2017', 2016).

% Parent fact relation parent('Parent', 'Child')
% "Parent is a parent of C if C came directly from P."
parent('Fortran 1', 'Algol 60').
parent('Fortran 1', 'PL/1').
parent('Fortran 1', 'Fortran 77').

parent('Lisp', 'Scheme').
parent('Lisp', 'Common Lisp').

parent('COBOL', 'PL/1').

parent('Algol 60', 'Tcl').
parent('Algol 60', 'C++').
parent('Algol 60', 'C (K&R)').
parent('Algol 60', 'Smalltalk').
parent('Algol 60', 'Perl').
parent('Algol 60', 'Scheme').
parent('Algol 60', 'PL/1').

parent('PL/1', 'Pascal').

parent('Smalltalk', 'Smalltalk 80').

parent('Pascal', 'Python').
parent('Pascal', 'Ada 83').

parent('Scheme', 'Scheme R5RS').
parent('Scheme', 'Common Lisp').

parent('ML', 'SML').
parent('ML', 'Haskell 98').

parent('Fortran 77', 'Fortran 90').

parent('C (K&R)', 'C++').
parent('C (K&R)', 'Python').

parent('Smalltalk 80', 'Go').
parent('Smalltalk 80', 'Ruby').

parent('Ada 83', 'Eiffel').

parent('C++', 'Java').
parent('C++', 'C++ (ISO)').
parent('C++', 'Rust').
parent('C++', 'Python').

parent('SML', 'Caml').

parent('Perl', 'Ruby').
parent('Perl', 'Perl 5').

parent('Eiffel', 'Ruby').

parent('Caml', 'OCaml').

parent('Python', 'Python 2.0').
parent('Python', 'Ruby').

parent('Java', 'Java 5').
parent('Java', 'C#').
parent('Java', 'JavaScript').

parent('JavaScript', 'Kotlin').
parent('JavaScript', 'JavaScript ES2017').

parent('Ruby', 'Swift').

parent('OCaml', 'Rust').

parent('C++ (ISO)', 'C#').

parent('Scheme R5RS', 'Rust').

parent('Haskell 98', 'Rust').
parent('Haskell 98', 'Haskell 2010').

parent('C#', 'C# 2.0').

parent('Python 2.0', 'Swift').
parent('Python 2.0', 'Go').

parent('Java 5', 'Java 8').
parent('Java 5', 'Kotlin').

parent('C# 2.0', 'Kotlin').
parent('C# 2.0', 'C# 5.0').
parent('C# 2.0', 'Rust').

parent('Rust', 'Swift').

parent('Haskell 2010', 'Swift').

parent('C# 5.0', 'Swift').
parent('C# 5.0', 'JavaScript ES2017').

% Use fact when languages were created to establish any languages 
% older than 2000, or any year.
older_than(Language, Cutoff) :- created(Language, Y), Y < Cutoff.

% Based on geneology2.txt provided.
% Sibling: "is true if" parent of X is also parent of Y.
% X \= Y, X and Y must be different languages
sibling(X, Y) :- parent(P, X), parent(P, Y), X \= Y. 

% Ancestor: "A is ancestor of D if a path can be followed from A to D."
ancestor(A, D) :- parent(A, D).
ancestor(A, D) :- parent(A, D1), ancestor(D1, D).

% Descendant: "D is a descendant of A if A is an ancestor of D."
% e.g. child(C, P) :- parent(P, C).
descendant(D, A) :- ancestor(A, D). % Gives duplicates

% Cousin: "X and Y are cousins if they both share the same ancestor."
cousin(X, Y) :- ancestor(A, X), ancestor(A, Y).