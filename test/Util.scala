import chisel3.*

def parseBool3(line: String): (Bool, Bool, Bool) =
  val arr = line.split(",").map(_.toInt)
  arr match
    case Array(in, load, out) => (in.B, load.B, out.B)
