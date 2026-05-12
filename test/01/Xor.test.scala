import chisel3.simulator.ChiselSim
import munit.FunSuite

class XorTest extends FunSuite with ChiselSim:
  val XorData = Map(
    (true, true)   -> false,
    (true, false)  -> true,
    (false, true)  -> true,
    (false, false) -> false
  )

  test("Xor"):
    simulate[Xor](new Xor()): xor =>
      for ((a, b), out) <- XorData do
        xor.a.poke(a)
        xor.b.poke(b)
        xor.clock.step(1)
        xor.out.expect(out)
