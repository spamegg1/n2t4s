import chisel3.*, simulator.ChiselSim
import munit.FunSuite

class DMux8WayTest extends FunSuite with ChiselSim:
  val DMux8WayData = Map(
    (0, "b000".U) -> (0, 0, 0, 0, 0, 0, 0, 0),
    (0, "b001".U) -> (0, 0, 0, 0, 0, 0, 0, 0),
    (0, "b010".U) -> (0, 0, 0, 0, 0, 0, 0, 0),
    (0, "b011".U) -> (0, 0, 0, 0, 0, 0, 0, 0),
    (0, "b100".U) -> (0, 0, 0, 0, 0, 0, 0, 0),
    (0, "b101".U) -> (0, 0, 0, 0, 0, 0, 0, 0),
    (0, "b110".U) -> (0, 0, 0, 0, 0, 0, 0, 0),
    (0, "b111".U) -> (0, 0, 0, 0, 0, 0, 0, 0),
    (1, "b000".U) -> (1, 0, 0, 0, 0, 0, 0, 0),
    (1, "b001".U) -> (0, 1, 0, 0, 0, 0, 0, 0),
    (1, "b010".U) -> (0, 0, 1, 0, 0, 0, 0, 0),
    (1, "b011".U) -> (0, 0, 0, 1, 0, 0, 0, 0),
    (1, "b100".U) -> (0, 0, 0, 0, 1, 0, 0, 0),
    (1, "b101".U) -> (0, 0, 0, 0, 0, 1, 0, 0),
    (1, "b110".U) -> (0, 0, 0, 0, 0, 0, 1, 0),
    (1, "b111".U) -> (0, 0, 0, 0, 0, 0, 0, 1)
  )

  test("DMux8Way"):
    simulate[DMux8Way](new DMux8Way()): dmux8Way =>
      for ((in, sel), (a, b, c, d, e, f, g, h)) <- DMux8WayData do
        dmux8Way.in.poke(in)
        dmux8Way.sel.poke(sel)
        dmux8Way.clock.step(1)
        dmux8Way.a.expect(a)
        dmux8Way.b.expect(b)
        dmux8Way.c.expect(c)
        dmux8Way.d.expect(d)
        dmux8Way.e.expect(e)
        dmux8Way.f.expect(f)
        dmux8Way.g.expect(g)
        dmux8Way.h.expect(h)
