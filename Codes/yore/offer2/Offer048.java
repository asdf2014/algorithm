package com.yore.offer2;

import com.yore.base.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Yore
 * @date 2022/3/2 9:28
 * @description
 */
public class Offer048 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return preSerialize(root, "");
    }

    public String preSerialize(TreeNode node, String str) {
        if (node == null) {
            str += "null,";
            return str;
        }
        str += String.valueOf(node.val + ",");
        str = preSerialize(node.left, str);
        str = preSerialize(node.right, str);
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strArr = data.split(",");
        List<String> dataList = new LinkedList<>(Arrays.asList(strArr));
        return preDeserialize(dataList);
    }

    public TreeNode preDeserialize(List<String> dataList) {
        if (dataList.size() == 0) {
            return null;
        }
        if (dataList.get(0).equals("null")) {
            dataList.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(dataList.get(0)));
        dataList.remove(0);
        root.left = preDeserialize(dataList);
        root.right = preDeserialize(dataList);
        return root;
    }
}
