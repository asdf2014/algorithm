// https://leetcode.com/problems/3sum/

object Solution {
  def threeSum(nums: Array[Int]): List[List[Int]] = {
    val numbersCount = nums.foldLeft(Map.empty[Int, Int].withDefaultValue(0)) {(count, nextNumber) =>
      count + (nextNumber -> (count(nextNumber) + 1))
    }
    val uniqueNumbers = numbersCount.keys.toList.sorted
    for {
      a <- uniqueNumbers
      b <- uniqueNumbers
      if a <= b
      if a != b || numbersCount(a) > 1
      c = -a - b
      if b <= c
      candidate = List(a, b, c)
      if numbersCount(c) >= candidate.count(_ == c)
    } yield candidate
  }
}