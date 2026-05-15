import chisel3.simulator.ChiselSim
import munit.FunSuite

class HalfAdderTest extends FunSuite with ChiselSim:
  val HalfAdderData =
    Map((0, 0) -> (0, 0), (0, 1) -> (0, 1), (1, 0) -> (0, 1), (1, 1) -> (1, 0))

  test("HalfAdder"):
    simulate[HalfAdder](new HalfAdder()): halfAdder =>
      for ((a, b), (carry, sum)) <- HalfAdderData do
        halfAdder.a.poke(a)
        halfAdder.b.poke(b)
        halfAdder.clock.step(1)
        halfAdder.carry.expect(carry)
        halfAdder.sum.expect(sum)
