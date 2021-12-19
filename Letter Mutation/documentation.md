# Letter Mutation Project

 
The objective of this project is to find a path between two words in a dictionary where a path between two words can only be formed if they have a one-letter discrepancy.

> Bat -> Cat -> Sat -> Set

## Table of Contents

- [The Idea](#the-idea)

- [Optimization](#optimization)

- [Pseudocode](#pseudocode)

- [Final Remarks](#final-remarks)

## The Idea

Let us denote `a` as our starting word and `b` as our ending one. With this in mind, there are a few observations we can make. 

- In general, our solution should involve traversing between words with one letter discrepancies.

- There is no need to check for words that are not the same length as `a` or `b`.

- We cannot avoid checking all possible mutations for a word. In other words, there is no greedy way to solve this problem. 

#### Using these observations, we can construct a basic solution for our problem

> Starting at word `a`, we can try out all the words that have one letter differences with `a`. Afterward, we can do the same for the neighbouring words until we have reached `b`.  It is good to note that we should never be visiting the same word twice—the reason for this will be explained later.

#### Data structures involved
```Java 
Queue<String> queue
```   
We will use a queue to store the current words that we have traveled to.
 ```Java 
 ArrayList<String> dictionary
 ``` 
 We will use an arraylist to store the list of the words.
 

```Java 
ArrayList<String> visited
``` 
We will use another arraylist to store the visited words.


#### Algorithm 
When we traverse from `a` to `b`, we want our search to resemble a breadth-first-search.

![A example of breadth-first-search](https://upload.wikimedia.org/wikipedia/commons/thumb/3/33/Breadth-first-tree.svg/1200px-Breadth-first-tree.svg.png)

In the diagram above, imagine if the nodes connected had one letter discrepancies. Because the nodes are numbered according to level, we would travel through the words level by level, so that when we reach our destination, we will know that we have found the shortest path. This is because, at any given moment in our program, the current word we are on will also be part of the deepest level we have travelled. Thus, as mentioned previously, there is no need to be encountering the same word twice. 

#### Estimated Time Complexity
- To check for the neighbours of a single word, we must iterate through the arraylist and compare strings. This is `O(nm)` where `n` is the length of the dictionary and `m` is the length of the string.

- For each word, we will need to check whether or not it has been previously traversed. This adds an extra 

- At worst case, our breadth-first-search will run through the entire dictionary. This means we will need to check the neighbours of `n` words where n is the length of the dictionary.

**Overall, this gives us a time complexity of** `O(n^3m)`

## Optimization
In order to make our program more efficient, we need to identify some of the biggest issues in our current idea.

1. We do not want to be iterating through the entire dictionary for each separate word.

2. There should be a better way to check whether or not a word has been visited 








