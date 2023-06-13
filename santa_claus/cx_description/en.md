
# Santa Claus

  Like every New Year, Santa Claus is giving away presents to children. This year
  he wants to approach the problem in a more systematic way. There are $n$
  children, denoted by $0, 1, \ldots, n - 1$, and Santa estimated for each child
  how good they were in the current year, which translates into how many toys they
  should get. Furthermore, Santa has $m$ different types of toys available,
  denoted by $0, \ldots, m - 1$, and for each type $i$ he can get $c_i$ copies of
  toys of that type. While it is fine if some of the toys are not given to
  anybody, Santa wants to make sure that each child receives the number of toys
  he/she deserves. Moreover, a single child should not get two toys of the same
  type. Please, help Santa determine if such a toy allocation is possible.

## Input
  The first line of the input file contains an integer $1 \leq t \leq 20$
  denoting the number of test cases that follow. Each of the $t$ test cases is
  described as follows.
  
  - It starts with a line containing two integers $\verb|n m|$, separated
      by a space, denoting the number of children and the number of different 
      toy types, respectively, such that $1 \le n, m \le 100$.
  - The next line contains $n$ integers $\verb|d|_0\ \ldots\
      \verb|d|_{n - 1}$, separated by a space, where $d_i$ denotes the number of
      toys child $i$ deserves and is such that $0 \le d_i \le 10^3$, for every 
      $i \in \{0, \ldots, n -1\}$.
  - The next line contains $m$ integers $\verb|c|_0\ \ldots\ \verb|c|_{m - 1}$, 
      where $c_i$ denotes the number of copies of the toy type $i$ Santa
      has and is such that $0 \le c_i \le 10^3$, for every $i \in \{0, \ldots, 
      m - 1\}$.
      
## Output
  For each test case output one line containing $\verb|yes|$ if Santa can
  distribute the toys according to his criteria and $\verb|no|$ otherwise.

## Points
  This exercise gives 100 points.
