import chisel3.*, simulator.ChiselSim
import munit.FunSuite

class Add16Test extends FunSuite with ChiselSim:
  val Add16TestData = Map(
    ("b0000000000000000".U, "b0000000000000000".U) -> "b0000000000000000".U,
    ("b0000000000000000".U, "b1111111111111111".U) -> "b1111111111111111".U,
    ("b1111111111111111".U, "b1111111111111111".U) -> "b1111111111111110".U,
    ("b1010101010101010".U, "b0101010101010101".U) -> "b1111111111111111".U,
    ("b0011110011000011".U, "b0000111111110000".U) -> "b0100110010110011".U,
    ("b0001001000110100".U, "b1001100001110110".U) -> "b1010101010101010".U
  )

  test("Add16"):
    simulate[Add16](new Add16()): add16 =>
      for ((a, b), out) <- Add16TestData do
        add16.a.poke(a)
        add16.b.poke(b)
        add16.clock.step(1)
        add16.out.expect(out)
