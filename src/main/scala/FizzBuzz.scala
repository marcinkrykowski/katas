object FizzBuzz {
  def evaluate(number: Int) = {
    val condition1 = (n: Int) => n % 3 == 0
    val condition2 = (n: Int) => n % 5 == 0

    if (condition1(number) && condition2(number)) {
      "FizzBuzz"
    } else if (condition1(number))
      "Fizz"
    else if (condition2(number))
      "Buzz"
    else number
  }
}
