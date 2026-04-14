import chisel3.simulator.ChiselSim
import munit.FunSuite

val NandData = Map(
  (true, true)   -> false,
  (true, false)  -> true,
  (false, true)  -> true,
  (false, false) -> true
)

class NandTest extends FunSuite with ChiselSim:
  test("nand"):
    simulate[Nand](new Nand()): nand =>
      for ((a, b), out) <- NandData do
        nand.a.poke(a)
        nand.b.poke(b)
        nand.clock.step(1)
        nand.out.expect(out)
