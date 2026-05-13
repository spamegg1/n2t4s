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
  val result = VecInit(a.asBools)

  for i <- 0 until 16 do
    val mux1 = Module(Mux1())
    mux1.a    := a(i)
    mux1.b    := b(i)
    mux1.sel  := sel
    result(i) := mux1.out

  out := result.asUInt
