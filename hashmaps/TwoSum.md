### Two Sum

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

Note - You may assume that each input would have exactly one solution, and you may not use the same element twice.

Examples - 
     
     Given nums = [2, 7, 11, 15], target = 9,
     As 2 + 7 = 9, => nums[0] + nums[1] = 9
     return [0, 1].
     
     Given nums = [-3, 7, 11, -5], target = -8,
     As -3 + (-5) = -8, => nums[0] + nums[3] = -8
     return [0, 3].
     
     Given nums = [3, 3], target = 6,
     As 3 + 3 = 6, => nums[0] + nums[1] = 6
     return [0, 1].
    

#### Approach :

1. We can iterate over array and for each element, we find if the difference from target exists in array. This will take
two loops to the array. So, time complexity O(n<sup>2</sup>). 
     
2. Using hashmaps.
Step 1 - We can store the numbers and their indices in hashmap as key value pair. So, let's take example input 1 and solve this -

    Given nums = [2, 7, 11, 15]
    HashMap will be -
      (2,0)
      (7,1)
      (11,2)
      (15,3)
 
Step 2 - Now, we iterate over array and at each iteration we check if the difference of target and that element exists in hashmap,
 then we got the solution.
 
 So, for the above example -
      
      Iteration 0
      -----------
      arr[0] = 2
      diff = target - arr[0] = 9 - 2 = 7
      7 exists in hashmap, hence solution
      
Now, lets solve this with other two examples, as each of them represent a distinctive test case -

     Given nums = [-3, 7, 11, -5], target = -8
     HashMap will be -
      (-3,0)
      (7,1)
      (11,2)
      (-5,3)
      
      Iteration 0
      -----------
      arr[0] = -3
      diff = target - arr[0] = -8 - (-3) = -5
      -5 exists in hashmap, hence solution found
      
      
There is one slight improvement in this approach in which we can perform Step 1 and Step 2 together.
During construction of hashmap perform Step 2 together. Let's see how -

     Given nums = [-3, 7, 11, -5], target = -8
     Step 1 & 2 - HashMap Contruction
     
     Iteration 0
     -----------
     arr[0] = -3
     diff = target - arr[0] = -8 - (-3) = -5
     -5 exists in hashmap?
        No => Add -3 to hashMap
     Iteration 1
     -----------
     arr[0] = 7
     diff = target - arr[0] = -8 - (7) = -15
     -15 exists in hashmap?
        No => Add 7 to hashMap
    Iteration 2
     -----------
     arr[0] = 11
     diff = target - arr[0] = -8 - (11) = -19
     -19 exists in hashmap?
        No => Add 11 to hashMap
     Iteration 3
     -----------
     arr[0] = -5
     diff = target - arr[0] = -8 - (-5) = -3
     -3 exists in hashmap?
        Yes => Found solution
        
Time Complexity - O(n)
Space Complexity - O(n)


#### Java Implementation

[Code](code/TwoSum.java)
     
