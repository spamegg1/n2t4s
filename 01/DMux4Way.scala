import chisel3.*

/** 4-way demultiplexor:
  *
  * {a, b, c, d} =
  *
  * {in, 0, 0, 0} if sel == 00
  *
  * {0, in, 0, 0} if sel == 01
  *
  * {0, 0, in, 0} if sel == 10
  *
  * {0, 0, 0, in} if sel == 11
  */
class DMux4Way extends Module:
  val in  = IO(Input(Bool()))
  val sel = IO(Input(Bits(2.W)))
  val a   = IO(Output(Bool()))
  val b   = IO(Output(Bool()))
  val c   = IO(Output(Bool()))
  val d   = IO(Output(Bool()))

  // implement here! Optimal nand count is 15
  val dmux1 = Module(DMux())
  val dmux2 = Module(DMux())
  val dmux3 = Module(DMux())

  dmux1.in  := in
  dmux1.sel := sel(1)
  dmux2.in  := dmux1.a
  dmux2.sel := sel(0)
  dmux3.in  := dmux1.b
  dmux3.sel := sel(0)
  a         := dmux2.a
  b         := dmux2.b
  c         := dmux3.a
  d         := dmux3.b
