import chisel3.*

/** 8-way 16-bit multiplexor:
  *
  * out =
  *
  * a if sel == 000
  *
  * b if sel == 001
  *
  * etc.
  *
  * h if sel == 111
  */
class Mux8Way16 extends Module:
  val a   = IO(Input(Bits(16.W)))
  val b   = IO(Input(Bits(16.W)))
  val c   = IO(Input(Bits(16.W)))
  val d   = IO(Input(Bits(16.W)))
  val e   = IO(Input(Bits(16.W)))
  val f   = IO(Input(Bits(16.W)))
  val g   = IO(Input(Bits(16.W)))
  val h   = IO(Input(Bits(16.W)))
  val sel = IO(Input(Bits(3.W)))
  val out = IO(Output(Bits(16.W)))

  // implement here! Optimal nand count is 448
  val mux1 = Module(Mux4Way16())
  val mux2 = Module(Mux4Way16())
  val mux3 = Module(Mux16())

  mux1.a   := a
  mux1.b   := b
  mux1.c   := c
  mux1.d   := d
  mux1.sel := sel(1, 0)
  mux2.a   := e
  mux2.b   := f
  mux2.c   := g
  mux2.d   := h
  mux2.sel := sel(1, 0)
  mux3.a   := mux1.out
  mux3.b   := mux2.out
  mux3.sel := sel(2)
  out      := mux3.out
