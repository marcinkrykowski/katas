package BowlingKata

class BowlingGame {
  var rollNumber = 0
  val rolls: Array[Int] = new Array[Int](21)

  def getScore: Int = {
    var score = 0

    def isSpare(coursor: Int) = {
      rolls(coursor) + rolls(coursor + 1) == 10
    }

    def isStrike(coursor: Int) = {
      rolls(coursor) == 10
    }

    var coursor = 0

    for (_ <- 0 until 10) {
      if (isStrike(coursor)) {
        score += 10 + rolls(coursor + 1) + rolls(coursor + 2)
        coursor += 1
      } else if (isSpare(coursor)) {
        score += 10 + rolls(coursor + 2)
        coursor += 2
      } else {
        score += rolls(coursor) + rolls(coursor + 1)
        coursor += 2
      }
    }
    score
  }

  def roll(pins: Int) = {
    rolls(rollNumber) = pins
    rollNumber += 1
  }
}
