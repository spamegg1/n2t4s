# Project 03

## DFF implementation

The book abstracts away the data flip-flop, so we need to implement it.

Normally a data flip-flop is made of a data latch (D Latch) + Mux + Nand.
A D latch is made of a set/reset latch (SR Latch).
An SR Latch is made out of two Nand gates that are connected to each other in a loop.

However, Chisel does not allow cyclical connections.
It will give an error like "cycle detected in FIRRTL".
It also does not give access to lower-level switches, transistors, etc.

We get around this by "cheating" and using a `RegNext`.
This register starts with no initial value, and is updated on the next cycle.
This fits perfectly with what is described in the book:
DFF has undefined output on the very first cycle.

## Order

1. `Bit`
2. `Register`
3. `RAM8`
4. `RAM64`
5. `RAM512`
6. `RAM4K`
7. `RAM16K`
8. `PC`
