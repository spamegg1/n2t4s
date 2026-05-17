import chisel3.*

/** 8-way demultiplexor:
  *
  * {a, b, c, d, e, f, g, h} =
  *
  * {in, 0, 0, 0, 0, 0, 0, 0} if sel == 000
  *
  * {0, in, 0, 0, 0, 0, 0, 0} if sel == 001
  *
  * etc.
  *
  * {0, 0, 0, 0, 0, 0, 0, in} if sel == 111
  */
class DMux8Way extends Module:
  val in  = IO(Input(Bool()))
  val sel = IO(Input(Bits(3.W)))
  val a   = IO(Output(Bool()))
  val b   = IO(Output(Bool()))
  val c   = IO(Output(Bool()))
  val d   = IO(Output(Bool()))
  val e   = IO(Output(Bool()))
  val f   = IO(Output(Bool()))
  val g   = IO(Output(Bool()))
  val h   = IO(Output(Bool()))

  // implement here! Optimal nand count is 28
  // You can use 7 DMux = 28 Nand.
  // Here is a simpler version with 2 DMux4Way + 1 DMux = 24 + 4 = 28 Nand
  val dmux1 = Module(DMux())
  val dmux2 = Module(DMux4Way())
  val dmux3 = Module(DMux4Way())

  dmux1.in  := in
  dmux1.sel := sel(2)
  dmux2.in  := dmux1.a
  dmux2.sel := sel(1, 0)
  dmux3.in  := dmux1.b
  dmux3.sel := sel(1, 0)
  a         := dmux2.a
  b         := dmux2.b
  c         := dmux2.c
  d         := dmux2.d
  e         := dmux3.a
  f         := dmux3.b
  g         := dmux3.c
  h         := dmux3.d
