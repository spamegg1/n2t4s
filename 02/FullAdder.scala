import chisel3.*

class FullAdder extends Module:
  val a     = IO(Input(Bool()))
  val b     = IO(Input(Bool()))
  val c     = IO(Input(Bool()))
  val sum   = IO(Output(Bool()))
  val carry = IO(Output(Bool()))

  // implement here!
  // The simple solution uses 2 HalfAdders and 1 Or (total 13 Nand)
  // val ha1 = Module(HalfAdder())
  // val ha2 = Module(HalfAdder())
  // val or  = Module(Or())
  // ha1.a := a
  // ha1.b := b
  // ha2.a := c
  // ha2.b := ha1.sum
  // or.a  := ha1.carry
  // or.b  := ha2.carry
  // sum   := ha2.sum
  // carry := or.out

  // Here is the optimized version, total 9 Nand gates
  // The design is split into two halves 4 + 5 which are similar to Xor and HalfAdder
  // but with some differences that save on some chips.
  val nand1 = Module(Nand())
  val nand2 = Module(Nand())
  val nand3 = Module(Nand())
  val nand4 = Module(Nand())
  val nand5 = Module(Nand())
  val nand6 = Module(Nand())
  val nand7 = Module(Nand())
  val nand8 = Module(Nand())
  val nand9 = Module(Nand())

  nand1.a := a
  nand1.b := b
  nand2.a := a
  nand2.b := nand1.out
  nand3.a := nand1.out
  nand3.b := b
  nand4.a := nand2.out
  nand4.b := nand3.out
  nand5.a := nand4.out
  nand5.b := c
  nand6.a := nand4.out
  nand6.b := nand5.out
  nand7.a := nand5.out
  nand7.b := c
  nand8.a := nand6.out
  nand8.b := nand7.out
  nand9.a := nand5.out
  nand9.b := nand1.out
  sum     := nand8.out
  carry   := nand9.out
