import chisel3.*

// Implement without manually setting the Boolean value or using any Boolean operators.
// Use existing chips instead (for now, `Nand` is the only one).

/** Not gate
  *
  * out = not in
  */
class Not extends Module:
  val in  = IO(Input(Bool()))
  val out = IO(Output(Bool()))

  // implement here! You need to wrap any chips with `Module(...)`.
  val nand = Module(Nand())
  nand.a := in
  nand.b := in
  out    := nand.out
