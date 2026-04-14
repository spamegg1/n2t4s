import chisel3.simulator.ChiselSim
import munit.FunSuite

val AndData = Map(
  (true, true)   -> true,
  (true, false)  -> false,
  (false, true)  -> false,
  (false, false) -> false
)

class AndTest extends FunSuite with ChiselSim:
  test("And"):
    simulate[And](new And()): and =>
      for ((a, b), out) <- AndData do
        and.a.poke(a)
        and.b.poke(b)
        and.clock.step(1)
        and.out.expect(out)
