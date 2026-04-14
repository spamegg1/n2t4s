import chisel3.*

/** Provided as already implemented.
  *
  * in: a, b
  *
  * out = false if a and b are both true, true otherwise.
  */
class Nand extends Module:
  val a, b = IO(Input(Bool()))
  val out  = IO(Output(Bool()))
  out := !(a && b)
