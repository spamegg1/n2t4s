import chisel3.*

/** Not gate
  *
  * out = not in
  */
class Not extends Module:
  val in  = IO(Input(Bool()))
  val out = IO(Output(Bool()))

  // Implement below. You need to wrap any chips with `Module(...)`.
  // Implement without manually setting the Boolean value or using any Boolean operators.
  // Use only existing chips (for now, `Nand` is the only one).
  val nand = Module(Nand())
  nand.a := in
  nand.b := in
  out    := nand.out
