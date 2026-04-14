import chisel3.simulator.ChiselSim
import munit.FunSuite

class AndTest extends FunSuite with ChiselSim:
  test("And"):
    simulate[And](new And()): and =>
      and.a.poke(true)
      and.b.poke(true)
      and.clock.step(1)
      and.out.expect(true)

      and.a.poke(true)
      and.b.poke(false)
      and.clock.step(1)
      and.out.expect(false)

      and.a.poke(false)
      and.b.poke(true)
      and.clock.step(1)
      and.out.expect(false)

      and.a.poke(false)
      and.b.poke(false)
      and.clock.step(1)
      and.out.expect(false)
