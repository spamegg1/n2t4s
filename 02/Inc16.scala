import chisel3.*

/** 16-bit incrementer:
  *
  * out = in + 1 (arithmetic addition, overflow bit ignored)
  */
class Inc16 extends Module:
  val in  = IO(Input(Bits(16.W)))
  val out = IO(Output(Bits(16.W)))

  // implement here! total Nand count 80
  val adders = Array.ofDim[HalfAdder](16)
  val result = VecInit(in.asBools)

  for i <- 0 until 16 do
    val ha = Module(HalfAdder())
    adders(i) = ha
    ha.a      := in(i)
    ha.b      := (if i == 0 then 1.B else adders(i - 1).carry)
    result(i) := ha.sum

  out := result.asUInt
