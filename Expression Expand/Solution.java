public class Solution {
    /**
     * @param s an expression includes numbers, letters and brackets
     * @return a string
     */
    public String expressionExpand(String s) {
        // Write your code here
        Stack<String> str = new Stack<String>();
        Stack<Integer> num = new Stack<Integer>();
        int number = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c))
                number = number * 10 + c - '0';
            else if (c == '[') {
                str.push("[");
                num.push(number);
                number = 0;
            } else if (c == ']') {
                Stack<String> temp = new Stack<String>();
                while (!str.empty()) {
                    String top = str.pop();
                    if (top.equals("[")) {
                        StringBuffer sb = new StringBuffer();
                        StringBuffer result = new StringBuffer();

                        while (!temp.empty()){
                            sb.append(temp.pop());
                        }

                        int times = num.pop();
                        for (int i = 0; i < times; ++i){
                          result.append(sb.toString());  
                        }
                        //将目前为止所得到的答案存在str方便之后重复， 所以这里的str这个stack必须是string的不可以是char
                        str.push(result.toString());
                        break;
                    }
                    temp.add(top);
                }
            } else
                str.add(String.valueOf(c));
        }

        Stack<String> temp = new Stack<String>();
        StringBuffer result = new StringBuffer();
        
        while (!str.empty())
            temp.add(str.pop());

        while (!temp.empty())
            result.append(temp.pop());
            
        return result.toString();
    }
}
