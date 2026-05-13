import chisel3.*

/** 4-way 16-bit multiplexor:
  *
  * out =
  *
  * a if sel == 00
  *
  * b if sel == 01
  *
  * c if sel == 10
  *
  * d if sel == 11
  */
class Mux4Way16 extends Module:
  val a   = IO(Input(Bits(16.W)))
  val b   = IO(Input(Bits(16.W)))
  val c   = IO(Input(Bits(16.W)))
  val d   = IO(Input(Bits(16.W)))
  val sel = IO(Input(Bits(2.W)))
  val out = IO(Output(Bits(16.W)))

  // implement here! Optimal nand count is 192
  val mux1 = Module(Mux16())
  val mux2 = Module(Mux16())
  val mux3 = Module(Mux16())

  mux1.a   := a
  mux1.b   := b
  mux1.sel := sel(0)
  mux2.a   := c
  mux2.b   := d
  mux2.sel := sel(0)
  mux3.a   := mux1.out
  mux3.b   := mux2.out
  mux3.sel := sel(1)
  out      := mux3.out
