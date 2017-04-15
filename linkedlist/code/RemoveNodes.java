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

public class RemoveNodes{

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if(head == null || n <= 0){
			return head;
		}
		ListNode slowRunner, fastRunner;
		slowRunner = head;
		fastRunner = slowRunner;
		int counter = n;
		while(counter > 0 && fastRunner != null){
			fastRunner = fastRunner.next;
			counter--;
		}
		if(fastRunner == null){
			if(counter == 0){ 
				return head = head.next;
			}
			else { 
				System.out.println("The value of n exceeds the length of the linked list");
				return head; 
			}
		}
		while(fastRunner.next != null){
			slowRunner = slowRunner.next;
			fastRunner = fastRunner.next;
		}
		slowRunner.next = slowRunner.next.next;
		return head;
	}
	public static void main(String[] args){
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(3);
		l1.next.next.next = new ListNode(4);
		l1.next.next.next.next = new ListNode(5);
		ListNode l2 = removeNthFromEnd(l1,6);
		l2.print();
	}
}
