package leetcode11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//
public class ReconstructItinerary332 {
    public static void main(String[] args){
        long a= System.currentTimeMillis();
        ReconstructItinerary332 p = new ReconstructItinerary332();
        String str = "[[\"AXA\",\"EZE\"],[\"EZE\",\"AUA\"],[\"ADL\",\"JFK\"],[\"ADL\",\"TIA\"],[\"AUA\",\"AXA\"],[\"EZE\",\"TIA\"],[\"EZE\",\"TIA\"],[\"AXA\",\"EZE\"],[\"EZE\",\"ADL\"],[\"ANU\",\"EZE\"],[\"TIA\",\"EZE\"],[\"JFK\",\"ADL\"],[\"AUA\",\"JFK\"],[\"JFK\",\"EZE\"],[\"EZE\",\"ANU\"],[\"ADL\",\"AUA\"],[\"ANU\",\"AXA\"],[\"AXA\",\"ADL\"],[\"AUA\",\"JFK\"],[\"EZE\",\"ADL\"],[\"ANU\",\"TIA\"],[\"AUA\",\"JFK\"],[\"TIA\",\"JFK\"],[\"EZE\",\"AUA\"],[\"AXA\",\"EZE\"],[\"AUA\",\"ANU\"],[\"ADL\",\"AXA\"],[\"EZE\",\"ADL\"],[\"AUA\",\"ANU\"],[\"AXA\",\"EZE\"],[\"TIA\",\"AUA\"],[\"AXA\",\"EZE\"],[\"AUA\",\"SYD\"],[\"ADL\",\"JFK\"],[\"EZE\",\"AUA\"],[\"ADL\",\"ANU\"],[\"AUA\",\"TIA\"],[\"ADL\",\"EZE\"],[\"TIA\",\"JFK\"],[\"AXA\",\"ANU\"],[\"JFK\",\"AXA\"],[\"JFK\",\"ADL\"],[\"ADL\",\"EZE\"],[\"AXA\",\"TIA\"],[\"JFK\",\"AUA\"],[\"ADL\",\"EZE\"],[\"JFK\",\"ADL\"],[\"ADL\",\"AXA\"],[\"TIA\",\"AUA\"],[\"AXA\",\"JFK\"],[\"ADL\",\"AUA\"],[\"TIA\",\"JFK\"],[\"JFK\",\"ADL\"],[\"JFK\",\"ADL\"],[\"ANU\",\"AXA\"],[\"TIA\",\"AXA\"],[\"EZE\",\"JFK\"],[\"EZE\",\"AXA\"],[\"ADL\",\"TIA\"],[\"JFK\",\"AUA\"],[\"TIA\",\"EZE\"],[\"EZE\",\"ADL\"],[\"JFK\",\"ANU\"],[\"TIA\",\"AUA\"],[\"EZE\",\"ADL\"],[\"ADL\",\"JFK\"],[\"ANU\",\"AXA\"],[\"AUA\",\"AXA\"],[\"ANU\",\"EZE\"],[\"ADL\",\"AXA\"],[\"ANU\",\"AXA\"],[\"TIA\",\"ADL\"],[\"JFK\",\"ADL\"],[\"JFK\",\"TIA\"],[\"AUA\",\"ADL\"],[\"AUA\",\"TIA\"],[\"TIA\",\"JFK\"],[\"EZE\",\"JFK\"],[\"AUA\",\"ADL\"],[\"ADL\",\"AUA\"],[\"EZE\",\"ANU\"],[\"ADL\",\"ANU\"],[\"AUA\",\"AXA\"],[\"AXA\",\"TIA\"],[\"AXA\",\"TIA\"],[\"ADL\",\"AXA\"],[\"EZE\",\"AXA\"],[\"AXA\",\"JFK\"],[\"JFK\",\"AUA\"],[\"ANU\",\"ADL\"],[\"AXA\",\"TIA\"],[\"ANU\",\"AUA\"],[\"JFK\",\"EZE\"],[\"AXA\",\"ADL\"],[\"TIA\",\"EZE\"],[\"JFK\",\"AXA\"],[\"AXA\",\"ADL\"],[\"EZE\",\"AUA\"],[\"AXA\",\"ANU\"],[\"ADL\",\"EZE\"],[\"AUA\",\"EZE\"]]";
//        String[] a1 = {"MUC", "LHR"};
//        String[] a2 = {"JFK", "MUC"};
//        String[] a3 = {"SFO", "SJC"};
//        String[] a4 ={"LHR", "SFO"};
//
//        List<List<String>> tickets = new ArrayList<List<String>>();
//        tickets.add(Arrays.asList(a1));
//        tickets.add(Arrays.asList(a2));
//        tickets.add(Arrays.asList(a3));
//        tickets.add(Arrays.asList(a4));
        //输入: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
        //输出: ["JFK","ATL","JFK","SFO","ATL","SFO"]

//        String[] a1 = {"JFK","SFO"};
//        String[] a2 = {"JFK","ATL"};
//        String[] a3 = {"SFO","ATL"};
//        String[] a4 = {"ATL","JFK"};
//        String[] a5 = {"ATL","SFO"};
//        List<List<String>> tickets = new ArrayList<List<String>>();
//        tickets.add(Arrays.asList(a1));
//        tickets.add(Arrays.asList(a2));
//        tickets.add(Arrays.asList(a3));
//        tickets.add(Arrays.asList(a4));
//        tickets.add(Arrays.asList(a5));
//        System.out.println(p.findItinerary(tickets).toString());
        List<List<String>> listList = p.buildtickets(str);
        System.out.println(p.findItinerary(listList).toString());
        System.out.print("程序执行时间为：");
        System.out.println(System.currentTimeMillis()-a+"毫秒");
    }
    private List<List<String>> buildtickets(String str){
        List<List<String>> lists = new ArrayList<List<String>>();
        List<String> strings =null;
        int flag =0;//内部list标记
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)>='A' &&str.charAt(i)<='Z'){
                if(flag == 1){
                    strings.add(str.substring(i,i+3));
                    lists.add(strings);
                    flag = 0;
                }
                else {
                    strings = new ArrayList<String>();
                    strings.add(str.substring(i,i+3));
                    flag = 1;
                }
                i+=3;
            }
        }
        return lists;
    }

    private List<String> pathList = new ArrayList<String>();
    private List<List<String>> lists = new ArrayList<List<String>>();

    public List<String> findItinerary(List<List<String>> tickets) {
        pathList.add("JFK");
        dfs(tickets,"JFK");
        return findMin(lists);
    }
    private void dfs(List<List<String>> tickets, String from) {
        if(tickets.size() == 0 ){
            //System.out.println(pathList.toString());
            if(pathList.size()>1)lists.add(new ArrayList<String>(pathList));
            return;
        }
        for (int i = 0; i < tickets.size();i++) {
            List<String> ticket = tickets.get(i);
            if(from.equals(ticket.get(0))){
                pathList.add(ticket.get(1));
                tickets.remove(i);
                dfs(tickets,ticket.get(1));
                tickets.add(i,ticket);
                pathList.remove(pathList.size()-1);
            }
        }
    }
    public List<String> findMin(List<List<String>> lists){
        if(lists.size()<1)return null;
        int minIndex = 0;
        String min = listToString(lists.get(minIndex));
        for(int i=1;i<lists.size();i++){
            String temp = listToString(lists.get(i));
            if(min.compareTo(temp)>0){
                min = temp;
                minIndex = i;
            }
        }
        return lists.get(minIndex);
    }
    private String listToString(List<String> stringList){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <stringList.size(); i++) {
            stringBuilder.append(stringList.get(i));
        }
        return stringBuilder.toString();
    }


}
