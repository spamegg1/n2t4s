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

    - Similar to `Not16`.
    - optimal total Nand count: 32

9. `Or16`

    - Similar to `And16`.
    - optimal total Nand count: 48

10. `Mux16`

    - Similar to `And16`.
    - optimal total Nand count: 64

11. `Mux4Way16`

    - optimal total Nand count: 192

12. `Mux8Way16`

    - asd

13. `Or8Way`

    - asd

14. `DMux4Way`

    - asd

15. `DMux8Way`

    - asd

16. `Zero`

    - asd
