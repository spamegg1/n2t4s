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

  // implement here! Optimal nand count is 31
  // You can use 7 DMux = 35 Nand.
  // Here is a naive version with 2 DMux4Way + 1 DMux = 28 + 5 = 33 Nand
  // val dmux1 = Module(DMux())
  // val dmux2 = Module(DMux4Way())
  // val dmux3 = Module(DMux4Way())

  // dmux1.in  := in
  // dmux1.sel := sel(2)
  // dmux2.in  := dmux1.a
  // dmux2.sel := sel(1, 0)
  // dmux3.in  := dmux1.b
  // dmux3.sel := sel(1, 0)
  // a         := dmux2.a
  // b         := dmux2.b
  // c         := dmux2.c
  // d         := dmux2.d
  // e         := dmux3.a
  // f         := dmux3.b
  // g         := dmux3.c
  // h         := dmux3.d

  // Here is a 31 Nand optimal version.
  // The idea is that we have 3 selectors we need to negate, so 3 Not gates = 3 Nand
  // Then 2 + 4 + 8 = 14 And gates = 28 Nand, to connect the possibilities:
  // 2 possibilities from selector 1,
  // 4 possibilities from selector 1 + selector 2,
  // 8 possibilities from selector 1 + selector 2 + selector 3.
  val not0  = Module(Not())
  val not1  = Module(Not())
  val not2  = Module(Not())
  val and01 = Module(And())
  val and02 = Module(And())
  val and03 = Module(And())
  val and04 = Module(And())
  val and05 = Module(And())
  val and06 = Module(And())
  val and07 = Module(And())
  val and08 = Module(And())
  val and09 = Module(And())
  val and10 = Module(And())
  val and11 = Module(And())
  val and12 = Module(And())
  val and13 = Module(And())
  val and14 = Module(And())

  not0.in := sel(0)
  not1.in := sel(1)
  not2.in := sel(2)
  and01.a := in
  and01.b := not0.out
  and02.a := in
  and02.b := sel(0)
  and03.a := and01.out
  and03.b := not1.out
  and04.a := and02.out
  and04.b := not1.out
  and05.a := and01.out
  and05.b := sel(1)
  and06.a := and02.out
  and06.b := sel(1)
  and07.a := and03.out
  and07.b := not2.out
  and08.a := and04.out
  and08.b := not2.out
  and09.a := and05.out
  and09.b := not2.out
  and10.a := and06.out
  and10.b := not2.out
  and11.a := and03.out
  and11.b := sel(2)
  and12.a := and04.out
  and12.b := sel(2)
  and13.a := and05.out
  and13.b := sel(2)
  and14.a := and06.out
  and14.b := sel(2)
  a       := and07.out
  b       := and08.out
  c       := and09.out
  d       := and10.out
  e       := and11.out
  f       := and12.out
  g       := and13.out
  h       := and14.out
