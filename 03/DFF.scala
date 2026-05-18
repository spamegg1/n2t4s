import chisel3.*

/** Provided as already implemented. */
class DFF extends Module:
  val in  = IO(Input(Bool()))
  val out = IO(Output(Bool()))

  val prev = RegNext(in)

  out := prev
