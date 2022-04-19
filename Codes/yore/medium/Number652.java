package com.yore.medium;

import com.yore.base.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Yore
 * @date 2021/11/16 10:07
 * @description
 */
public class Number652 {
    private Map<String,Integer> map = new HashMap<>();
    private List<TreeNode> res = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        transe(root);
        return res;
    }

    public String transe(TreeNode node){
        if(node == null){
            return "#";
        }

        String left = transe(node.left);
        String right = transe(node.right);

        String subTree = left + "," + right+ "," + node.val;

        int freq = map.getOrDefault(subTree,0);
        if(freq == 1){
            res.add(node);
        }
        map.put(subTree,freq+1);
        return subTree;
    }
}
