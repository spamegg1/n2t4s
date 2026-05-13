import chisel3.*, simulator.ChiselSim
import munit.FunSuite

class Not16Test extends FunSuite with ChiselSim:
  val Not16Data = Map(
    "b0000000000000000".U -> "b1111111111111111".U,
    "b1111111111111111".U -> "b0000000000000000".U,
    "b1010101010101010".U -> "b0101010101010101".U,
    "b0011110011000011".U -> "b1100001100111100".U,
    "b0001001000110100".U -> "b1110110111001011".U
  )

  test("Not16"):
    simulate[Not16](new Not16()): not16 =>
      for (in, out) <- Not16Data do
        not16.in.poke(in)
        not16.clock.step(1)
        not16.out.expect(out)
