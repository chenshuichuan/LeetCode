package leetcode61;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EvaluateDivision399 {
    public static void main(String[] args) {

        EvaluateDivision399 p = new EvaluateDivision399();
        String[] a = {"a","b"};
        String[] b = {"b","c"};
        List<String> list = Arrays.asList(a);
        List<List<String>> equations = new ArrayList<>();
        equations.add(list);
        list = Arrays.asList(b);
        equations.add(list);

        double[] values = {2.0,3.0};

        String[] c = {"a","c"};
        String[] d = {"b","a"};
        String[] e = {"a","e"};
        String[] f = {"a","a"};
        String[] g = {"x","x"};
        //{{"a","c"},{"b","a"},{"a","e"},{"a","a"},{"x","x"}};
        List<List<String>> queries = new ArrayList<>();
        list = Arrays.asList(c);
        queries.add(list);
        list = Arrays.asList(d);
        queries.add(list);
        list = Arrays.asList(e);
        queries.add(list);
        list = Arrays.asList(f);
        queries.add(list);
        list = Arrays.asList(g);
        queries.add(list);

        values = p.calcEquation(equations,values,queries);
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i]+",");
        }
    }
    //广度优先的递归+回溯, O(q)O(!e)
    double[] res = null;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        res = new double[queries.size()];
        Arrays.fill(res,-1.0);
        for (int i = 0; i < queries.size();i++) {
            boolean[] visited = new boolean[equations.size()];
            dfs(visited,0,equations,values,queries,queries.get(i).get(0),i,1.0);
        }
        return res;
    }
    //递归,
    private void dfs(boolean[] visited,int visitedL,List<List<String>> equations, double[] values,
                     List<List<String>> queries,String start,int indexQ,double value){
        if(visitedL == equations.size())return;
        //找到所有未访问且以start开头或结尾的equation, 并检查是否结束
        for (int i = 0; i < equations.size(); i++) {
            if(!visited[i]){
                visited( i, visited,visitedL, equations, values, queries, start, indexQ, value);
            }
        }
    }
    private void visited(int i, boolean[] visited,int visitedL,List<List<String>> equations, double[] values,
                         List<List<String>> queries,String start,int indexQ,double value){
        List<String>equa = equations.get(i);
        //正向
        if(equa.get(0).equals(start)){
            //自身相除的例外
            if(start.equals(queries.get(indexQ).get(1))){
                res[indexQ] = 1.0;
                return;
            }
            if(equa.get(1).equals(queries.get(indexQ).get(1))){
                res[indexQ] =  value*values[i];
                return;
            }
            visited[i] = true;
            dfs(visited,visitedL+1,equations,values,queries,equa.get(1),indexQ,value*values[i]);
            visited[i] = false;
        }
        //反向
        else if(equa.get(1).equals(start)){
            //自身相除的例外
            if(start.equals(queries.get(indexQ).get(1))){
                res[indexQ] = 1.0;
                return;
            }
            if(equa.get(0).equals(queries.get(indexQ).get(1))){
                res[indexQ] = value*(1.0/values[i]);
                return;
            }
            visited[i] = true;
            dfs(visited,visitedL+1,equations,values,queries,equa.get(0),indexQ,value*(1.0/values[i]));
            visited[i] = false;
        }
    }
}
