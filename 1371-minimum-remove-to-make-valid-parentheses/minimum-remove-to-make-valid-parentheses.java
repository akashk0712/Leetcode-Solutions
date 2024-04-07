class Solution {
    public String minRemoveToMakeValid(String s) {
        int n = s.length();
        StringBuilder temp = new StringBuilder();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                count--;
            }
            if (count < 0) {
                count++;
            } else {
                temp.append(s.charAt(i));
            }
        }
        n = temp.length();
        StringBuilder answer = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            if (temp.charAt(i) != '(' || count <= 0) {
                answer.append(temp.charAt(i));
            } else {
                count--;
            }
        }
        answer.reverse();
        return answer.toString();
    }
}