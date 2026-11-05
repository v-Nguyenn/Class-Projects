/* 
Name: Vincent Nguyen
Class: CECS 342 Section 5
Project Name: Prog 4 - Rusty Heap Sort
Due Date: 11/05/2026

I certify that this program is my own original work. I did 
not copy any part of this program from any other source 
including inappropriate AI use. I did not share this program
with anyone. I further certify that I typed each and every
line of code in this program.

Description: 
    This writes a program that does a graphical heap
    sort and shows the heap, step by step as it does its work.
*/

use rand::{prelude::*};  // for rng() and random_range
const ARRAY_SIZE: usize = 31; // Size of binary tree
const MAX_VALUE: u32 = 99;  // Max integer value for random numbers 
const MIN_VALUE: u32 = 10;  // Min integer value for random numbers

fn main() {
    // Create a binary tree with 31 items (5 levels).
    // Store the binary tree in an array of size 31 (indexed 0 to 30).
    // Fill the array up with random numbers 10 to 99 and do not allow duplicates.
    let binary_tree = create_binary_tree();
    
    // Test: create_binary_tree();
    println!("{:?}", binary_tree); 

    // Display the unsorted binary tree on the screen. User can hit continue with enter key.
    //print_tree(&binary_tree);

    // Run the process that sorts the array while maintaining the binary tree/heap.
    //let mut sorted_tree = heap_sort(&mut binary_tree);

    // Print out binary tree after sort. Smallest number should be at the root.
    //print_tree(&sorted_tree);

    // Allow user to press a key to continue.
    // When you have the sorted tree, announce to user, then display all numbers in order on line.
   // print_row(&sorted_tree);
}

fn create_binary_tree() -> [u32; ARRAY_SIZE] {
    // const needs type u = unsigned int, i = signed int
    
    let mut array_tree: [u32; ARRAY_SIZE] = [0; ARRAY_SIZE]; // Declare array
    let mut rng = rand::rng();

    // Fill array with random numbers
    for i in 0..ARRAY_SIZE {
        // Generate a random integer from min value to max value inclusive from RandomExamples.rs 
        let mut random_int = rng.random_range(MIN_VALUE..MAX_VALUE + 1); 
        // Verify no duplicates, use slice to check the slots we filled. 
        while array_tree[0..i].contains(&random_int){
            // Generate new one until there is no duplicate.
            random_int = rng.random_range(MIN_VALUE..MAX_VALUE + 1);
        }
        array_tree[i] = random_int;
    }
    array_tree // No semicolon = return value
}

/*
fn heap_sort(&binary_tree){
    todo!()
}

fn print_tree(&any_array){
    todo!()
}

fn print_row(&sorted_tree){
    todo!()
}
*/