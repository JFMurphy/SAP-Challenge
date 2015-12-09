# SAP-Challenge

A bag contains 64 unique coloured (red, green, blue, yellow) and numbered (1 – 16) tokens.
Two players randomly remove a set of 4 tokens each from the bag and decide who wins based on the following rules:
0. Lower numbered rules take precedence
1.The player with the most matching colours wins (0 matching < 2 matching < 2 x 2 matching < 3 matching < 4 matching)
2.The player with the higher product of numbers wins (Multiply each of the numbers of the tokens together)
3.The player with the single best token wins (red < green < blue < yellow; 1 < 2 .. < 16; e.g. red 16 < green 1)

Write a program to read and evaluate the winners from the list of games at pastebin.com/sP6NgZhf

The first player winning can be interpreted as 0, the second as 1.
This forms a binary sequence of 8-bit ASCII characters.
Convert the game list to text to progress.

Hint: The first 3 characters / 24 games translate to “SAP”.
Use this to check your program.
