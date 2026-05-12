import chisel3.*

// Implement without manually setting the Boolean value or using any Boolean operators.
// Use only existing chips (for now, `Nand` is the only one).

/** Not gate
  *
  * out = not in
  */
class Not extends Module:
  val in  = IO(Input(Bool()))
  val out = IO(Output(Bool()))

  // Implement below. You need to wrap any chips with `Module(...)`.
  val nand = Module(Nand())
  nand.a := in
  nand.b := in
  out    := nand.out
