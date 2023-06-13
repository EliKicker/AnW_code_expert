# Chinese Whispers

In this exercise you are supposed to compute probabilities for the children's
game *Chinese Whispers* (also known as *Broken Telephone*).

The game consists of $n$ people lined up in a straight line $1, \ldots, n$, and
a start player—in this case you. You devise a message, which may be either a
$0$ or a $1$, and whisper it to the first person in the line (person $1$). The
message then propagates in this fashion throughout the line, that is the $i$th
person whispers it to the $(i + 1)$st and so on, until the message reaches the
$n$th person. That person then shouts it out loud in order to compare it with
your original message.

However, this can go wrong, as each person in the line may misinterpret a
message with some probability. Namely, the $i$th person interprets and whispers
forward the opposite of what she hears (i.e. $0$ instead of $1$, or $1$ instead
of $0$) with probability $p_i$.

Knowing the probabilities $p_i$ for all $i \in \{1, \ldots, n\}$, can you
compute what is the probability of the final message matching your original
message? Note that we only require that start message and final message are the
same; we do **not** require that all intermediate steps were correct.

## Input
  The first line of the input file contains a number $t \leq 30$ of test cases.
  Each of the $t$ test cases is described as follows.

  - It starts with a line which consists of two integers $\verb|n m|$,
      separated by a space, denoting the number of people participating in the
      game other than yourself ($1 \leq n \leq 10^4$) and your starting message
      ($m \in \{0, 1\}$).
  - The following line consists of $n$ real numbers $\verb|p|_1\ \ldots\
      \verb|p|_n$, separated by a space, denoting the probability that the $i$th
      person forwards the opposite of what they receive ($0 \leq p_i \leq 1$, for all $i \in \{1, \ldots, n\}$).

## Output
  For each test case output a single line with the probability that your message
  matches with what the $n$-th person shouts out loud. Each output value should
  be a real number between $0$ and $1$. Your solution is going to be accepted if
  it has an absolute or relative error of at most $10^{-3}$.

## Points
  There are three groups of test sets, worth $100$ points in total.
  
  1. For the first group of test sets, worth $20$ points, you may assume
      that $n \leq 3$.
  2. For the second group of test sets, worth $30$ points, you may assume
      that $n \leq 20$.
  3. For the third group of test sets, worth $50$ points, there are no
      additional assumptions.

