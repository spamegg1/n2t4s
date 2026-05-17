import chisel3.*

// Implement without manually setting the Boolean value or using any Boolean operators.
// Use existing chips instead (for now, `Nand`, `And`, `Not` are the only ones).

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

  // Here is a version uses a total of 5 Nand gates.
  // val and1 = Module(And()) // 2 Nand
  // val and2 = Module(And()) // 2 Nand
  // val not  = Module(Not()) // 1 Nand
  // not.in := sel
  // and1.a := not.out
  // and1.b := in
  // and2.a := sel
  // and2.b := in
  // a      := and1.out
  // b      := and2.out

  // Optimal version with total 4 Nand gates:
  val nand1 = Module(Nand())
  val nand2 = Module(Nand())
  val not1  = Module(Not())
  val not2  = Module(Not())

  nand1.a := sel
  nand1.b := in
  nand2.a := nand1.out
  nand2.b := in
  not1.in := nand1.out
  not2.in := nand2.out
  a       := not2.out
  b       := not1.out
