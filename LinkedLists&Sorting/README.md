# Linked Lists & Sorting

A Java program that arranges a list of words into separate lists of anagrams. The input is a text file that contains a list of words, 
each word on its own line. The number of words in the input is arbitrary and could be very large.


The program should print to an output file the lists of anagrams in the following way:


All the words that are anagrams of each other are displayed together on a single line; any word without any corresponding anagrams is displayed alone on a line.

The words on each line should be in alphabetic order.

Lines of words are sorted into ascending alphabetic order according to the first word of a line.

Words in a line should be separated by a single space.


For example, this input:

```
car

dog

bed

stop

god

pots

arc

tops
```

should yield the output:

```
arc car

bed

dog god

pots stop tops
```

You must use linked lists to deal with the arbitrary number of anagrams in a line, and use an array of references to keep track of all the linked lists.

## 
