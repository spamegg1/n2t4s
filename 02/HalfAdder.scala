import chisel3.*

/** Computes the sum of two bits.
  *
  * in: a, b
  *
  * out: carry, sum
  *
  * carry = most significant bit of a + b
  *
  * sum = least significant bit of a + b
  *
  * a | b | carry | sum
  *
  * 0 | 0 | 0 | 0
  *
  * 0 | 1 | 0 | 1
  *
  * 1 | 0 | 0 | 1
  *
  * 1 | 1 | 1 | 0
  */
class HalfAdder extends Module:
  val a     = IO(Input(Bool()))
  val b     = IO(Input(Bool()))
  val sum   = IO(Output(Bool()))
  val carry = IO(Output(Bool()))

  // implement here!
  // this is the simple solution, using 2 + 4 = 6 Nand gates total.
  // val and = Module(And())
  // val xor = Module(Xor())
  // and.a := a
  // and.b := b
  // carry := and.out
  // xor.a := a
  // xor.b := b
  // sum   := xor.out

  // Here is the optimized version, 5 Nand gates total.
  // It uses the Nand layout of Xor, then adds a Not gate to obtain And.
  val nand1 = Module(Nand())
  val nand2 = Module(Nand())
  val nand3 = Module(Nand())
  val nand4 = Module(Nand())
  val not   = Module(Not())
  nand1.a := a
  nand1.b := b
  nand2.a := a
  nand2.b := nand1.out
  nand3.a := nand1.out
  nand3.b := b
  nand4.a := nand2.out
  nand4.b := nand3.out
  not.in  := nand1.out
  sum     := nand4.out
  carry   := not.out
