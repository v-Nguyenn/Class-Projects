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

use std::io::{self, Write}; 
use rand::prelude::*; // for rng() and random_range

// const needs type u = unsigned int, i = signed int
const ARRAY_SIZE: usize = 31; // Size of binary tree
const MAX_VALUE: u32 = 99; // Max integer value for random numbers 
const MIN_VALUE: u32 = 10; // Min integer value for random numbers
const TREE_LEVELS: usize = 5; // The levels of a tree 
const TREE_WIDTH: usize = 64; // how much space in a row

fn main() {
    // Create a binary tree with 31 items (5 levels).
    // Store the binary tree in an array of size 31 (indexed 0 to 30).
    // Fill the array up with random numbers 10 to 99 and do not allow duplicates.
    let mut binary_tree: [u32; ARRAY_SIZE] = create_binary_tree();

    // Test: create_binary_tree();
    println!("{:?}", binary_tree);

    // Display the unsorted binary tree on the screen.
    println!("Unsorted binary tree:");
    print_tree(&binary_tree);

    // User can hit continue with enter key.
    print!("Press Enter to start heap sort...");
    println!();
    wait_for_enter();

    // Run the process that sorts the array.
    heap_sort(&mut binary_tree); // Lend binary_tree to sort.
    let binary_tree = binary_tree; // We shadow and lock it down.

    // Test: build_max_heap (sort)
    println!("{:?}", binary_tree);

    // Take sorted tree and announce to user, then display all numbers in order on line.
    // Allow user to press a key to continue.
    print!("Press Enter to see the sorted tree...");
    println!(); 
    wait_for_enter();

    // Print out binary tree after sort. Smallest number should be at the root.
    print_tree(&binary_tree);
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
        while array_tree[0..i].contains(&random_int) {
            // Generate new one until there is no duplicate.
            random_int = rng.random_range(MIN_VALUE..MAX_VALUE + 1);
        }
        array_tree[i] = random_int; // we assign the new index 
    }
    array_tree // No semicolon = return value
}

/// Sorts the array while maintaining the binary heap/tree
fn heap_sort(tree: &mut [u32; ARRAY_SIZE]) {
    // First half
    build_max_heap(tree);
    // Reverse 30 ... 1 because i is the last unsorted spot each round.
    // Second half
    for i in (1..ARRAY_SIZE).rev() {
        tree.swap(0, i);
        // We move the biggest number to i the sorted end.
        heapify(tree, 0, i);
        println!("{:?}", tree);
    }
}

/// Helper function to move highest value to index 0,
/// Making every parent >= its children.
fn build_max_heap(tree: &mut [u32; ARRAY_SIZE]) {
    // We start at 1 because index 0 has no parent
    for i in 1..ARRAY_SIZE {
        let mut current = i;
        // We stop at the root 0 which has no parent
        while current != 0 {
            let parent = (current - 1) / 2;
            // Check parent and swap if greater than parent.
            if tree[current] > tree[parent] {
                tree.swap(current, parent);
                current = parent;
            } else {
                break;
            }
        }
    }
}

/// Moves the value at start down until every parent is greater than child.
/// Leaving the highest value at the root.
/// start: the dindex which needs go down the tree, the root.
/// end: the first index of the sorted section
fn heapify(tree: &mut [u32; ARRAY_SIZE], start: usize, end: usize) {
    let mut current = start;
    // Keep going while current node has left child
    while 2 * current + 1 < end {
        // left and right child index respectively
        let left = 2 * current + 1;
        let right = 2 * current + 2;

        // Pick the bigger child
        let mut bigger_child = left;
        if right < end && tree[right] > tree[left] {
            bigger_child = right;
        }
        if tree[bigger_child] > tree[current] {
            tree.swap(bigger_child, current);
            current = bigger_child;
        } else {
            break;
        }
    }
}

/// Pauses until the user presses Enter.
fn wait_for_enter() {
    io::stdout().flush().unwrap(); // make the prompt show before waiting
    let mut input = String::new();
    io::stdin().read_line(&mut input).unwrap();
}

/// Takes an array and depicts it as a binary tree in the console.
fn print_tree(any_array: &[u32; ARRAY_SIZE]) {
    let mut count = 1;

    for level in 0..TREE_LEVELS {
        let first = count - 1;
        let node_width = TREE_WIDTH / count;

        // Row 1: numbers
        for i in first..first + count {
            print!("{:^w$}", any_array[i], w = node_width);
        }
        println!();

        // Only draw connectors if there's a level below this one
        if level < TREE_LEVELS - 1 {
            // Row 2: pipes
            for _ in first..first + count {
                print!("{:^w$}", "|", w = node_width);
            }
            println!();

            // Row 3: dashes
            let dashes = "-".repeat(node_width / 2 + 1);
            for _ in first..first + count {
                print!("{:^w$}", dashes, w = node_width);
            }
            println!();
        }

        count *= 2;
    }
}