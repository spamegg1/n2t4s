import chisel3.simulator.ChiselSim
import munit.FunSuite

class MuxTest extends FunSuite with ChiselSim:
  val MuxData = Map(
    (true, true, true)   -> true,
    (true, true, false)  -> true,
    (true, false, true)  -> false,
    (true, false, false) -> true,
    (false, true, true)  -> true,
    (false, true, false) -> false,
    (false, false, true) -> false,
    (false, true, false) -> false
  )

  test("Mux"):
    simulate[Mux](new Mux()): mux =>
      for ((a, b, sel), out) <- MuxData do
        mux.a.poke(a)
        mux.b.poke(b)
        mux.sel.poke(sel)
        mux.clock.step(1)
        mux.out.expect(out)
