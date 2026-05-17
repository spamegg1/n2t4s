import chisel3.*

class DFF extends Module:
  val in  = IO(Input(Bool()))
  val out = IO(Output(Bool()))
