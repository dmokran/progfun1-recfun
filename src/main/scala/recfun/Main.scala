package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
//  println("Counting Change")
//  print(countChange(6, List(3,2,1)))
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
      if ((c == 0) || (r == c)) 1
      else pascal(c-1, r-1) + pascal(c, r-1)
    }
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      def nextParen(ch: List[Char], cnt: Int): Int = {
        if (ch.isEmpty) cnt
        else if (ch.head == ')')  nextParen(ch.tail, cnt-1)
        else if ((ch.head == '(') && (cnt >= 0)) nextParen(ch.tail, cnt+1)
        else nextParen(ch.tail, cnt)
      }
      if (nextParen(chars, 0) == 0) true else false
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      var count: Int = 0
      val sCoins = coins.sorted
      def seqCnt(elem: List[Int], currSum: Int): Unit = {
        if (currSum == money) count += 1
        else if (currSum < money) {
          for (j <- elem.indices) {
            seqCnt(elem.slice(j, elem.length), currSum + elem(j))
          }
        }
      }
      for (i <- sCoins.indices) {
        seqCnt(sCoins.slice(i, sCoins.length), sCoins(i))
      }
      count
    }
  }
