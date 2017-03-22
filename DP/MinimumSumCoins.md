### Problem Statement
Given a list of N coins, their values (V1, V2, … , VN), and the total sum S. 
Find the minimum number of coins the sum of which is S (we can use as many coins of one type as we want), 
or report that it’s not possible to select coins in such a way that they sum up to S.

### Solution Approach
Dynamic Programming

### Complexity
O(N.S)
This is a pseudo polynomial complexity as the complexity depends on the Sum

### Explanation
What we do is calculate the minimum number of coins required to sum up to 0 to S, i.e. we store the value of these minimums for each sum value up to S. This way we can use the minimum count of a previous sum at a later stage to avoid calculating the same again.
For Min[0], the minimum is 0.
  Loop from 1 to S
    In the inner loop we go over each coins.
    If the value of coin is greater than sum then we discard that.
    Else we calculate 
      CoinsRequired = 1 + Min[Sum-CoinValue]
   
