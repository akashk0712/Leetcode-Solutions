class Solution(object):
    def maxScore(self, s):
        max_score = 0
        zeros = 0
        ones = s.count('1')

        for i in range(len(s) - 1):
            if s[i] == '0':
                zeros += 1
            else:
                ones -= 1
            max_score = max(max_score, zeros + ones)

        return max_score
        """
        :type s: str
        :rtype: int
        """
        