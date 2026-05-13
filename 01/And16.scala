import chisel3.*

class And16 extends Module:
  val a   = IO(Input(Bits(16.W)))
  val b   = IO(Input(Bits(16.W)))
  val out = IO(Output(Bits(16.W)))

  // implement here!
  val result = VecInit(a.asBools)

  for i <- 0 until 16 do
    val and = Module(And())
    and.a     := a(i)
    and.b     := b(i)
    result(i) := and.out

  out := result.asUInt
