package FizzBuzz

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers

import FizzBuzz._

class FizzBuzzSpec extends AnyFlatSpec with Matchers {

  val fizz = "Fizz"
  val buzz = "Buzz"
  val fizzBuzz = fizz + buzz

  it should "return '1' for '1' given" in {
    assert(evaluate(1) == 1)
  }

  it should "return 'Fizz' for '3' given" in {
    assert(evaluate(3) === fizz)
  }

  it should "return 'Buzz' for '5' given" in {
    assert(evaluate(5) == buzz)
  }

  it should "return 'FizzBuzz' for '15' given" in {
    assert(evaluate(15) == fizzBuzz)
  }

}
