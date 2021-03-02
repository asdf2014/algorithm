public class ListNode<T> {
    T val;
    ListNode next;
    ListNode(T x) { val = x; }

    /**
     * 在当前ListNode this尾部添加一个节点，数值为val
     * @Function add
     * @author   Oh_MyBug
     * @Date     2020/4/4 16:56
     * @param val
     * @return
     */
    public void add(T val){
        ListNode temp = this;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = new ListNode(val);
    }

    public void add(T[] val){
        for (T v : val){
            this.add(v);
        }
    }

    public static void show(ListNode head){
        ListNode p = head.next;
        while (p!=null){
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "com.ohmybug.fifty_3.ListNode{" +
                "val=" + val +
                '}';
    }

    public static void main(String[] args) {
        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader().getParent());
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());
    }
}
