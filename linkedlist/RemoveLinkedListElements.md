### Question - Remove Linked List Elements

Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5

[LeetCode Link](https://leetcode.com/problems/remove-linked-list-elements/description/)


### Understanding the problem
The problem seems pretty self explanatory and all we need to do is to find the val and remove that node. 

To delete a node in a linkedlist we need to point the next of the prev node to the next of the node to be deleted. 
For example to delete the node with value 6 in the below example -

1 --> 2 --> 6 --> 3

We need to point next of the prev node, ie. node with val 2 to next i.e node with val 3 of the node to be deleted.

1 --> 2 --> 3

I guess the tricky part here is to handle the different cases when -
- the node is at the beginning
- the node is at the end

