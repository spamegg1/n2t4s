# Project 01

## Order

1. `Not`

    - using only `Nand`
    - optimal total Nand count: 1
    - from this point, `Not` can be used freely, since it's equivalent to a `Nand`

2. `And`

    - using only `Nand` and `Not`
    - optimal total Nand count: 2

3. `Or`

    - using only `Nand` and `Not`
    - optimal total Nand count: 3

4. `Xor`

    - there is a naive, inefficient way using `And`, `Or`, `Not`
    - optimal: using only `Nand`
    - optimal total Nand count: 4

5. `Mux`

    - there is a naive, inefficient way using `And`, `Or`, `Not`
    - optimal: using only `Nand` and `Not`
    - optimal total Nand count: 4

6. `DMux`

    - optimal: using only `And` (or `Nand`) and `Not`
    - optimal total Nand count: 5

7. `Not16`

    - Chisel does not support sub-bus assignment.
    - [expl](https://www.chisel-lang.org/docs/cookbooks/cookbook#how-do-i-do-subword-assignment-assign-to-some-bits-in-a-uint)
    - need to use an intermediate `Vec` in order to do sub-bus assignment.
    - optimal total Nand count: 16

8. `And16`

    - asd

9. `Or8Way`

    - asd

10. `Or16`

    - asd

11. `Mux4Way16`

    - asd

12. `Mux8Way16`

    - asd

13. `Mux16`

    - asd

14. `DMux4Way`

    - asd

15. `DMux8Way`

    - asd

16. `Zero`

    - asd
