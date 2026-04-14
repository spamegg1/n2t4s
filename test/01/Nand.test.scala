import chisel3.simulator.ChiselSim
import munit.FunSuite

class NandTest extends FunSuite with ChiselSim:
  test("nand"):
    simulate[Nand](new Nand()): nand =>
      nand.a.poke(true)
      nand.b.poke(true)
      nand.clock.step(1)
      nand.out.expect(false)

      nand.a.poke(true)
      nand.b.poke(false)
      nand.clock.step(1)
      nand.out.expect(true)

      nand.a.poke(false)
      nand.b.poke(true)
      nand.clock.step(1)
      nand.out.expect(true)

      nand.a.poke(false)
      nand.b.poke(false)
      nand.clock.step(1)
      nand.out.expect(true)
