import chisel3.*

/** 8-way Or:
  *
  * in: in[8]
  *
  * out = (in[0] or in[1] or ... or in[7])
  */
class Or8Way extends Module:
  val in  = IO(Input(Bits(8.W)))
  val out = IO(Output(Bool()))

  // implement here! Optimal nand count is 21
  val or1 = Module(Or())
  val or2 = Module(Or())
  val or3 = Module(Or())
  val or4 = Module(Or())
  val or5 = Module(Or())
  val or6 = Module(Or())
  val or7 = Module(Or())

  or1.a := in(0)
  or1.b := in(1)
  or2.a := in(2)
  or2.b := in(3)
  or3.a := in(4)
  or3.b := in(5)
  or4.a := in(6)
  or4.b := in(7)
  or5.a := or1.out
  or5.b := or2.out
  or6.a := or3.out
  or6.b := or4.out
  or7.a := or5.out
  or7.b := or6.out
  out   := or7.out
