import chisel3.*

// Implement without manually setting the Boolean value or using any Boolean operators.
// Use existing chips instead (for now, `Nand` and `Not` are the only ones).

/** Mux gate
  *
  * in: a, b, sel
  *
  * out: out
  *
  * out = a if sel == 0, b if sel == 1
  */
class Mux1 extends Module:
  val a   = IO(Input(Bool()))
  val b   = IO(Input(Bool()))
  val sel = IO(Input(Bool()))
  val out = IO(Output(Bool()))

  // implement here! You need to wrap any chips with `Module(...)`.
  // Most optimal version uses a total of 4 Nand gates.
  val nand1 = Module(Nand())
  val nand2 = Module(Nand())
  val nand3 = Module(Nand())
  val not   = Module(Not())

  not.in  := sel
  nand1.a := not.out
  nand1.b := a
  nand2.a := sel
  nand2.b := b
  nand3.a := nand1.out
  nand3.b := nand2.out
  out     := nand3.out
