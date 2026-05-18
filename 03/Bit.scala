import chisel3.*

/** 1-bit register:
  *
  * If load[t] == 1 then out[t+1] = in[t]
  *
  * else out does not change (out[t+1] = out[t])
  */
class Bit extends Module:
  val in   = IO(Input(Bool()))
  val load = IO(Input(Bool()))
  val out  = IO(Output(Bool()))

  // implement here!
  val mux = Module(Mux1())
  val dff = Module(DFF())

  mux.a   := dff.out
  mux.b   := in
  mux.sel := load
  dff.in  := mux.out
  out     := dff.out
