import chisel3.*, simulator.ChiselSim
import munit.FunSuite

class BitTest extends FunSuite with ChiselSim:
  val data        = os.pwd / "test" / "03" / "Bit.test.data"
  val lines       = os.read.lines(data).map(parseBool3)
  val BitTestData = lines.grouped(2)

  test("Bit"):
    simulate[Bit](new Bit()): bit =>
      for Seq((in0, load0, out0), (in1, load1, out1)) <- BitTestData do
        bit.in.poke(in0)
        bit.load.poke(load0)
        bit.out.expect(out0)
        bit.clock.step(1)
        bit.in.expect(in1)
        bit.load.expect(load1)
        bit.out.expect(out1)
