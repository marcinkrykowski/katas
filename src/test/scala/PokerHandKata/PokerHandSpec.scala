package PokerHandKata

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class PokerHandSpec extends AnyWordSpec with Matchers {
  "Poker Hand" should {
    "pick the highest card 7" in {
      PokerHand.evaluate("3S 5H 6D 7H 2C") should equal("High card: 7")
    }
    "pick the highest card 9" in {
      PokerHand.evaluate("3S 5H 6D 9H 2C") should equal("High card: 9")
    }
    "pick the highest card J" in {
      PokerHand.evaluate("3S 5H 6D JS 2C") should equal("High card: J")
    }
    "pick the highest card T" in {
      PokerHand.evaluate("3S 5H 6D TS 2C") should equal("High card: T")
    }
    "pick the highest card Q" in {
      PokerHand.evaluate("3S 5H 6D QS 2C") should equal("High card: Q")
    }
    "pick the highest card K" in {
      PokerHand.evaluate("3S 5H 6D KS 2C") should equal("High card: K")
    }
    "pick the highest card A" in {
      PokerHand.evaluate("3S 5H 6D AS 2C") should equal("High card: A")
    }
    "pick the pair of aces" in {
      PokerHand.evaluate("3S 5H 2D AS AC") should equal("Pair of: A")
    }
    "pick two pairs of A, K" in {
      PokerHand.evaluate("3S KH KD AS AC") should equal("Two pairs of: A, K")
    }
    "pick three of a kind A" in {
      PokerHand.evaluate("3S KH AD AS AC") should equal(
        "Three of a kind: A"
      )
    }
    "pick straight" in {
      PokerHand.evaluate("3S 4H 5D 6S 7C") should equal(
        "Straight"
      )
    }
    "pick flush" in {
      PokerHand.evaluate("3S 4H 5D 6S 7C") should equal(
        "Flush"
      )
    }
  }
}
