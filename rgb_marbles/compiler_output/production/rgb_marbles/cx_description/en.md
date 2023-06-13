# RGB Marbles

You have a box full of marbles, all of them being coloured either *red*, *green*, or *blue*. You draw a certain number of marbles uniformly at
random without replacement and want to compute the probability of drawing some specific number of
each of the colours.

## Input
  
The first line of the input contains the number $t \leq 10$ of test cases.
Each of the $t$ test cases is described as follows.
  - It starts with a line containing three integers $\verb|r g b|$,
      separated by a space, denoting the number of red marbles ($1 \leq r \leq
      7)$, green marbles ($1 \leq g \leq 7$), and blue marbles $(1 \leq b \leq
      7)$. It is guaranteed that $r + g + b < 21$.
  - The following line contains an integer $\verb|m|$, denoting the number
      of marbles you draw uniformly at random from the box ($1 \leq m \leq r + g + b$).
  - The following line contains three integers $\verb|x y z|$, separated by
      a space, denoting the number of red marbles you aim for ($0 \leq x \leq
      r$), green marbles you aim for ($0 \leq y \leq g$), and blue marbles you
      aim for ($0 \leq z \leq b$). It is guaranteed that $x + y + z = m$.

## Output

For each test case output one line containing a real number denoting the
probability that among the $m$ uniformly at random drawn marbles there are
exactly $x$ red ones, exactly $y$ green ones, and exactly $z$ blue ones. Your
solution is going to be accepted if it has an absolute or relative error of at
most $10^{-6}$.

## Points

This exercise gives $100$ points (no bonus points!).

For extra fun you may want to compute binomial coefficients on your own. You
should be aware that, e.g. $21!$ cannot fit into a **long** number type.
Recall,
$$
  \binom{n}{k} =
  \begin{cases}
    1 & \text{ if $k = 0$}, \\
    1 & \text{ if $k = n$}, \\
    \binom{n - 1}{k - 1} + \binom{n - 1}{k} & \text{ otherwise}.
  \end{cases}
$$
