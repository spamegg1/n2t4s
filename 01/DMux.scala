import chisel3.*

// Implement without manually setting the Boolean value or using any Boolean operators.
// Use existing chips instead (for now, `Nand` and `Not` are the only ones).

/** DMux gate
  *
  * in: in, sel
  *
  * out: a, b
  *
  * {a, b} = {in, 0} if sel == 0
  *
  * {a, b} = {0, in} if sel == 1
  */
class DMux extends Module:
  val in  = IO(Input(Bool()))
  val sel = IO(Input(Bool()))
  val a   = IO(Output(Bool()))
  val b   = IO(Output(Bool()))

  // implement here! You need to wrap any chips with `Module(...)`.
  // Most optimal version uses a total of 5 Nand gates.
  val and1 = Module(And())
  val and2 = Module(And())
  val not  = Module(Not())

  not.in := sel
  and1.a := not.out
  and1.b := in
  and2.a := sel
  and2.b := in
  a      := and1.out
  b      := and2.out
