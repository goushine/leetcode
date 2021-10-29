import java.util.List;

class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val,ListNode next){
        this.val = val;
        this.next = next;
    }
}

public class LeetCode_2 {
    public static void main(String[] args){

    }
//    public static ListNode addTwoNumbers(ListNode l1,ListNode l2){
//        ListNode answer = new ListNode();
//        ListNode temp = answer;
//        int flag = 0;
//        while(l1.next==null || l2.next ==null){
//            int t = l1.val+l2.val+flag;
//            if(t>=10){
//                t = t%10;
//                flag = 1;
//            }else{
//                flag =0;
//            }
//            answer.next = new ListNode(t+flag);
//            answer = answer.next;
//            l1 = l1.next;
//            l2 = l2.next;
//        }
//        while(l1.next!=null){
//            int t = l1.val+flag;
//            if(t>=10){
//                t = t%10;
//                flag = 1;
//            }
//            answer.next = new ListNode(l1.val+flag);
//            answer = answer.next;
//
//        }
//        while(l2.next!=null){
//
//        }
//    }
    public static ListNode addTwoNumbers(ListNode l1,ListNode l2){
        ListNode head = null,tail = null;
        int carry = 0;
        while(l1 !=null || l2!=null){
            int n1 = l1 !=null ? l1.val:0;
            int n2 = l2 !=null ? l2.val:0;
            int sum = n1 + n2+carry;
            if(head == null){
                head = tail = new ListNode(sum%10);
            }else{
                tail.next = new ListNode(sum%10);
                tail = tail.next;
            }
            carry = sum/10;
            if(l1 !=null){
                l1 = l1.next;
            }
            if(l2 !=null){
                l2 = l2.next;
            }
        }
        if(carry >0){
            tail.next = new ListNode(carry);
        }
        return  head;
    }

    public static ListNode addTwoNumbers_two(ListNode l1,ListNode l2){
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        int add = l1.val + l2.val;
        ListNode res = new ListNode(add % 10);
        res.next = addTwoNumbers_two(l1.next,l2.next);
        if(add >=10){
            res.next = addTwoNumbers_two(res.next,new ListNode(1));
        }
        return res;
    }
}
