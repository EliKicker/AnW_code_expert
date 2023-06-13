# Three Coins
  Once upon a time there were three coins: a *Master Coin*, an *Alpha
  Coin*, and a *Beta Coin*. The Master Coin, instead of heads and tails, has
  greek letters *alpha* and *beta* on its sides. The remaining two coins
  have their sides coloured in red and blue.

  The following experiment is then performed. First the Master Coin is tossed
  and if the outcome is its face with alpha written on it, the Alpha Coin is
  tossed next. Otherwise, the Beta Coin is tossed.

  You are required to answer the following questions:

  1. What is the probability that you see red at the end of the experiment?
  2. Given that you see red at the end of the experiment, what is the
      probability that the Alpha Coin was tossed?
  3. You repeat the above experiment $n$ times and each time you see red at
      the end. What is the probability that the Beta Coin was used at least once
      in these $n$ trials?

## Input
  The first line of the input file contains a number $t \leq 30$ of test cases.
  Each of the $t$ test cases is described as follows.
  
  - It starts with a line that contains two integers $\verb|n x|$, separated
      by a space, denoting the number of times the experiment above is repeated
      ($1 \leq n \leq 10$) and the type of question you are supposed to answer
      ($1 \leq x \leq 3$). It is guaranteed that if $x \in \{1, 2\}$ then $n =
      1$.
  - The following line contains three real numbers $\verb|p a b|$, separated
      by a space, denoting the probability that the Master Coin shows alpha when
      tossed ($0 \leq p \leq 1$), the probability that the Alpha Coin shows red
      when tossed ($0 \leq a \leq 1$), and the probability that the Beta Coin
      shows red when tossed ($0 \leq b \leq 1$).

## Output
  For each test case output a single line with the answer to one of the
  questions stated above. The $x$ value of each test set determines which
  question you should output the answer to. For example, if $x = 2$ you should
  output the probability that the Alpha Coin was tossed given that you see red
  at the end of the experiment. Each value should be a real number between $0$
  and $1$. Your solution is going to be accepted if it has an absolute or
  relative error of at most $10^{-3}$.

## Points
  There are three groups of test sets, worth $50$ points in total.
  
  1. For the first group of test sets, worth $20$ points, you may assume
      that $n = 1$ and $x = 1$.
  2. For the second group of test sets, worth $20$ points, you may assume
      that $n = 1$ and $x \in \{1, 2\}$.
  3. For the third group of test sets, worth $10$ points, there are no
      additional assumptions.
      