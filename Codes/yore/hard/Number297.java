package com.yore.hard;

import com.yore.base.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Yore
 * @date 2022/5/11 15:35
 * @description
 */
public class Number297 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return reSerialize(root, new StringBuilder(""));
    }

    public String reSerialize(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null,");
        } else {
            sb.append(node.val + ",");
            reSerialize(node.left, sb);
            reSerialize(node.right, sb);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> list = new LinkedList<>(Arrays.asList(data.split(",")));
        return reDeserialize(list);
    }

    public TreeNode reDeserialize(List<String> list) {
        if (list.size() == 0) {
            return null;
        }
        if (list.get(0).equals("null")) {
            list.remove(0);
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        node.left = reDeserialize(list);
        node.right = reDeserialize(list);
        return node;
    }
}
