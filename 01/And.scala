import chisel3.*

// Implement without manually setting the Boolean value or using any Boolean operators.
// Use existing chips instead (for now, `Nand` and `Not` are the only ones).

/** And gate
  *
  * in: a, b
  *
  * out = true if a and b are both true, false otherwise.
  */
class And extends Module:
  val a   = IO(Input(Bool()))
  val b   = IO(Input(Bool()))
  val out = IO(Output(Bool()))

  // implement here! You need to wrap any chips with `Module(...)`.
  val nand = Module(Nand())
  val not  = Module(Not())
  nand.a := a
  nand.b := b
  not.in := nand.out
  out    := not.out
