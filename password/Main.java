import algorithms.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.LinkedList;

class Main {
    public static void main(String[] args) {
        // Uncomment this line if you want to read from a file
        In.open("public/test3.in");
        Out.compareTo("public/test3.out");

        int t = In.readInt();
        for (int i = 0; i < t; i++) {
            testCase();
        }
        
        // Uncomment this line if you want to read from a file
        In.close();
    }

    public static void testCase() {
        // Input using In.java class
        int n = In.readInt();
        String[] str = new String[n];
        In.readLine();
        for (int i = 0; i < n; ++i) {
          str[i] = In.readLine();
        }
        
        //gute idee hab ich ya
        HashMap<String, ArrayList<String>> graph = new HashMap<>();
        HashMap<String, Boolean> visited = new HashMap<>();
        HashMap<String, Integer> in_degree = new HashMap<>();
        HashMap<String, Integer> out_degree = new HashMap<>();
        for (int i = 0; i < n; ++i) {
          String u = str[i].substring(0, 2);
          String v = str[i].substring(1, 3);
          if (graph.keySet().contains(u)) {
            graph.get(u).add(v);
          } else {
            ArrayList<String> l = new ArrayList<>();
            l.add(v);
            graph.put(u, l);
          }
          if (graph.keySet().contains(v)) {
            graph.get(v).add(u);
          } else {
            ArrayList<String> l = new ArrayList<>();
            l.add(u);
            graph.put(v, l);
          }
          visited.put(u, false);
          visited.put(v, false);
          if (out_degree.keySet().contains(u)) {
            out_degree.put(u, out_degree.get(u) + 1);
          } else {
            out_degree.put(u, 1);
          }
          if (in_degree.keySet().contains(v)) {
            in_degree.put(v, in_degree.get(v) + 1);
          } else {
            in_degree.put(v, 1);
          }
          if (!in_degree.keySet().contains(u)) in_degree.put(u, 0);
          if (!out_degree.keySet().contains(v)) out_degree.put(v, 0);
        }
        
        //chegg de zusammenhang
        LinkedList<String> stack = new LinkedList<>();
        stack.push(str[0].substring(0, 2));
        visited.put(str[0].substring(0, 2), true);

        while (stack.size() != 0) {
          String u = stack.pop();
          
          if (graph.get(u) == null) continue;
          for (String s : graph.get(u)) {
            if (visited.get(s)) continue;
            stack.push(s);
            visited.put(s, true);
          }
        }
        
        boolean zusammen = true;
        for (Boolean b : visited.values()) {
          if (!b) zusammen = false;
        }
        
        if (!zusammen) {
          Out.println("no");
          return;
        }
        
        int num1 = 0;
        int num2 = 0;
        int c = 0;
        for (String s : graph.keySet()) {
          int in_deg = in_degree.get(s);
          int out_deg = out_degree.get(s);
          if (in_deg == out_deg) {
            c++;
          } else {
            if (in_deg + 1 == out_deg) {
              num1++;
            } else if (in_deg == out_deg + 1) {
              num2++;
            } else {
              Out.println("no");
              return;
            }
          }
        }
        
        if (c == graph.keySet().size() - 2 && num1 == 1 && num2 == 1 || c == graph.keySet().size() && num1 == 0 && num2 == 0) {
          Out.println("yes");
        } else {
          Out.println("no");
        }
    }
}
