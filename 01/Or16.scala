import chisel3.*

/** 16-bit bitwise Or:
  *
  * for i = 0..15 out[i] = (a[i] or b[i])
  */
class Or16 extends Module:
  val a   = IO(Input(Bits(16.W)))
  val b   = IO(Input(Bits(16.W)))
  val out = IO(Output(Bits(16.W)))

  // implement here!
  val or0  = Module(Or())
  val or1  = Module(Or())
  val or2  = Module(Or())
  val or3  = Module(Or())
  val or4  = Module(Or())
  val or5  = Module(Or())
  val or6  = Module(Or())
  val or7  = Module(Or())
  val or8  = Module(Or())
  val or9  = Module(Or())
  val or10 = Module(Or())
  val or11 = Module(Or())
  val or12 = Module(Or())
  val or13 = Module(Or())
  val or14 = Module(Or())
  val or15 = Module(Or())

  val result = VecInit(a.asBools)

  or0.a      := a(0)
  or0.b      := b(0)
  result(0)  := or0.out
  or1.a      := a(1)
  or1.b      := b(1)
  result(1)  := or1.out
  or2.a      := a(2)
  or2.b      := b(2)
  result(2)  := or2.out
  or3.a      := a(3)
  or3.b      := b(3)
  result(3)  := or3.out
  or4.a      := a(4)
  or4.b      := b(4)
  result(4)  := or4.out
  or5.a      := a(5)
  or5.b      := b(5)
  result(5)  := or5.out
  or6.a      := a(6)
  or6.b      := b(6)
  result(6)  := or6.out
  or7.a      := a(7)
  or7.b      := b(7)
  result(7)  := or7.out
  or8.a      := a(8)
  or8.b      := b(8)
  result(8)  := or8.out
  or9.a      := a(9)
  or9.b      := b(9)
  result(9)  := or9.out
  or10.a     := a(10)
  or10.b     := b(10)
  result(10) := or10.out
  or11.a     := a(11)
  or11.b     := b(11)
  result(11) := or11.out
  or12.a     := a(12)
  or12.b     := b(12)
  result(12) := or12.out
  or13.a     := a(13)
  or13.b     := b(13)
  result(13) := or13.out
  or14.a     := a(14)
  or14.b     := b(14)
  result(14) := or14.out
  or15.a     := a(15)
  or15.b     := b(15)
  result(15) := or15.out

  out := result.asUInt
