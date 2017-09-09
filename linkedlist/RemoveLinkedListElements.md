### Question - Remove Linked List Elements

Remove all elements from a linked list of integers that have value val.

    Input
    1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6

    Output
    1 --> 2 --> 3 --> 4 --> 5

[LeetCode Link](https://leetcode.com/problems/remove-linked-list-elements/description/)


### Understanding the problem
The problem seems pretty self explanatory. All we need to do is to find the node(s) with the given value in the linked list and remove that node(s). 

Note - There can be single or multiple nodes with the given value, since the question doesn't specify so. It might be a good idea to check with the interviewer.

We can break down this question into two parts -
1. Find node(s) with a given value in the linkedlist.
2. Delete node(s) in the linkedlist.

To find a node in a linkedlist, all we need is a runner node iterating through the linkedlist and checking at each iteration,
if the value of the current node is equal to the given input value.

To delete a node in a linkedlist is little tricky as we need to handle the head node case differently. For any other node we need to have two pointers. One node pointing to the node to be deleted and one node pointing to the prev node. For deletion we simply point the next of the prev node to the next of the node to be deleted. 
For example to delete the node with value 6 in the below example -

1 --> 2 --> 6 --> 3

We need to point next of the prev node, ie. node with val 2 to next i.e node with val 3 of the node to be deleted.

1 --> 2 --> 3


