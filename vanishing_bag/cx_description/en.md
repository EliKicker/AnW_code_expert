# Vanishing Bag

The vanishing bag is a special kind of bag—one from which objects, well,
*vanish*! Having one such bag you decide to play a game with your best friend.

Initially there are some number of white and black stones in the bag. The game
proceeds by two players, you and your friend, alternatively choosing a stone
from the bag and removing it. The players are required to do this without
looking into the bag, so each stone is considered to be drawn uniformly at
random.

However, this on its own would not be as fun, so there is a catch. Every time
someone draws a stone from the bag, another stone chosen uniformly at random
vanishes.

The game ends once a white stone is drawn *or* the bag becomes empty. The winner
is the player who draws the white stone *or* if the bag becomes empty the winner
is the player who played second.

Out of courtesy, your friend draws first and begins the game (thus, if the bag
becomes empty you win). What is the probability of you winning the game?

## Input

The first line of the input file contains a number $t \leq 30$ of test cases.
Each of the $t$ test cases is described as follows.
  - It consists of a single line that contains two integers $\verb|w b|$,
    separated by a space, denoting the number of white stones ($0 \leq w \leq
    100$) and black stones ($0 \leq b \leq 100$) in the bag.

## Output

For each test case output a single line with the probability of you winning the
game. Each value should be a real number between $0$ and $1$. Your solution is
going to be accepted if it has an absolute or relative error of at most
$10^{-3}$.

## Points

There are two groups of test sets, worth $10$ points in total.
  - For the first group of test sets, worth $4$ points, you may assume that $w
    \leq 20$ and $b \leq 20$.
  - For the second group of test sets, worth $6$ points, there are no
    additional assumptions.
