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
