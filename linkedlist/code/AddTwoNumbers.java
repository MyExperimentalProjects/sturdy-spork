class ListNode{
	int val;
	ListNode next;

	ListNode(int v){
		this.val = v;
		this.next = null;
	}

	void print(){
		ListNode runner = this;
		while(runner != null){
			System.out.println(runner.val);
			runner = runner.next;
		}
	}

}
public class AddTwoNumbers{

	public static ListNode add(ListNode l1, ListNode l2){
		if(l1 == null && l2 == null){
			return null;
		}
		ListNode runner1 = l1;
		ListNode runner2 = l2;	
		ListNode sumHead = null;
		ListNode sumTail = null;
		int carry = 0;
		int sum = 0;
		while(runner1 != null || runner2 != null){
			sum = 0;
			if(runner1 != null){
				sum += (runner1.val);
			}
			if(runner2 != null){
				sum += (runner2.val);
			}

			sum += carry;
			carry = sum/10;
			sum = sum % 10;	
			if(sumHead == null){
				sumHead = new ListNode(sum);
				sumTail = sumHead;
			}else{
				sumTail.next = new ListNode(sum);
				sumTail = sumTail.next;
			}
			if(runner1 != null){
				runner1 = runner1.next;
			}
			if(runner2 != null){
				runner2 = runner2.next;
			}			
			
		}
		if(carry != 0){
			sumTail.next = new ListNode(carry);
			sumTail = sumTail.next;
		}
		return sumHead;

	}

	public static void main(String args[]){
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(9);
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(9);
		ListNode l3 = add(l1,l2);
		l3.print();

	}
}
