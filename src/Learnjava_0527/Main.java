package Learnjava_0527;
// public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String s = scanner.nextLine();
//        //中缀表达式转为后缀表达式
//        List<String> s1=transform(s);
//        //后缀表达式计算求值
//        int result= calculate(s1);
//        System.out.println(result);
//    }
//
//    private static List<String> transform(String s) {
//        Stack<String> stack = new Stack<>();
//        ArrayList<String> list = new ArrayList<>();
//        for (int i = 0; i < s.length(); i++) {
//            String c= String.valueOf(s.charAt(i));
//            switch (c){
//                //统一 + - 处理
//                case "+":
//                case "-":
//                    while (!stack.empty()&& !stack.peek().equals("(")) list.add(stack.pop());
//                    stack.push(c);
//                    break;
//                //统一 * / 处理
//                case "*":
//                case "/":
//                    while (!stack.empty()&&(stack.peek().equals("*") || stack.peek().equals("/"))) list.add(stack.pop());
//                    stack.push(c);
//                    break;
//                //括号处理
//                case "(":stack.push(c); break;
//                case ")":
//                    while (!stack.empty()&& !stack.peek().equals("(")) list.add(stack.pop());
//                    stack.pop();
//                    break;
//                //0-9 处理
//                default:
//                    int num= Integer.parseInt(c);
//                    while (i<s.length()-1&&s.charAt(i+1)<='9'&&s.charAt(i+1)>='0'){
//                        num=num*10+s.charAt(i+1)-'0';
//                        i++;
//                    }
//                    list.add(String.valueOf(num));
//            }
//        }
//        while (!stack.empty())
//            list.add(stack.pop());
//        return list;
//    }
//    private static int calculate(List<String> list) {
//        Stack<Integer> stack = new Stack<>();
//        for (String s : list) {
//            switch (s) {
//                case "+":
//                    stack.push(stack.pop() + stack.pop());
//                    break;
//                case "-":
//                    int first = stack.pop();
//                    int second = stack.pop();
//                    stack.push(second - first);
//                    break;
//                case "*":
//                    stack.push(stack.pop() * stack.pop());
//                    break;
//                case "/":
//                    int first1 = stack.pop();
//                    int second1 = stack.pop();
//                    stack.push(second1 / first1);
//                    break;
//                // num
//                default:
//                    stack.push(Integer.parseInt(s));
//            }
//        }
//        return stack.pop();
//    }
//}
public class Main {
    public int findDuplicate(int[] nums) {
        int fast = 0;
        int slow = 0;
        while(true){
            fast = nums[nums[fast]];
            slow = nums[slow];
            if(slow == fast){
                fast = 0;
                while(nums[slow] != nums[fast]){
                    fast = nums[fast];
                    slow = nums[slow];
                }
                return nums[slow];
            }
        }
    }
}
