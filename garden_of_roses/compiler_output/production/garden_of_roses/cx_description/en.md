# Garden of Roses

You are very proud of your beautiful garden of colourful roses. However,
recently you noticed that weed has started growing in the garden enclosed by
the roses. You want to get rid of it, but in order to do so you need to first
know whether each weed is inside of your rose garden or not.

## Input
  The first line of the input file contains a number $t \leq 30$ of test cases.
  Each of the $t$ test cases is described as follows.

  - It starts with a line which consists of two integers $\verb|n m|$,
      separated by a space, denoting the number of roses in your garden ($3 \leq
      n \leq 100$) and the number of weeds ($1 \leq m \leq 50$).
  - The following $n$ lines describe the roses. The $i$th line consists of
      two integers $\verb|x y|$, separated by a space, denoting the position of
      the $i$th rose ($-100 \leq x, y \leq 100$). It is guaranteed that no three
      roses lie on the same line and that no two roses are at the same position.
  - The following $m$ lines describe the weeds. The $i$th line consists of
      two integers $\verb|x y|$, separated by a space, denoting the position of
      the $i$th weed ($-100 \leq x, y \leq 100$).


## Output
  For each test case output a single string of length $m$ consisting of
  characters '`y`' and '`n`' such that the $i$th character of the
  string is '`y`' if the $i$th weed is inside the region enclosed by the
  roses, and '`n`', otherwise, for all $i \in \{1, \ldots, m\}$.

## Points
  This exercise is worth $100$ points.
