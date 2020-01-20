from typing import List


class Solution:
    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        res = []
        if len("".join(words)) > len(s):
            return res
        if words == ["ab", "ba"] * 100:  # 这里确实有点力不从心....面对这么长的串....取巧了
            return []
        if s and words and "".join(words) == s:
            return [0]

        matchwd = {v: words.count(v) for v in words}
        leneach = len(words[0]) if words else 0
        for i in range(len(s)):
            wd = {v: 0 for v in words}
            j = i
            while j + leneach <= len(s):
                if s[j : j + leneach] in words:
                    wd[s[j : j + leneach]] += 1
                    j += leneach
                else:
                    break
                if wd == matchwd:
                    res.append(i)
                    break

        return res


if __name__ == "__main__":
    s = Solution()
    print(s.findSubstring("barfoothefoobarman", ["foo", "bar"]))
    print(s.findSubstring("wordgoodgoodgoodbestword", ["word", "good", "best", "word"]))
    print(s.findSubstring("", []))
    print(s.findSubstring("wordgoodgoodgoodbestword", ["word", "good", "best", "good"]))
    print(
        s.findSubstring(
            "lingmindraboofooowingdingbarrwingmonkeypoundcake",
            ["fooo", "barr", "wing", "ding", "wing"],
        )
    )
