package PokerHandKata

object PokerHand {
  val figures: Map[Char, Int] =
    List('2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K',
      'A').zipWithIndex.toMap

  case class Card(figure: Char, priority: Int)
  object Card {
    def parse(input: String): Card =
      input.toList match {
        case List(figure, _) => Card(figure, figures(figure))
      }
  }
  case class CardOccurrence(occurrence: Int, priority: Int, figure: Char)
  object CardOccurrence {
    val create: ((Char, Array[Card])) => CardOccurrence = {
      case (figure, cards) =>
        CardOccurrence(cards.size, cards.head.priority, figure)
    }
  }

  implicit val cardOccurrenceOrdering: Ordering[CardOccurrence] =
    Ordering
      .by[CardOccurrence, (Int, Int)](co => (co.occurrence, co.priority))
      .reverse

  def isStraight(cards: List[CardOccurrence]) = {
    (cards zip cards.tail) forall {
      case (c1, c2) => c1.priority - 1 == c2.priority
    }
  }

  def evaluate(cards: String): String = {
    def cardOccurrences =
      cards
        .split(" ")
        .map(Card.parse)
        .groupBy(_.figure)
        .map(CardOccurrence.create)
        .toList
        .sorted

    val maxCardOccurrence = cardOccurrences.head
    val secondMaxOccurrences = cardOccurrences.tail.head
    if (isStraight(cardOccurrences)) {
      "Straight"
    } else if (maxCardOccurrence.occurrence == 3) {
      s"Three of a kind: ${maxCardOccurrence.figure}"
    } else if (maxCardOccurrence.occurrence == 2) {
      if (secondMaxOccurrences.occurrence == 2) {
        s"Two pairs of: ${maxCardOccurrence.figure}, ${secondMaxOccurrences.figure}"
      } else {
        s"Pair of: ${maxCardOccurrence.figure}"
      }
    } else {
      s"High card: ${maxCardOccurrence.figure}"
    }

  }

}
