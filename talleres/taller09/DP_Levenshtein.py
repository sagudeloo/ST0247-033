def levenshtein(string1, string2, length_string1, length_string2):
    matrix = [[0 for x in range(length_string1 + 1)] for x in range(length_string2 + 1)]
    for i in range(length_string1 + 1):
        for j in range(length_string2 + 1):
            if i == 0:
                matrix[i][j] = j
            elif j == 0:
                matrix[i][j] = i
            elif string1[i - 1] == string2[j - 1]:
                matrix[i][j] = matrix[i - 1][j - 1]
            else:
                matrix[i][j] = 1 + min(matrix[i][j - 1],
                                   matrix[i - 1][j],
                                   matrix[i - 1][j - 1])
    return matrix[m][n]


str1 = "sunday"
str2 = "wednesday"

print(levenshtein(str1, str2, len(str1), len(str2)))
