import chisel3.*, simulator.ChiselSim
import munit.FunSuite

class DMux4WayTest extends FunSuite with ChiselSim:
  val DMux4WayData = Map(
    (0, "b00".U) -> (0, 0, 0, 0),
    (0, "b01".U) -> (0, 0, 0, 0),
    (0, "b10".U) -> (0, 0, 0, 0),
    (0, "b11".U) -> (0, 0, 0, 0),
    (1, "b00".U) -> (1, 0, 0, 0),
    (1, "b01".U) -> (0, 1, 0, 0),
    (1, "b10".U) -> (0, 0, 1, 0),
    (1, "b11".U) -> (0, 0, 0, 1)
  )

  test("DMux4Way"):
    simulate[DMux4Way](new DMux4Way()): dmux4Way =>
      for ((in, sel), (a, b, c, d)) <- DMux4WayData do
        dmux4Way.in.poke(in)
        dmux4Way.sel.poke(sel)
        dmux4Way.clock.step(1)
        dmux4Way.a.expect(a)
        dmux4Way.b.expect(b)
        dmux4Way.c.expect(c)
        dmux4Way.d.expect(d)
