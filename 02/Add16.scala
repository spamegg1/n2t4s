import chisel3.*

class Add16 extends Module:
  val a   = IO(Input(Bits(16.W)))
  val b   = IO(Input(Bits(16.W)))
  val out = IO(Output(Bits(16.W)))

  // implement here!
  val adders = Array.ofDim[FullAdder](16) // only 15, index 0 not used
  val result = VecInit(a.asBools)

  val halfAdder = Module(HalfAdder())
  halfAdder.a := a(0)
  halfAdder.b := b(0)
  result(0)   := halfAdder.sum

  for i <- 1 until 16 do
    val fullAdder = Module(FullAdder())
    adders(i) = fullAdder
    fullAdder.a := a(i)
    fullAdder.b := b(i)
    fullAdder.c := (if i == 1 then halfAdder.carry else adders(i - 1).carry)
    result(i)   := fullAdder.sum

  out := result.asUInt
