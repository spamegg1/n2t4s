import chisel3.*

class Not16 extends Module:
  val in  = IO(Input(Bits(16.W)))
  val out = IO(Output(Bits(16.W)))

  // implement here!
  val not0  = Module(Not())
  val not1  = Module(Not())
  val not2  = Module(Not())
  val not3  = Module(Not())
  val not4  = Module(Not())
  val not5  = Module(Not())
  val not6  = Module(Not())
  val not7  = Module(Not())
  val not8  = Module(Not())
  val not9  = Module(Not())
  val not10 = Module(Not())
  val not11 = Module(Not())
  val not12 = Module(Not())
  val not13 = Module(Not())
  val not14 = Module(Not())
  val not15 = Module(Not())

  val result = VecInit(in.asBools)

  not0.in    := in(0)
  result(0)  := not0.out
  not1.in    := in(1)
  result(1)  := not1.out
  not2.in    := in(2)
  result(2)  := not2.out
  not3.in    := in(3)
  result(3)  := not3.out
  not4.in    := in(4)
  result(4)  := not4.out
  not5.in    := in(5)
  result(5)  := not5.out
  not6.in    := in(6)
  result(6)  := not6.out
  not7.in    := in(7)
  result(7)  := not7.out
  not8.in    := in(8)
  result(8)  := not8.out
  not9.in    := in(9)
  result(9)  := not9.out
  not10.in   := in(10)
  result(10) := not10.out
  not11.in   := in(11)
  result(11) := not11.out
  not12.in   := in(12)
  result(12) := not12.out
  not13.in   := in(13)
  result(13) := not13.out
  not14.in   := in(14)
  result(14) := not14.out
  not15.in   := in(15)
  result(15) := not15.out

  out := result.asUInt
