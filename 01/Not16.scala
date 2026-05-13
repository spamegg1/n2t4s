import chisel3.*

class Not16 extends Module:
  val in  = IO(Input(Bits(16.W)))
  val out = IO(Output(Bits(16.W)))

  // implement here!
  val result = VecInit(in.asBools)

  for i <- 0 until 16 do
    val not = Module(Not())
    not.in    := in(i)
    result(i) := not.out

  out := result.asUInt
