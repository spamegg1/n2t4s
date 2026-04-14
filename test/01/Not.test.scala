import chisel3.simulator.ChiselSim
import munit.FunSuite

class NotTest extends FunSuite with ChiselSim:
  test("not"):
    simulate[Not](new Not()): not =>
      not.in.poke(true)
      not.clock.step(1)
      not.out.expect(false)

      not.in.poke(false)
      not.clock.step(1)
      not.out.expect(true)
