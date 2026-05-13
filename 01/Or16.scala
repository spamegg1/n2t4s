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
  val result = VecInit(a.asBools)

  for i <- 0 until 16 do
    val or = Module(Or())
    or.a      := a(i)
    or.b      := b(i)
    result(i) := or.out

  out := result.asUInt
