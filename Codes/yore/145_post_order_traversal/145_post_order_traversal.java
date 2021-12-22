public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    postOrderRecursion(root, list);
    return list;
}

public void postOrderRecursion(TreeNode node, List<Integer> list) {
    if (node != null) {
        postOrderRecursion(node.left, list);
        postOrderRecursion(node.right, list);
        list.add(node.val);
    }
}