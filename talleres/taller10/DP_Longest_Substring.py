def longest_substring_dp(string1, string2, length_string1, length_string2):
    lcss = [[0 for m in range(length_string2 + 1)] for n in range(length_string1 + 1)]
    longest_common_substring = 0
    for i in range(length_string1 + 1):
        for j in range(length_string2 + 1):
            if i == 0 or j == 0:
                lcss[i][j] = 0
            elif string1[i - 1] == string2[j - 1]:
                lcss[i][j] = lcss[i - 1][j - 1] + 1
                longest_common_substring = max(longest_common_substring, lcss[i][j])
            else:
                lcss[i][j] = 0
    return longest_common_substring


string1 = str(input("Enter first string."))
string2 = str(input("Enter second string."))

length_string1 = len(string1)
length_string2 = len(string2)

print('Length of Longest Common Substring is',
      longest_substring_dp(string1, string2, length_string1, length_string2))
