### Remove Nth Node From End of List

Given a linked list, remove the nth node from the end of list and return its head.

For example,

    Given linked list: 1->2->3->4->5, and n = 2.
    After removing the second node from the end, the linked list becomes 1->2->3->5.
    
*Note*:
Given n will always be valid.
Try to do this in one pass.

[LeetCode link](https://leetcode.com/problems/remove-nth-node-from-end-of-list/#/description)

### Explanation

We need to remove the nth node from the end of the linkedlist. From the input example given here 1->2->3->4->5, and n = 2,
to remove the element 4 (as it is the 2nd node from the linked list) we need to have access to the node 3

Remember for removing the node we can just point the next link of node 3 to the next link of node 4.
[[ Visuals ]]

To do this in one pass, what if we keep two runners. One runner can tell us if we have reached the end of the linked list
and the other runner can point to the node just before the node to be removed.
We can have a slow runner and a fast runner. The distance between slow runner and the fast runner should be equal to the
number n. Hence when fast runner reaches the end, slow runner is nth node from the fast runner, i.e (n+1)th from the end.

Once we have this, all we need to do is to point the next of the slow runner to it's next's next.


### Code
[Java implementation](https://github.com/hkasera/sturdy-spork/blob/master/linkedlist/code/RemoveNodes.java)

### Complexity

##### Time Complexity 
O(m), where m is the length of the linked list

##### Space Complexity 
O(1)
