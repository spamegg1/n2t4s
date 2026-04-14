import chisel3.*

// Implement without manually setting the Boolean value or using any Boolean operators.
// Use existing chips instead (for now, `Nand` and `Not` are the only ones).

/** Xor gate
  *
  * in: a, b
  *
  * out = true if a and b are different, false otherwise.
  */
class Xor extends Module:
  val a   = IO(Input(Bool()))
  val b   = IO(Input(Bool()))
  val out = IO(Output(Bool()))

  // implement here! You need to wrap any chips with `Module(...)`.

  val notA = Module(Not())
  notA.in := a

  val notB = Module(Not())
  notB.in := b

  val nand1 = Module(Nand())
  nand1.a := notA.out
  nand1.b := b

  val nand2 = Module(Nand())
  nand2.a := a
  nand2.b := notB.out

  val nand3 = Module(Nand())
  nand3.a := nand1.out
  nand3.b := nand2.out

  out := nand3.out
