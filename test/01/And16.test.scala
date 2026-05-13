import chisel3.*, simulator.ChiselSim
import munit.FunSuite

class And16Test extends FunSuite with ChiselSim:
  val And16Data = Map(
    ("b0000000000000000".U, "b0000000000000000".U) -> "b0000000000000000".U,
    ("b0000000000000000".U, "b1111111111111111".U) -> "b0000000000000000".U,
    ("b1111111111111111".U, "b1111111111111111".U) -> "b1111111111111111".U,
    ("b1010101010101010".U, "b0101010101010101".U) -> "b0000000000000000".U,
    ("b0011110011000011".U, "b0000111111110000".U) -> "b0000110011000000".U,
    ("b0001001000110100".U, "b1001100001110110".U) -> "b0001000000110100".U
  )

  test("And16"):
    simulate[And16](new And16()): and16 =>
      for ((a, b), out) <- And16Data do
        and16.a.poke(a)
        and16.b.poke(b)
        and16.clock.step(1)
        and16.out.expect(out)
