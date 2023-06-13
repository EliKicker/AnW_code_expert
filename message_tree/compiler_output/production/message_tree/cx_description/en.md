# Message tree
  You are given a tree with $n$ nodes $0, \ldots, n - 1$, rooted at $0$.
  (Reminder: a tree is a connected graph with exactly $n-1$ edges.) Initially, the
  root sends a message to one of its neighbours. Then, whenever a node $u$
  receives the message, it decides on a neighbouring node $v$ which has not yet
  received the message and forwards it to $v$. This process ends when the message
  reaches a node $u$ without neighbours that don't know the message.

  For every edge in the tree you know the cost of sending the message through it.
  The total cost is the sum of the costs of all edges through which the message
  has been transmitted. You want to know the maximum total cost that a single
  message can incur.

## Input
  The first line of the input file contains a number $t \leq 10$ of test cases.
  Each of the $t$ test cases is described as follows.
  
  - It starts with a line which consists of an integer $\verb|n|$, denoting
      the number of nodes in the tree ($1 \leq n \leq 10^5$).
  - Each of the following $n - 1$ lines consists of three integers
      $\verb|u v c|$, separated by a space, denoting that nodes $u$ and $v$ are
      adjacent in the tree ($0 \leq u, v \leq n - 1$), and that the cost of the
      edge $\{u,v\}$ is $c$ ($0 \leq c \leq 10^4$). Node $u$ is always closer to
      the root than node $v$.
      
## Output
  For each test case output a single line with an integer denoting a maximum
  possible total cost your message might incur before it stops spreading.

## Points
  There are three groups of test sets, worth $100$ points in total.
  
  1. For the first group of test sets, worth $20$ points, you may assume
      that $n \leq 10^3$. Moreover, every node is at distance at most two from
      the root and every node other than the root has at most one child.
  2. For the second group of test sets, worth $30$ points, you may assume
      that $n \leq 10^3$.
  3. For the third group of test sets, worth $50$ points, there are no
      additional assumptions.