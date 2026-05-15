import chisel3.*

/** Computes the sum of two bits.
 *
 * in: a, b
 *
 * out: carry, sum
 *
 * carry = most significant bit of a + b
 *
 * sum = least significant bit of a + b
 *
 * a | b | carry | sum
 *
 * 0 | 0 | 0     | 0
 *
 * 0 | 1 | 0     | 1
 *
 * 1 | 0 | 0     | 1
 *
 * 1 | 1 | 1     | 0
 */
class HalfAdder extends Module:
  val a = IO(Input(Bool()))
  val b = IO(Input(Bool()))
  val sum = IO(Output(Bool()))
  val carry = IO(Output(Bool()))

  // implement here!
  val and = Module(And())
  val xor = Module(Xor())

  and.a := a
  and.b := b
  carry := and.out
  xor.a := a
  xor.b := b
  sum   := xor.out
