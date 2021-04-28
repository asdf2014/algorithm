public boolean isSameTree(TreeNode p, TreeNode q) {
    Queue<TreeNode> queue = new LinkedList<>();
    TreeNode t1, t2;
    queue.offer(p);
    queue.offer(q);
    while (queue.size() > 0) {
        t1 = queue.poll();
        t2 = queue.poll();
        if (t1 == null && t2 == null) {
            if (queue.size() == 0) {
                return true;
            }
            continue;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        if (t1.val != t2.val) {
            return false;
        }
        queue.offer(t1.left);
        queue.offer(t2.left);
        queue.offer(t1.right);
        queue.offer(t2.right);
    }
    return true;
}