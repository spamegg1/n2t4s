import chisel3.simulator.ChiselSim
import munit.FunSuite

class Mux1Test extends FunSuite with ChiselSim:
  val Mux1Data = Map(
    (true, true, true)   -> true,
    (true, true, false)  -> true,
    (true, false, true)  -> false,
    (true, false, false) -> true,
    (false, true, true)  -> true,
    (false, true, false) -> false,
    (false, false, true) -> false,
    (false, true, false) -> false
  )

  test("Mux1"):
    simulate[Mux1](new Mux1()): mux1 =>
      for ((a, b, sel), out) <- Mux1Data do
        mux1.a.poke(a)
        mux1.b.poke(b)
        mux1.sel.poke(sel)
        mux1.clock.step(1)
        mux1.out.expect(out)
