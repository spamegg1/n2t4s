import chisel3.*

/** Computes one of the following functions:
  *
  * x+y, x-y, y-x, 0, 1, -1, x, y, -x, -y, !x, !y,
  *
  * x+1, y+1, x-1, y-1, x&y, x|y on two 16-bit inputs,
  *
  * according to 6 input bits denoted zx,nx,zy,ny,f,no.
  *
  * In addition, the ALU computes two 1-bit outputs:
  *
  * if the ALU output == 0, zr is set to 1; otherwise zr is set to 0;
  *
  * if the ALU output < 0, ng is set to 1; otherwise ng is set to 0.
  */
class ALU extends Module:
  val x   = IO(Input(Bits(16.W)))
  val y   = IO(Input(Bits(16.W)))
  val zx  = IO(Input(Bool()))
  val nx  = IO(Input(Bool()))
  val zy  = IO(Input(Bool()))
  val ny  = IO(Input(Bool()))
  val f   = IO(Input(Bool()))
  val no  = IO(Input(Bool()))
  val zr  = IO(Output(Bool()))
  val ng  = IO(Output(Bool()))
  val out = IO(Output(Bits(16.W)))

  // implement here!
  // Implementation: the ALU logic manipulates the x and y inputs
  // and operates on the resulting values, as follows:
  // if (zx == 1) set x = 0        // 16-bit constant
  // if (nx == 1) set x = !x       // bitwise not
  // if (zy == 1) set y = 0        // 16-bit constant
  // if (ny == 1) set y = !y       // bitwise not
  // if (f == 1)  set out = x + y  // integer 2's complement addition
  // if (f == 0)  set out = x & y  // bitwise and
  // if (no == 1) set out = !out   // bitwise not
  // if (out == 0) set zr = 1
  // if (out < 0) set ng = 1

  val mux1 = Module(Mux16()) // if (zx == 1) set x = 0
  mux1.a   := x
  mux1.b   := 0.U(16.W)
  mux1.sel := zx // 64 Nand

  val not1 = Module(Not16()) // if (nx == 1) set x = !x
  not1.in := mux1.out // 16 Nand, 80 total
  val mux2 = Module(Mux16())
  mux2.a   := mux1.out
  mux2.b   := not1.out
  mux2.sel := nx // 64 Nand, 144 total

  val mux3 = Module(Mux16()) // if (zy == 1) set y = 0
  mux3.a   := y
  mux3.b   := 0.U(16.W)
  mux3.sel := zy // 64 Nand, 208 total

  val not2 = Module(Not16()) // if (ny == 1) set y = !y
  not2.in := mux3.out // 16 Nand, 224 total
  val mux4 = Module(Mux16())
  mux4.a   := mux3.out
  mux4.b   := not2.out
  mux4.sel := ny // 64 Nand, 288 total

  val and1 = Module(And16()) // if (f == 0)  set out = x & y
  and1.a := mux2.out
  and1.b := mux4.out // 32 Nand, 320 total

  val add1 = Module(Add16()) // if (f == 1) set out = x + y
  add1.a := mux2.out
  add1.b := mux4.out // 140 Nand, 460 total
  val mux5 = Module(Mux16())
  mux5.a   := and1.out
  mux5.b   := add1.out
  mux5.sel := f // 64 Nand, 524 total

  val not3 = Module(Not16()) // if (no == 1) set out = !out
  not3.in := mux5.out // 16 Nand, 540 total
  val mux6 = Module(Mux16())
  mux6.a   := mux5.out
  mux6.b   := not3.out
  mux6.sel := no // 64 Nand, 604 total

  val or1 = Module(Or8Way()) // if (out == 0) set zr = 1
  or1.in := mux6.out(7, 0) // 21 Nand, 625 total
  val or2 = Module(Or8Way())
  or2.in := mux6.out(15, 8) // 21 Nand, 646 total
  val or = Module(Or())
  or.a := or1.out
  or.b := or2.out // 3 Nand, 649 total
  val mux7 = Module(Mux1())
  mux7.a   := 1.B
  mux7.b   := 0.B
  mux7.sel := or.out // 4 Nand, 653 total

  val and = Module(And()) // if (out < 0) set ng = 1
  and.a := 1.B
  and.b := mux6.out(15) // 2 Nand, 655 total
  val mux8 = Module(Mux1())
  mux8.a   := 0.B
  mux8.b   := 1.B
  mux8.sel := and.out // 4 Nand, 659 total

  val mux9 = Module(Mux16()) // Output
  mux9.a   := mux5.out
  mux9.b   := not3.out
  mux9.sel := no // 64 Nand, 723 total

  zr  := mux7.out
  ng  := mux8.out
  out := mux9.out
