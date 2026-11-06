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

use rand::prelude::*;  // for rng() and random_range
// const needs type u = unsigned int, i = signed int
const ARRAY_SIZE: usize = 31; // Size of binary tree
const MAX_VALUE: u32 = 99;  // Max integer value for random numbers 
const MIN_VALUE: u32 = 10;  // Min integer value for random numbers

fn main() {
    // Create a binary tree with 31 items (5 levels).
    // Store the binary tree in an array of size 31 (indexed 0 to 30).
    // Fill the array up with random numbers 10 to 99 and do not allow duplicates.
    let mut binary_tree: [u32; ARRAY_SIZE] = create_binary_tree();
    
    // Test: create_binary_tree();
    println!("{:?}", binary_tree); 

    // Display the unsorted binary tree on the screen. 
    // print_tree(&binary_tree);

    // User can hit continue with enter key.

    // Run the process that sorts the array.
    heap_sort(&mut binary_tree);              // Lend binary_tree to sort.
    let binary_tree = binary_tree; // We shadow and lock it down.
    
    // Test: build_max_heap (sorted)
    println!("{:?}", binary_tree);

    // Print out binary tree after sort. Smallest number should be at the root.
    // print_tree(&binary_tree);

    // Allow user to press a key to continue.
    // Take sorted tree and announce to user, then display all numbers in order on line.
}

/// Generates an array of an ARRAY_SIZE(31) with unique integers.
fn create_binary_tree() -> [u32; ARRAY_SIZE] {
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
        array_tree[i] = random_int; // we assign the new index 
    }
    array_tree                      // No semicolon = return value
}

/// Sorts the array while maintaining the binary heap/tree
fn heap_sort(tree: &mut [u32; ARRAY_SIZE]){
    build_max_heap(tree); // Use build_max_heap
//     for i in n..0{
//         tree.swap(a, b);
//         n = n - 1;
//         Heapify(tree, 0);
//     }
}


/// Helper function to move highest value to index 0,
/// Making every parent >= its children.
fn build_max_heap(tree: &mut [u32; ARRAY_SIZE]){
    for i in 1..ARRAY_SIZE {
        let mut current = i;

        while current != 0 {
            let parent = (current - 1) / 2;

            if tree[current] > tree[parent] {
                tree.swap(current, parent);
                current = parent;
            } else {
                break
            }
        }
    }
}

/*
/// Helper function for heapsort, moves highest value to last index.
fn heapify(tree: &mut [u32; ARRAY_SIZE){
    let mut left = 2i + 1;
    let mut right = 2i + 2;

    if(left <= n) 
}

/// 
fn print_tree(any_array: &[u32; ARRAY_SIZE]){
    todo!()
}
*/