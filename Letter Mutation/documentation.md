
# Letter Mutation Project

 
The objective of this project is to find a path between two words in a dictionary where a path between two words can only be formed if they have a one-letter discrepancy.

> BAT -> SAT -> SET

## Table of Contents

- [The Idea](#the-idea)

- [Optimization](#optimization)

- [Pseudocode](#pseudocode)

- [Testing](#testing)

- [Final Remarks](#final-remarks)

## The Idea

Let us denote `a` as our starting word and `b` as our ending one. With this in mind, there are a few observations we can make. 

- In general, our solution should involve traversing between words with one letter discrepancies.

- There is no need to check for words that are not the same length as `a` or `b`.

- We cannot avoid checking all possible mutations for a word. In other words, there is no greedy way to solve this problem. 

**Using these observations, we can construct a basic solution for our problem**

> Starting at word `a`, we can try out all the words that have one letter differences with `a`. Afterward, we can do the same for the neighbouring words until we have reached `b`.  It is good to note that we should never be visiting the same word twice—the reason for this will be explained later.

### Algorithm 
When we traverse from `a` to `b`, we want our search to resemble a breadth-first-search.

![A example of breadth-first-search](https://upload.wikimedia.org/wikipedia/commons/thumb/3/33/Breadth-first-tree.svg/1200px-Breadth-first-tree.svg.png)

In the diagram above, imagine if the nodes connected had one letter discrepancies. Because the nodes are numbered according to level, we would travel through the words level by level, so that when we reach our destination, we will know that we have found the shortest path. This is because, at any given moment in our program, the current word we are on will also be part of the deepest level we have travelled. Thus, as mentioned previously, there is no need to be encountering the same word twice. 

### Data structures involved
```Java 
Queue<String> queue
```  
We will use a Queue to store a dynamic list of neighbours that we yet to search Because the the Queue data structure is first-in-first-out, it is perfect for breadth-first-search.
```Java 
 ArrayList<String> dictionary
``` 
 We will use an ArrayList to store the list of the words.
```Java 
ArrayList<String> visited
``` 
We will use another ArrayList to store the visited words.

### Estimated Time Complexity
- To check for the neighbours of a single word, we must iterate through the arraylist and compare strings. This is `O(nm)` where `n` is the length of the dictionary and `m` is the length of the string.

- For each word, we will need to check whether or not it has been previously traversed. This adds an extra `O(n)` search per word. 

- At worst case, our breadth-first-search will run through the entire dictionary. This means we will need to check the neighbours of `n` words.

**Overall, this gives us a time complexity of `O(2n^2m)` or  `O(n^2m)`**

## Optimization
In order to make our program more efficient, we need to identify some of the biggest issues in our current algorithm.

> 1. We do not want to be iterating through the entire dictionary for each separate word.
> 
>2. There should be a better way to check whether or not a word has been visited.
>
>3. We have not yet addressed how to recover the path.

To solve the first problem, we can use an alphabetically inspired exhaustive search + a HashSet, reducing our complexity to `O(26nm)`. The idea is that for each word, instead of comparing it to the rest of the dictionary, we can create all possible versions of that word and check for its existence. There are 26 letters in the English alphabet and each word is some `m` length, therefore in the worst-case scenario, if we were to visit all words, it would only take us `O(26nm)`. 

Unfortunately, because we are constructing a new string object for every mutation, there is an extra `O(m)` operation. The time complexity now becomes `O(26nm^2)`.

The second problem is much easier to deal with. Instead of using an arraylist to store all the words that have been visited, we can convert our previous HashSet into a HashMap. This allows us to relate a value to each word, and that value can represent visitation or lack thereof. 

```Java
HashMap<String, String> dictionary
```
The third problem is conveniently solved by our HashMap optimization. Instead of storing a boolean as a value, we can store the word that the key had been traversed from. This idea does not only help us backtrack for the path but also provides an indicator for whether or not the word has been visited.

Example-

> <SELL, WELL> where SELL is a word and WELL is the previous word 

*Note: The Java HashMap can access by key in `O(1)`*

**Ultimately, our time complexity becomes `O(26nm^2)` or `O(nm^2)` per a two-word query**

## Pseudocode
Assuming that we already have a HashMap that contains the dictionary: 

1. Before executing our breadth-first-search algorithm, we need to add our starting word to the queue and mark it as visited.

2. To maintain our BFS algorithm, we will always perform our exhaustive search on the first word within our queue. The search will involve replacing each character in a word with all the letters of the English Alphabet. Examples of this are shown below-
	> STAR -> ATAR -> BTAR -> CTAR | Replacing the first letter of STAR
	
	> CAR -> CBR -> CCR -> CDR | Replacing the second letter of CAR

3. For every mutation that exists in our dictionary, we will check whether or not if that word has been visited. If it has not, it will be added to the queue and presumably be searched at a later time. 

4. If we are ever to run into the final word, we can end our BFS. As mentioned previously, BFS will traverse level by level, thus making any current node also the shortest path from the start. 

5. Using our HashMap, we can backtrack from the final word and construct our path. This can be done iteratively with a Stack. 

## Testing

**I used this [online dictionary](http://www.mieliestronk.com/corncob_lowercase.txt) to perform some basic testing on the program.**

| Start | End | Output |
| :-: | :-: | :-:|
|CORAL | FLAME | CORAL -> MORAL -> MORAY -> FORAY -> FORTY -> FORTS -> SORTS -> SOOTS -> SLOTS -> SLATS -> SLATE -> SLAKE -> FLAKE -> FLAME : **Length 14**
|TRIBE| SOLVE | TRIBE -> TRICE -> PRICE -> PRISE -> POISE -> POSSE -> PASSE -> PARSE -> PURSE -> CURSE -> CURVE -> CARVE -> CALVE -> SALVE -> SOLVE : **Length 15**
| WALK | DOGS | WALK -> TALK -> TANK -> TANS -> TONS -> DONS -> DOGS : **Length 7**
|CAT | DOG | CAT -> COT -> DOT -> DOG : **Length 4**

**More in depth test cases using [this dictionary](https://github.com/peterjinweigu/School-Projects/blob/main/Letter%20Mutation/DemoDict.txt).**

*Example 1*

> ABCD -> DADD

> OUTPUT : ABCD -> AACD -> AADD -> DADD

With the graph below we can see that our program has indeed chosen the shortest path

![Graph for example 1](https://i.ibb.co/nr4vhvZ/Graph.png)

*Example 2*
> A -> Z

> OUTPUT : NO SUCH MUTATION EXISTS

There is no `Z` in this dictionary.

*Example 3*
> ABCDEFG -> AAAAAAA

> OUTPUT : ABCDEFG -> AACDEFG -> AAADEFG -> AAAAEFG -> AAAABFG -> AAAABAG -> AAAABAA -> AAAAAAA

This is the correct output.

# Final Remarks

1. BFS vs DFS: Another approach towards this problem is depth-first-search. DFS essentially will traverse a graph by its branches, exploring as deep as possible before backtracking. However, unlike BFS, at some node during DFS, you will be unable to tell whether or not you have the shortest distance. This makes it extremely unfavourable to use the DFS algorithm for this problem. 

2. Graph Construction Approach: Interestingly, there exists a method to solve this problem that disposes of the constant factor `26`. If you were to build a graph that consists of nodes that represent a parent permutation (ie. `L_KE` encompasses words like `LAKE` or `LIKE`) with edges to those words, there would be no need to iterate through the alphabet. However, with this, comes to an additional `O(nm)` memory requirement as well as graph construction. I think that my method is more preferable as it shares the same big O time complexity, and does not use as much memory. 
