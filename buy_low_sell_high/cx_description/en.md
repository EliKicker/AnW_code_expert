# Buy Low, Sell High

A wise man once said: *'Son, the secret to becoming rich is selling goods
for more money than you buy them'*. As an inhabitant of a small
archipelago your options are limited, as you cannot
access the stock market easily. However, after careful examination of the local
market, you realise that island $0$ is selling gold at a considerably lower
price than this item is being bought on island $n-1$. You decide to take
advantage of this situation, and go back and forth between island $0$ (to buy
gold) and island $n-1$ (to sell it) to make money.

You can only travel between islands using bridges. The islands are connected by
two-way bridges which are made either of wood or bricks. Wooden bridges are
fragile and will break if you cross them, thus, they can only be used once.  On
the contrary, bridges made out of bricks will last forever and will not break,
independently of how many times you use them, thus, you may use them as many
times as you want.

Given that you are initially located on island $0$, you want to know how many
round trips you can make. A single round trip consists of traveling from island
$0$ to island $n-1$ and then back to island $0$.

## Input
  The first line of the input contains the number $t \leq 30$ of test cases.
  Each of the $t$ test cases is described as follows.

  - It starts with a line that consists of two integers $\verb|n m|$,
      separated by a space. They denote
      - $n$, the number of islands ($1 \leq n \leq 10^2$);
      - $m$, the number of bridges between islands ($1 \leq m \leq 10^3$).
  - The following $m$ lines each contain three integers $\verb|u v c|$,
      separated by spaces, denoting that there is a bridge from $u$ to $v$ ($0
      \leq u \neq v \leq n - 1$) that is made of material $c$ ($1$ for wood or
      $-1$ for bricks). There is at most one bridge for each pair of islands.

## Output
  For each test case output a single line with a single integer. This integer
  represent the number of round trips you can make between island $0$ and island
  $n-1$. If you can make infinitely many, output the word
  '$\verb|RICH|$'.

## Points
  This exercise gives no bonus points.
