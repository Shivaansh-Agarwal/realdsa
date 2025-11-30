## BASIC QUESTIONS
1. insert in a bst - recursive & iterative.
2. search in a bst - recursive & iterative.
3. deletion in a bst.
4. is the bst a balanced bst?

### INSERTION
-> given a key, insert it into the bst, create bst if not already created, if the key is already present don't do anything, else insert on the leaf node.
1. We begin with a search, if the key is already present, we don't do anything, if key is NOT present, we insert the element on the leaf. We always end up with a null if the key is not present.
2. Insertions always happen at the leaf.
3. root is changed only in 1 case, if the tree is empty.

### SEARCH
-> given the root of a bst, and a key return true if the key is present or return false if the key is not present.

### DELETION
-> given a key, delete the key if present in the bst and return true, else return false.

