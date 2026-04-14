import chisel3.*

// Implement without manually setting the Boolean value or using any Boolean operators.
// Use existing chips instead (for now, `Nand` and `Not` are the only ones).

/** Or gate
  *
  * in: a, b
  *
  * out = false if a and b are both false, true otherwise.
  */
class Or extends Module:
  val a   = IO(Input(Bool()))
  val b   = IO(Input(Bool()))
  val out = IO(Output(Bool()))

  // implement here! You need to wrap any chips with `Module(...)`.
  val nand = Module(Nand())
  val notA = Module(Not())
  val notB = Module(Not())
  notA.in := a
  notB.in := b
  nand.a  := notA.out
  nand.b  := notB.out
  out     := nand.out
