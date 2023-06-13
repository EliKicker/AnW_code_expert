# Hectic Printers

Did you ever wonder how it is that technology advances so quickly but that
printers are still so bad? Jams happening all the time, printers declining to
print certain pages, pulling several papers at the same time... The list just
keeps growing.

Your local printer is no exception to this rule and behaves somewhat hectically.
Every minute it attempts to print precisely one page. The probability of it
being successful depends on the page to be printed—it seems, for example, that
pages containing images are less likely to be printed successfully. If the
printer fails to print a page, it tries to print that same page again in the
next minute—the probability of success being the same as before, independently
of how many times it already tried to print that page. Once the printer managed
to print the page, it moves on to the next page and stoically repeats its
procedure (this means in particular, that the printer never skips a page).

You send a job consisting of $n$ pages to the printer and decide to come back
and check on it after $m$ minutes. What is the expected number of pages the
printer will have printed by that time?

## Input

The first line of the input file contains a number $t \leq 30$ of test cases.
Each of the $t$ test cases is described as follows.
  - It starts with a line that contains two integers $\verb|n m|$, separated by
    a space, denoting the number of pages the job consists of ($1 \leq n \leq
    10^3$) and the number of minutes after which you come to check on the
    printer ($0 \leq m \leq 10^3$).
  - The following line contains $n$ real numbers $\verb|p|_1\ \dots\ \verb|p|_n$,
    separated by a space, denoting the probability of the $i$-th page being
    printed once it is its turn to be printed ($0 \leq p_i \leq 1$, for all $i
    \in \{1, \dotsc, n\}$).

## Output

For each test case output a single line with the expected number of pages
printed after $m$ minutes. Each value should be a real number between $0$ and
the total number of pages $n$. Your solution is going to be accepted if it has
an absolute or relative error of at most $10^{-3}$.

## Points

There are two groups of test sets, worth $100$ points in total. (No bonus points.)
  - For the first group of test sets, worth $40$ points, you may assume
    that $n \leq 20$ and $m \leq 20$.
  - For the second group of test sets, worth $60$ points, there are no
    additional assumptions.
