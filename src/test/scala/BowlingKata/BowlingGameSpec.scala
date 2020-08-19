package BowlingKata

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

class BowlingGameSpec extends AnyFlatSpec with Matchers {

  def game = {
    new {
      val bg = new BowlingGame
    }
  }
  it should "score '0' when there is no roll" in {
    val myGame = game.bg
    myGame.getScore shouldEqual 0
  }

  it should "score '0' when one pin down 0 times" in {
    val myGame = game.bg
    rolls(myGame, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    myGame.getScore shouldEqual 0
  }

  it should "score '20' when one pin down 20 times" in {
    val myGame = game.bg
    rolls(myGame, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1)
    myGame.getScore shouldEqual 20
  }

  it should "score spare" in {
    val myGame = game.bg
    rolls(myGame, 5, 5, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    myGame.getScore shouldEqual 18
  }

  it should "score strike" in {
    val myGame = game.bg
    rolls(myGame, 10, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)

    myGame.getScore shouldEqual 26
  }

  it should "score master strike" in {
    val myGame = game.bg
    rolls(myGame, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10)

    myGame.getScore shouldEqual 300
  }

  private def rolls(game: BowlingGame, pins: Int*) = {
    pins.foreach(pin => game.roll(pin))
  }

}
