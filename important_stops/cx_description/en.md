# Important Stops

You were hired by Swiss Federal Railways to do an important job. Given a map
with $n$ cities, denoted by $\{0, 1, \ldots, n - 1\}$, and a map of
*bi-directional* rail segments between them, your task is to decide at
which stops should the passengers be checked if they have a valid ticket. Since
each city has its corresponding unique stop, we refer to stops and cities
interchangeably. The process of ticket control takes time and human resources,
thus SBB decided that the passengers should be checked at a stop (city) $i$ only
if the stop is *very important*. A stop $a \in \{0, \ldots, n - 1\}$ is
very important if there exist two different cities $b, c \in \{0, \ldots, n -
1\} \setminus \{a\}$ such that the following is satisfied:

  - city $b$ is reachable by train from city $c$ (and the other way
    around), and
  - for a train to go from city $b$ to city $c$ it must go through city $a$.

## Input
  The first line of the input contains the number $t \leq 20$ of test cases.
  Each of the $t$ test cases is described as follows.
  
  - It starts with a line containing two integers $\verb|n m|$, separated by
      a space, denoting the number of stops ($1 \leq n \leq 10^4$) and the
      number of rail segments ($1 \leq m \leq 10^4$).
  - The next $m$ lines each consist of two integers $\verb|a b|$, separated
      by a space, denoting that there is a rail segment between $a$ and $b$
      (where $0 \leq a \neq b \leq n - 1$).

## Output
  For each test case output one line containing the id's of all the *very
  important* stops (cities) separated by space and sorted by the increasing value
  of the id. In case there are no important stops for a particular test case,
  output $\verb|-1|$.

## Points
  There is one group of test sets worth $100$ points in total.

