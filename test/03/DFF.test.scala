import chisel3.*, simulator.ChiselSim
import munit.FunSuite

class DFFTest extends FunSuite with ChiselSim:
  test("DFF"):
    simulate[DFF](new DFF()): dff =>
      dff.in.poke(1)
      dff.clock.step(1) // prev input is 1
      dff.out.expect(1)
      dff.clock.step(1) // prev input is 1
      dff.out.expect(1)
      dff.in.poke(0)
      dff.clock.step(1) // prev input is 0
      dff.out.expect(0)
      dff.clock.step(1) // prev input is 0
      dff.out.expect(0)
