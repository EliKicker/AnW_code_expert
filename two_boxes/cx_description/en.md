# Two Boxes
  There are two boxes, $A$ and $B$, each containing a certain number of red
  balls and blue balls. The following experiment is performed: one ball is drawn
  uniformly at random from box $A$ and thrown into box $B$; next, $n$ balls are
  drawn sequentially and uniformly at random without replacement from box $B$.

  You will be required to answer the following types of questions:
  
  1. If $n = 1$, what is the probability that a red ball is drawn from box
      $B$?
  2. If $n = 1$ and given that a red ball is drawn from box $B$, what is
      the probability that a red ball was thrown from box $A$ to box $B$?
  3. Given that a red ball was thrown from box $A$ to box $B$, what is the
      probability that at least one ball drawn from box $B$ is red?

## Input
  The first line of the input file contains a number $t \leq 30$ of test cases.
  Each of the $t$ test cases is described as follows.
  - It starts with a line that contains four integers $\verb|r|_1\
      \verb|b|_1\ \verb|r|_2\ \verb|b|_2$, separated by a space, denoting the
      number of red and blue balls in box $A$ ($1 \leq r_1, b_1 \leq 10$) and
      the number of red and blue balls in box $B$ ($1 \leq r_2, b_2 \leq 10$).
  - The following line contains two integers $\verb|n x|$, separated by a
      space, denoting the number of balls drawn from box $B$ ($1 \leq n \leq r_2+ b_2 + 1$), and the type 
      of question you are supposed to answer ($1 \leq
      x \leq 3$). It is guaranteed that if $x \in \{1, 2\}$ then $n = 1$.

## Output
  For each test case output a single line with the answer to one of the
  questions stated above. The $x$ value of each test set determines which
  question you should output the answer to. For example, if $x = 2$ you should
  output the probability that a red ball was thrown from box $A$ to box $B$
  given that a red ball is drawn from box $B$. Each value should be a real
  number between $0$ and $1$. Your solution is going to be accepted if it has an
  absolute or relative error of at most $10^{-3}$.

## Points
  There are three groups of test sets, worth $100$ points in total.
  
  1. For the first group of test sets, worth $40$ points, you may assume
      that $n = 1$ and $x = 1$.
  2. For the second group of test sets, worth $40$ points, you may assume
      that $n = 1$ and $x \in \{1, 2\}$.
  3. For the third group of test sets, worth $20$ points, there are no
      additional assumptions.