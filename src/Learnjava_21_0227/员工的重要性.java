package Learnjava_21_0227;
//链接:https://leetcode-cn.com/problems/employee-importance/
import java.util.*;
//广度优先搜索
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
public class 员工的重要性 {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer,Employee> map = new HashMap<>();
        for(Employee employee : employees){
            map.put(employee.id,employee);
        }
        Queue<Employee> queue = new LinkedList<>();
        queue.offer(map.get(id));
        int sum = 0;
        while(!queue.isEmpty()){
            Employee employee = queue.poll();
            sum += employee.importance;
            for(int subld : employee.subordinates){
                queue.offer(map.get(subld));
            }
        }
        return sum;
    }
}
