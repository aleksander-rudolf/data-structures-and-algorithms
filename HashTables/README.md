# Hash Tables

Read in a set of words from the input file one at a time, in a loop.

Use your hash function to calculate the table address for the word, and then insert it into the table. Use open addressing and linear probing to resolve any collisions.

Once all the words have been inserted into the hash table, reread the input file, using each word as a search item, and search for the word in the table; you will use
the same hash function and linear probing technique as above. As you do the search, keep track of the total number of reads you make as you search through the table,
as well as the longest chain of reads you make as you search for a word. Calculate and print out to the output file the average number of reads per record, the load
factor, the hashing efficiency, and the size of the longest chain when searching.

## 
