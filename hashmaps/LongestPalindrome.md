## Longest Palindrome
Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

[Leetcode Link](https://leetcode.com/problems/longest-palindrome/#/description)

    Input: "abccccdd"

    Output: 7

    Explanation:
    One longest palindrome that can be built is "dccaccd", whose length is 7.
    
### Logic

What is a palindrome string?
    According to wikipedia, a palindrome string is a sequence of characters which reads the same backward as forward. 

The simplest palindrome could be a single character. 
As we increment the length of the string we can note that,
- Fact 1 - An even length palindrome would have all characters with even number of occurences. For example *acca* or *abccba*.
- Fact 2 - An odd length palindrome would have a single character with odd number of occurences. For example *acdca* or *abcccba*.

Take any palindrome string and you will find the above is true for all.

Now this fact is the key to solving our problem. Think about how can we use this?

#### Approach 1 -

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


#### Approach 2 -

In Approach 1, we are actually storing the counts of each letter and then using them to find the desired result. However, if
we notice, we only need to add all the even counts and add 1 if any character has an odd occurence. 
I see, HashSets as very useful in this. According to the [documentation](https://docs.oracle.com/javase/7/docs/api/java/util/HashSet.html), HashSet has a method [*add*](https://docs.oracle.com/javase/7/docs/api/java/util/HashSet.html#add(E)), which returns true if the set did not already contain the specified element. So, the pseudo code would be -

    evenCharCount = 0
    for each character in input string
        add the character to hashset
        if the add method returns false -> character exists in set -> even count
            increment evenCharCount by 1
            Remove the element from set
    if hashset is not empty -> character with odd occurence exists
        return 2*evenCharCount + 1
    else
        return 2*evenCharCount
      
   

#### Java Implementation
[Code Link](./code/LongestPalindrome.java)


#### Fun Fact

**Aibohphobia** is an irrational fear of palindromes. Spell it backwards!! [Link](http://waldentv.com/wp-content/uploads/2015/12/Palindromes_FunFactSheet_FINAL_2.pdf)
