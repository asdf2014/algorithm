import org.junit.Test;

/**
 * ClassName: Solution_295
 * Date:      2020/4/4 22:35
 * author:    Oh_MyBug
 * version:   V1.0
 */
/*
295. 数据流的中位数
中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
例如，
    [2,3,4] 的中位数是 3
    [2,3] 的中位数是 (2 + 3) / 2 = 2.5
设计一个支持以下两种操作的数据结构：
    void addNum(int num) - 从数据流中添加一个整数到数据结构中。
    double findMedian() - 返回目前所有元素的中位数。
示例：
    addNum(1)
    addNum(2)
    findMedian() -> 1.5
    addNum(3)
    findMedian() -> 2
进阶:
    如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
    如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 */
public class Solution_295 {
    @Test
    public void test(){
        MedianFinder finder = new MedianFinder();
        finder.addNum(5);
        finder.addNum(3);
        finder.addNum(7);
        finder.addNum(1);
        finder.show();
        System.out.println(finder.findMedian());
    }

}
/**
 * 链表结构 + 排序
 * @Class:       MedianFinder
 * @author:      Oh_MyBug
 * @Date:        2020/4/4 23:30
 */
class MedianFinder {

    private Node head;
    private int length;
    public MedianFinder() {
        head = new Node();
        length = 0;
    }

    public void addNum(int num) {
        Node p = head;
        Node node = new Node(num);
        boolean isAdd = false;
        while (p.getNext() != null){
            if (p.getNext().getNum() > num){
                node.setNext(p.getNext());
                p.setNext(node);
                isAdd = true;
                break;
            }
            p = p.getNext();
        }
        if (!isAdd){
            p.setNext(node);
        }
        length ++;
    }

    public double findMedian() {
        Node p = head;
        int median1 = 0;
        int median2 = 0;
        for (int i = 0; i <= length/2; i ++){
            p = p.getNext();
            if (i == length/2 - 1){
                median1 = p.getNum();
            }
            if (i == length/2){
                median2 = p.getNum();
            }
        }
        if (length % 2 == 1){
            return median2;
        }else{
            return (median1 + median2)/2.0;
        }
    }
    public void show(){
        Node p = head;
        while (p.getNext() != null){
            p = p.getNext();
            System.out.println(p.getNum());
        }
    }
}
class Node{
    private int num;
    private Node next;

    public Node() {
    }

    public Node(int num) {
        this.num = num;
    }

    public Node getNext() {
        return next;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getNum() {
        return num;
    }
}