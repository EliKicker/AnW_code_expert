# The sum of the dice

You are given two fair dice such that one has $n$ sides and the other one has
$m$ sides. Each side of a die has a given value. The values of the $n$-sided die
are denoted by $u_0, \ldots, u_{n - 1}$ and the values of the $m$-sided die are
denoted by $v_0, \ldots, v_{m - 1}$.

You want to study the following process. First, you roll the $n$-sided die, then
the $m$-sided one, and finally sum up the two observed values. For this process
you want to answer the following three queries:

1. What is the expected value of the sum of the outcomes?
2. For given values $x$ and $y$, what is the probability that the sum of
    the outcomes is strictly larger than $x$, given that the outcome of the
    first die roll is strictly smaller than $y$?
3. For a given value $z$, what is the expected value of the sum of the
    outcomes, given that the outcome of the first die roll is strictly smaller
    than $z$?

It is guaranteed that there exists a $u_i$ which is smaller than $y$ and $z$.

## Input
  The first line of the input contains the number $t \leq 30$ of test cases.
  Each of the $t$ test cases is described as follows.
  
  
  - It starts with a line containing two integers $\verb|n m|$, separated by
      a space, denoting the number of faces for the two dice $(1 \leq n, m \leq 100)$.
  - The following line contains $n$ integers $\verb|u|_0\ \verb|u|_1\
      \ldots\ \verb|u|_{n - 1}$, separated by a space, denoting the values of
      the faces for the first die $(0 \leq u_i \leq 100)$.
  - The following line contains $m$ integers $\verb|v|_0\ \verb|v|_1\
      \ldots\ \verb|v|_{m - 1}$, separated by a space, denoting the values of
      the faces for the second die ($0 \leq v_i \leq 100$).
  - The following line contains three integers $\verb|x y z|$, separated by
      a space, denoting the values that define the queries $(2)$ and $(3)$ from
      above $(1 \leq x, y, z \leq 100)$.

## Output
  For each test case output one line containing three real numbers, separated by
  a space, each corresponding to one of the queries $(1)$--$(3)$ defined above.
  The first number should correspond to query $(1)$, the second to query $(2)$,
  and the third to query $(3)$. Your solution is going to be accepted if it has
  an absolute or relative error of at most $10^{-5}$.

## Points
  This exercise is worth $50$ points.
