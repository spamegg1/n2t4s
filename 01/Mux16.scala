import chisel3.*

/** 16-bit multiplexor:
  *
  * for i = 0..15
  *
  * out[i] = a[i] if sel == 0
  *
  * out[i] = b[i] if sel == 1
  */
class Mux16 extends Module:
  val a   = IO(Input(Bits(16.W)))
  val b   = IO(Input(Bits(16.W)))
  val sel = IO(Input(Bool()))
  val out = IO(Output(Bits(16.W)))

  // implement here!
  val mux0  = Module(Mux1())
  val mux1  = Module(Mux1())
  val mux2  = Module(Mux1())
  val mux3  = Module(Mux1())
  val mux4  = Module(Mux1())
  val mux5  = Module(Mux1())
  val mux6  = Module(Mux1())
  val mux7  = Module(Mux1())
  val mux8  = Module(Mux1())
  val mux9  = Module(Mux1())
  val mux10 = Module(Mux1())
  val mux11 = Module(Mux1())
  val mux12 = Module(Mux1())
  val mux13 = Module(Mux1())
  val mux14 = Module(Mux1())
  val mux15 = Module(Mux1())

  val result = VecInit(a.asBools)

  mux0.a     := a(0)
  mux0.b     := b(0)
  mux0.sel   := sel
  result(0)  := mux0.out
  mux1.a     := a(1)
  mux1.b     := b(1)
  mux1.sel   := sel
  result(1)  := mux1.out
  mux2.a     := a(2)
  mux2.b     := b(2)
  mux2.sel   := sel
  result(2)  := mux2.out
  mux3.a     := a(3)
  mux3.b     := b(3)
  mux3.sel   := sel
  result(3)  := mux3.out
  mux4.a     := a(4)
  mux4.b     := b(4)
  mux4.sel   := sel
  result(4)  := mux4.out
  mux5.a     := a(5)
  mux5.b     := b(5)
  mux5.sel   := sel
  result(5)  := mux5.out
  mux6.a     := a(6)
  mux6.b     := b(6)
  mux6.sel   := sel
  result(6)  := mux6.out
  mux7.a     := a(7)
  mux7.b     := b(7)
  mux7.sel   := sel
  result(7)  := mux7.out
  mux8.a     := a(8)
  mux8.b     := b(8)
  mux8.sel   := sel
  result(8)  := mux8.out
  mux9.a     := a(9)
  mux9.b     := b(9)
  mux9.sel   := sel
  result(9)  := mux9.out
  mux10.a    := a(10)
  mux10.b    := b(10)
  mux10.sel  := sel
  result(10) := mux10.out
  mux11.a    := a(11)
  mux11.b    := b(11)
  mux11.sel  := sel
  result(11) := mux11.out
  mux12.a    := a(12)
  mux12.b    := b(12)
  mux12.sel  := sel
  result(12) := mux12.out
  mux13.a    := a(13)
  mux13.b    := b(13)
  mux13.sel  := sel
  result(13) := mux13.out
  mux14.a    := a(14)
  mux14.b    := b(14)
  mux14.sel  := sel
  result(14) := mux14.out
  mux15.a    := a(15)
  mux15.b    := b(15)
  mux15.sel  := sel
  result(15) := mux15.out

  out := result.asUInt
