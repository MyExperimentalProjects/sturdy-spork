## Merge Two Sorted Lists

Merge two sorted linked lists and return it as a new list. 
The new list should be made by splicing together the nodes of the first two lists.

[LeetCode link](https://leetcode.com/problems/merge-two-sorted-lists/description/)

__Input__

List 1 : 2 -> 4

List 2 : 1 -> 3 -> 5

__Output__

Merged List : 1 -> 2 -> 3 -> 4 -> 5

## Understanding the problem

If we were to do this process manually, think about how we would do it? We know that List 1 and List 2 are sorted. To make a merged list which is sorted, we can pick one by one the top elements of the list and place it in the merged list in the order.


List 1 : 2 -> 4

List 2 : 1 -> 3 -> 5

The process will be like -

Step 1. Element at first pos in List1 : 2
Step 2. Element at first pos in List2 : 1
Step 3. Compare above : 1 < 2 => Put 1 in the merged list and remove from List 2

List 1 : 2 -> 4

List 2 : 3 -> 5

Merged List : 1

Repeat Step 1 to Step 3 again -

Step 1. Element at first pos in List1 : 2
Step 2. Element at first pos in List2 : 3
Step 3. Compare above : 2 < 3 => Put 2 in the merged list and remove from List 1

List 1 : 4

List 2 : 3 -> 5

Merged List : 1 -> 2

If we repeat the above process until both lists are empty, we will get our merged list. 


### Pseudo Code

      MERGE (ListNode l1, ListNode l2):
        //Handle edge cases like l1 is null, l2 is null or both are null.
        Initialize mergedList as empty linked list to store merged list.
        Assign runners for l1 and l2 say runner1 and runner2
        Iterate while runner1 or runner2 is not null
            Add Min (val of runner1, val of runner2) to mergedList 
            Move runner1 and runner2 to next.
