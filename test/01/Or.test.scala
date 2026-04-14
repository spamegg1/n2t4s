import chisel3.simulator.ChiselSim
import munit.FunSuite

val OrData = Map(
  (true, true)   -> true,
  (true, false)  -> true,
  (false, true)  -> true,
  (false, false) -> false
)

class OrTest extends FunSuite with ChiselSim:
  test("Or"):
    simulate[Or](new Or()): or =>
      for ((a, b), out) <- OrData do
        or.a.poke(a)
        or.b.poke(b)
        or.clock.step(1)
        or.out.expect(out)
