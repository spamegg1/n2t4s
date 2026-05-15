import chisel3.*, simulator.ChiselSim
import munit.FunSuite

class Inc16Test extends FunSuite with ChiselSim:
  val Inc16TestData = Map(
    "b0000000000000000".U -> "b0000000000000001".U,
    "b1111111111111111".U -> "b0000000000000000".U,
    "b0000000000000101".U -> "b0000000000000110".U,
    "b1111111111111011".U -> "b1111111111111100".U
  )

  test("Inc16"):
    simulate[Inc16](new Inc16()): inc16 =>
      for (in, out) <- Inc16TestData do
        inc16.in.poke(in)
        inc16.out.expect(out)
