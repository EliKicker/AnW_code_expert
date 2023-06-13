# Toppling Dominoes

Playing with dominoes is a lot of fun. You can, for example, place them in long
lines so that when the first tile is toppled, it topples the second, which
topples the third, etc., resulting in all of the tiles falling.

In this problem, you are dealing with a special kind of domino set, in which the
tiles are of different heights. Your task is to determine, given an arrangement
of these tiles in a line, how many of the domino tiles will fall after toppling
the left-most domino.

More precisely, we have the following set-up: the dominoes are placed at
successive points on the integer line, the first at position $1$, the second at
$2$, and so on. If a tile of height $h$ at position $i$ is toppled, this causes
the tiles at all positions $j > i$ such that $j - i < h$ to fall as well.

![Image](https://www.cadmo.ethz.ch/education/lectures/FS20/AW/restricted/programming_exercises/toppling_dominoes/dominoes.png)

## Input

The first line of the input contains the number $t \leq 10$ of test cases.
Each of the $t$ test cases is described as follows.
  - It starts with a line containing an integer $\verb|n|$ denoting the
    number of dominoes ($1 \leq n \leq 10^6$).
  - The following line contains $n$ integers $\verb|h|_0\ \ldots\
    \verb|h|_{n - 1}$, separated by a space, where $h_i$ denotes the height of
    the domino placed at the $(i + 1)$-st position ($1 \leq h_i < 2^{31}$).

## Output

For each test case output a single line that consists of a single integer
denoting the number of domino tiles that will fall after toppling the
left-most tile.

## Points
  
This exercise gives no bonus points.