import chisel3.*, simulator.ChiselSim
import munit.FunSuite

class Or8WayTest extends FunSuite with ChiselSim:
  val Or8WayData = Map(
    "b00000000".U -> 0,
    "b11111111".U -> 1,
    "b00010000".U -> 1,
    "b00000001".U -> 1,
    "b00100110".U -> 1
  )

  test("Or8Way"):
    simulate[Or8Way](new Or8Way()): or8Way =>
      for (in, out) <- Or8WayData do
        or8Way.in.poke(in)
        or8Way.clock.step(1)
        or8Way.out.expect(out)
