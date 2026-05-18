# Project 01

## Simpler vs. "optimized"

We might consider a chip more "optimized" if it uses fewer chips.
But what if a chip uses one big complicated chip, and another uses 5 simpler chips?

So we could adjust the meaning of "optimized" to mean the minimum Nand gates in total.
The total being the sum of the Nand counts of all the chips used in a design.
For example if chip X is made out of two chips Y and Z,
which use 5 and 3 Nand gates total, then X would use a total of 8 Nand gates.

The book says:

> Each gate can be implemented in more than one way. The simpler the
> implementation, the better. As a general rule,
> strive to use as few chip parts as possible.

The book is asking us to minimize chip count.
We might misinterpret this as minimizing the total Nand gate count.
What does "simpler" mean? We might misinterpret this as using lower level gates,
because higher level composite gates might be considered "more complex". But:

> Although each chip can be implemented directly from Nand gates only,
> we recommend always using composite gates that were already
> implemented. See the previous tip.

So the book is not asking us to minimize the total Nand gate count
or use lower level gates.
Rather it is asking us to use the higher level, composite gates,
even if there is another design that might use fewer Nand gates in total,
but leads to a more complex design.
By "simpler" the book means higher-level, composite gates,
with fewer chips in total (not fewer Nand gates in total).

So we have two measures:

- the simplest: lowest number of gates,
- optimal: minimum number of Nand gates in total.

I'll try to show both ways: the simple high-level way,
and the more complex way that minimizes total Nand count.
However, as chips get bigger and more complicated, this starts to get impractical.

## Order

1. `Not`

    - using only `Nand`
    - optimal total Nand count: 1

2. `And`

    - using only `Nand` and `Not`
    - optimal total Nand count: 2

3. `Or`

    - there is a simple way using `And` and `Not`, using 5 Nand total
    - optimal using only `Nand` and `Not`
    - optimal total Nand count: 3

4. `Xor`

    - there is a simple way using `And`, `Or`, `Not` (total 9 Nand)
    - optimal: using only `Nand`
    - optimal total Nand count: 4

5. `Mux`

    - there is a simple way using `And`, `Or`, `Not` (8 Nand)
    - optimal: using only `Nand` and `Not`
    - optimal total Nand count: 4

6. `DMux`

    - Similarly, there is a simple way using `And`, `Or`, `Not`
    - Another way using `And` and `Not` (5 Nand)
    - optimal total Nand count: 4

7. `Not16`

    - Chisel does not support sub-bus assignment.
    - [expl](https://www.chisel-lang.org/docs/cookbooks/cookbook#how-do-i-do-subword-assignment-assign-to-some-bits-in-a-uint)
    - need to use an intermediate `Vec` in order to do sub-bus assignment.
    - optimal total Nand count: 16

8. `And16`

    - Similar to `Not16`.
    - optimal total Nand count: 32

9. `Or16`

    - Similar to `And16`.
    - optimal total Nand count: 48

10. `Mux16`

    - Similar to `And16`.
    - optimal total Nand count: 64

11. `Or8Way`

    - optimal total Nand count: 21

12. `Mux4Way16`

    - total Nand count for the simplest solution: 192
    - optimal Nand count = ???

13. `Mux8Way16`

    - total Nand count for the simplest solution: 448
    - optimal Nand count = ???

14. `DMux4Way`

    - there is a simple way using only `DMux`, total 12 Nand gates
    - optimal total Nand count: 12

15. `DMux8Way`

    - There is a simple way using only `DMux`, total 28 Nand
    - The simplest way using `DMux4Way` and `DMux`, with total 28 Nand
    - optimal total Nand count: 28
