# Project 02

## Order

1. `HalfAdder`

    - There is a simple way, using `Xor` and `And` (total 6 Nand gates)
    - optimal total Nand count: 5

2. `FullAdder`

    - There is a simple way, using `HalfAdder` and `Or` (total 13 Nand gates)
    - optimal total Nand count: 9

3. `Add16`

    - using `HalfAdder` and `FullAdder`
    - optimal total Nand count: 140

4. `Inc16`

    > Although the operation can be realized by our general-purpose
    > Adder chip, a dedicated incrementer chip can do it more efficiently.
    - There is a simple way using `Add16` (total Nand count 140)
    - optimal total Nand count: 80

5. `ALU`

    - total Nand count: 723
    - optimal total Nand count: ???
