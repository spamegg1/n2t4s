import chisel3.*, simulator.ChiselSim
import munit.FunSuite

class BitTest extends FunSuite with ChiselSim:
  test("Bit"):
    simulate[Bit](new Bit()): bit =>
      assert(true)
