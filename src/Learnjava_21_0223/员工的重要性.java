package Learnjava_21_0223;
//链接https://leetcode-cn.com/problems/employee-importance/
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
public class 员工的重要性 {
    public int DFS(Map<Integer,Employee> info,int id){
        //累加当前员工和直接下属的值
        int curImportance = info.get(id).importance;
        for(int subId : info.get(id).subordinates){
            curImportance += DFS(info,subId);
        }
        return curImportance;
    }
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer,Employee> info = new HashMap<>();
        for(Employee cur: employees){
            info.put(cur.id,cur);
        }
        return DFS(info,id);
    }
}
