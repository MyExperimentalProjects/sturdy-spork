## Longest Palindrome
Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

[Leetcode Link](https://leetcode.com/problems/longest-palindrome/#/description)

    Input: "abccccdd"

    Output: 7

    Explanation:
    One longest palindrome that can be built is "dccaccd", whose length is 7.
    
#### Logic
Think about any given palindrome string. A palindrome string always has -
- Fact 1 : atmost one letter with odd number of count.
- Fact 2 : if the above letter is present, all except that letter will have even number of counts.

For example take strings "ccacc" and "cbbc". Both the strings are palindrome and satisfy the above constraints. Take any and you will find the same.

Now this fact is the key to solving our problem. Think about how can we use this?

What if, we can found all the occurences of each letters in a given string. So for our input example "abccccdd", we can form something like -

    a - 1
    b - 1
    c - 4
    d - 2
    
Now, using these counts and the fact 2, we know that letters with even occurences can be added to form a palindrome string. So letter c and letter d will contribute to the length of the palindrome string. Now, we are left with a and b, with 1 occurence each. Using fact 1, we know only 1 of this can contribute to the palindrome string. Hence, length of the longest palindrome will be - (4 + 2 + 1). Hence 7

Take another example,

Input - "aaabbccde"

Let's calculate for this -
  
    a - 3
    b - 2
    c - 2
    d - 1
    e - 1

- Using fact 2, letter b and letter c will contribute to the length of the palindrome string. length = 2+2 = 4
- Using fact 2, 2 occurence of letter a will contribute to the length of the palindrome string. length = 4+2 = 6
- Now we are left with a,d,e each with 1 count. Using fact 1, we can add 1 of these. length = 6+1 = 7
    

#### Java Implementation
[Code Link](./code/LongestPalindrome.java)
