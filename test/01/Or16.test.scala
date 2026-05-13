import chisel3.*, simulator.ChiselSim
import munit.FunSuite

class Or16Test extends FunSuite with ChiselSim:
  val Or16Data = Map(
    ("b0000000000000000".U, "b0000000000000000".U) -> "b0000000000000000".U,
    ("b0000000000000000".U, "b1111111111111111".U) -> "b1111111111111111".U,
    ("b1111111111111111".U, "b1111111111111111".U) -> "b1111111111111111".U,
    ("b1010101010101010".U, "b0101010101010101".U) -> "b1111111111111111".U,
    ("b0011110011000011".U, "b0000111111110000".U) -> "b0011111111110011".U,
    ("b0001001000110100".U, "b1001100001110110".U) -> "b1001101001110110".U
  )

  test("Or16"):
    simulate[Or16](new Or16()): or16 =>
      for ((a, b), out) <- Or16Data do
        or16.a.poke(a)
        or16.b.poke(b)
        or16.clock.step(1)
        or16.out.expect(out)
