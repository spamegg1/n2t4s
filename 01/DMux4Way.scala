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

  // implement here! Optimal nand count is 14
  // Here is a naive way using 3 DMux = 15 Nand
  // val dmux1 = Module(DMux())
  // val dmux2 = Module(DMux())
  // val dmux3 = Module(DMux())

  // dmux1.in  := in
  // dmux1.sel := sel(1)
  // dmux2.in  := dmux1.a
  // dmux2.sel := sel(0)
  // dmux3.in  := dmux1.b
  // dmux3.sel := sel(0)
  // a         := dmux2.a
  // b         := dmux2.b
  // c         := dmux3.a
  // d         := dmux3.b

  // Here is optimal 14 Nand gates:
  val not1 = Module(Not()) // 1 Nand
  val not2 = Module(Not()) // 1 Nand
  val and1 = Module(And()) // 2 Nand
  val and2 = Module(And()) // 2 Nand
  val and3 = Module(And()) // 2 Nand
  val and4 = Module(And()) // 2 Nand
  val and5 = Module(And()) // 2 Nand
  val and6 = Module(And()) // 2 Nand

  not1.in := sel(0)
  not2.in := sel(1)
  and1.a  := in
  and1.b  := not1.out
  and2.a  := in
  and2.b  := sel(0)
  and3.a  := and1.out
  and3.b  := not2.out
  and4.a  := and2.out
  and4.b  := not2.out
  and5.a  := and1.out
  and5.b  := sel(1)
  and6.a  := and2.out
  and6.b  := sel(1)
  a       := and3.out
  b       := and4.out
  c       := and5.out
  d       := and6.out
