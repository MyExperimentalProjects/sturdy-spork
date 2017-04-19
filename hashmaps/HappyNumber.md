## Happy Number

Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

[LeetCode link](https://leetcode.com/problems/happy-number/#/description)

### Input Examples

__Example 1__

Input : 19
Output : True

#### Reason

  1<sup>2</sup> + 9<sup>2</sup> = 82
  
  8<sup>2</sup> + 2<sup>2</sup> = 68
  
  6<sup>2</sup> + 8<sup>2</sup> = 100
  
  1<sup>2</sup> + 0<sup>2</sup> + 0<sup>2</sup> = 1
  

__Example 2__

Input : 16
Output : False

#### Reason

  1<sup>2</sup> + 6<sup>2</sup> = 37
  
  3<sup>2</sup> + 7<sup>2</sup> = 58
  
  5<sup>2</sup> + 8<sup>2</sup> = 89
  
  8<sup>2</sup> + 9<sup>2</sup> = 145
  
  1<sup>2</sup> + 4<sup>2</sup> + 5<sup>2</sup> = 42
  
  4<sup>2</sup> + 2<sup>2</sup> = 20
  
  2<sup>2</sup> + 0<sup>2</sup> = 4
  
  4<sup>2</sup> = 16 [We got 16 again]
  
  ....
  

### Logic

Calculating the sum of squares of digits of a number is straight forward. The challenge is to know when to stop. From the above two examples, we can see there are two stop conditions -
- If the sum of squares of digits become 1
- If the sum is repeated then we know it is going to continue in an infinite loop, so we can break the loop.

Implementing this logic in code can easily be done.


### Java Implementation

[Code in Java](./code/HappyNumber.java)
