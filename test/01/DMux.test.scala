import chisel3.simulator.ChiselSim
import munit.FunSuite

class DMuxTest extends FunSuite with ChiselSim:
  val DMuxData = Map(
    (true, true)   -> (false, true),
    (true, false)  -> (true, false),
    (false, true)  -> (false, false),
    (false, false) -> (false, false)
  )

  test("DMux"):
    simulate[DMux](new DMux()): dmux =>
      for ((in, sel), (a, b)) <- DMuxData do
        dmux.in.poke(in)
        dmux.sel.poke(sel)
        dmux.clock.step(1)
        dmux.a.expect(a)
        dmux.b.expect(b)
