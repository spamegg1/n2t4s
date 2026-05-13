import chisel3.*

class And16 extends Module:
  val a   = IO(Input(Bits(16.W)))
  val b   = IO(Input(Bits(16.W)))
  val out = IO(Output(Bits(16.W)))

  // implement here!
  val and0  = Module(And())
  val and1  = Module(And())
  val and2  = Module(And())
  val and3  = Module(And())
  val and4  = Module(And())
  val and5  = Module(And())
  val and6  = Module(And())
  val and7  = Module(And())
  val and8  = Module(And())
  val and9  = Module(And())
  val and10 = Module(And())
  val and11 = Module(And())
  val and12 = Module(And())
  val and13 = Module(And())
  val and14 = Module(And())
  val and15 = Module(And())

  val result = VecInit(a.asBools)

  and0.a     := a(0)
  and0.b     := b(0)
  result(0)  := and0.out
  and1.a     := a(1)
  and1.b     := b(1)
  result(1)  := and1.out
  and2.a     := a(2)
  and2.b     := b(2)
  result(2)  := and2.out
  and3.a     := a(3)
  and3.b     := b(3)
  result(3)  := and3.out
  and4.a     := a(4)
  and4.b     := b(4)
  result(4)  := and4.out
  and5.a     := a(5)
  and5.b     := b(5)
  result(5)  := and5.out
  and6.a     := a(6)
  and6.b     := b(6)
  result(6)  := and6.out
  and7.a     := a(7)
  and7.b     := b(7)
  result(7)  := and7.out
  and8.a     := a(8)
  and8.b     := b(8)
  result(8)  := and8.out
  and9.a     := a(9)
  and9.b     := b(9)
  result(9)  := and9.out
  and10.a    := a(10)
  and10.b    := b(10)
  result(10) := and10.out
  and11.a    := a(11)
  and11.b    := b(11)
  result(11) := and11.out
  and12.a    := a(12)
  and12.b    := b(12)
  result(12) := and12.out
  and13.a    := a(13)
  and13.b    := b(13)
  result(13) := and13.out
  and14.a    := a(14)
  and14.b    := b(14)
  result(14) := and14.out
  and15.a    := a(15)
  and15.b    := b(15)
  result(15) := and15.out

  out := result.asUInt
