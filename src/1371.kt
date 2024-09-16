import kotlin.math.max

/*

Given the string s, return the size of the longest substring containing each vowel an even number of times.
That is, 'a', 'e', 'i', 'o', and 'u' must appear an even number of times.


Example 1:

Input: s = "eleetminicoworoep"
Output: 13
Explanation: The longest substring is "leetminicowor" which contains two each of the vowels: e, i and o and zero of the vowels: a and u.
Example 2:

Input: s = "leetcodeisgreat"
Output: 5
Explanation: The longest substring is "leetc" which contains two e's.
Example 3:

Input: s = "bcbcbc"
Output: 6
Explanation: In this case, the given string "bcbcbc" is the longest because all vowels: a, e, i, o and u appear zero times.


Constraints:

1 <= s.length <= 5 x 10^5
s contains only lowercase English letters.

*/


class Solution1371 {
    fun findTheLongestSubstring(s: String): Int {
        val prefixSums = IntArray(s.length + 1)
        prefixSums[0] = 31

        val firstPrefixSumId = IntArray(32) { -1 }
        firstPrefixSumId[31] = 0

        var count = 0

        for (i in s.indices) {
            prefixSums[i + 1] = prefixSums[i] xor getBitmask(s[i])
            if (firstPrefixSumId[prefixSums[i + 1]] == -1) {
                firstPrefixSumId[prefixSums[i + 1]] = i + 1
            } else {
                count = max(count, i + 1 - firstPrefixSumId[prefixSums[i + 1]])
            }
        }

        return count
    }

    private fun getBitmask(char: Char) =
        when (char) {
            'a' -> 1
            'e' -> 2
            'i' -> 4
            'o' -> 8
            'u' -> 16
            else -> 0
        }
}