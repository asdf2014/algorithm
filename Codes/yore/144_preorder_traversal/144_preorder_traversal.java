public List<Integer> preorderTraversal(TreeNode root) {
   List<Integer> result = new ArrayList<>();
    TreeNode node = root;
    Stack<TreeNode> st = new Stack<>();
    while (!st.empty() || node != null) {
        while(node!=null){
            st.push(node);
            result.add(node.val);
            node = node.left;
        }
        node = st.pop();
        node = node.right;
    }
    return result;
}