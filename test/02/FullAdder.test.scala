import chisel3.simulator.ChiselSim
import munit.FunSuite

class FullAdderTest extends FunSuite with ChiselSim:
  val FullAdderData = Map(
    (0, 0, 0) -> (0, 0),
    (0, 0, 1) -> (1, 0),
    (0, 1, 0) -> (1, 0),
    (0, 1, 1) -> (0, 1),
    (1, 0, 0) -> (1, 0),
    (1, 0, 1) -> (0, 1),
    (1, 1, 0) -> (0, 1),
    (1, 1, 1) -> (1, 1)
  )

  test("FullAdder"):
    simulate[FullAdder](new FullAdder()): fullAdder =>
      for ((a, b, c), (sum, carry)) <- FullAdderData do
        fullAdder.a.poke(a)
        fullAdder.b.poke(b)
        fullAdder.c.poke(c)
        fullAdder.clock.step(1)
        fullAdder.carry.expect(carry)
        fullAdder.sum.expect(sum)
