import kotlin.math.min

/*

Given a list of 24-hour clock time points in "HH:MM" format,
return the minimum minutes difference between any two time-points in the list.


Example 1:

Input: timePoints = ["23:59","00:00"]
Output: 1
Example 2:

Input: timePoints = ["00:00","23:59","00:00"]
Output: 0


Constraints:

2 <= timePoints.length <= 2 * 104
timePoints[i] is in the format "HH:MM".

*/


class Solution539 {
    fun findMinDifference(timePoints: List<String>): Int {
        val sortedTimes = timePoints.map { timePoint ->
            (timePoint[0].digitToInt() * 10 + timePoint[1].digitToInt()) * 60 +
                    timePoint[3].digitToInt() * 10 + timePoint[4].digitToInt()
        }.sorted()

        var result = 10000
        for (i in 1..sortedTimes.lastIndex) {
            result = min(result, sortedTimes[i] - sortedTimes[i - 1])
        }

        return min(result, 1440 + sortedTimes.first() - sortedTimes.last())
    }
}