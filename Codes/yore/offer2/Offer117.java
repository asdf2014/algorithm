package com.yore.offer2;

import java.util.*;

/**
 * @author Yore
 * @date 2022/3/22 8:15
 * @description
 */
public class Offer117 {
    public static void main(String[] args) {
        Offer117 o = new Offer117();
        System.out.println(o.numSimilarGroups(new String[]{"ufixvnxsdxalinayfaappbmmj", "nxpxiaauvyjxasbfmfinmdpla", "ujimiyxsaxpavnanfapmlbxdf", "ufimvyxsaxpainanfapdlbxmj", "nxpyajaumxixalbfvpdnmasfi", "nxpxiaauvyjxpsbfmfinmdala", "ufimvyxspxaainanfapdlbxmj", "nxpyaiaumxjxapbfvlanmdsfi", "ufimvyxspxapinanfaadlbxmj", "nxpyaaauvxjxasbfmfinmdpli", "nxpyajaumxixapbfvlanmdsfi", "nxpyaaaumxjxasbfvfinmdpli", "ufixvnbsdxalinayfamppxamj", "ujimvyxsaxpainanfapdlbxmf", "ufixvyxsdxalinanfaappbmmj", "nxpyaaaumxjxapbfvlinmdsfi", "ufixvyxspxalinanfaadpbmmj", "nxpyaaaumxjxasbfvlinmdpfi", "ufixvyxspxapinanfaadlbmmj", "ufixvnbsdxalinayfaappxmmj", "ufiavnbsdxxlinayfamppxamj", "nxpyajaumxixapbfvldnmasfi", "ufiavnbsdxxlinayfamppxajm", "nxpyiaauvxjxasbfmfinmdpla", "ujimiyxsaxpavnanfapdlbxmf"}));
//        System.out.println(o.numSimilarGroups(new String[]{"nmiwx","mniwx","wminx","mnixw","xnmwi"}));
    }

    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        UnionSet unionSet = new UnionSet(strs);
        List<Integer> idxList = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            String s1 = strs[i];
            for (int j = i + 1; j < n; j++) {
                String s2 = strs[j];
                if (s1.equals(s2)) {
                    unionSet.union(s1, s2);
                    continue;
                }
                int idx = 0;
                idxList = new ArrayList<>();
                while (idx < s1.length()) {
                    if (s1.charAt(idx) != s2.charAt(idx)) {
                        idxList.add(idx);
                        if (idxList.size() > 2) {
                            break;
                        }
                    }
                    idx++;
                }
                if (idxList.size() == 2 && s1.charAt(idxList.get(0)) == s2.charAt(idxList.get(1))
                        && s1.charAt(idxList.get(1)) == s2.charAt(idxList.get(0))) {
                    unionSet.union(s1, s2);
                }
            }
        }
        return unionSet.sizeMap.size();
    }

    class Node {
        String val;

        public Node(String value) {
            this.val = value;
        }
    }

    class UnionSet {
        private Map<String, Node> nodes;
        private Map<Node, Node> parents;
        private Map<Node, Integer> sizeMap;

        public UnionSet(String[] strs) {
            this.nodes = new HashMap<>();
            this.parents = new HashMap<>();
            this.sizeMap = new HashMap<>();
            for (String str : strs) {
                if(!nodes.containsKey(str)){
                    Node node = new Node(str);
                    this.nodes.put(str, node);
                    this.parents.put(node, node);
                    this.sizeMap.put(node, 1);
                }
            }
        }

        public boolean isSameSet(String s1, String s2) {
            if (!nodes.containsKey(s1) || !nodes.containsKey(s2)) {
                return false;
            }
            return findFather(nodes.get(s1)) == findFather(nodes.get(s2));
        }


        public Node findFather(Node n1) {
            Deque<Node> queue = new LinkedList<>();
            while (n1 != parents.get(n1)) {
                queue.offerLast(n1);
                n1 = parents.get(n1);
            }
            while (!queue.isEmpty()) {
                parents.put(queue.pollLast(), n1);
            }
            return n1;
        }

        public void union(String s1, String s2) {
            Node p1 = findFather(nodes.get(s1));
            Node p2 = findFather(nodes.get(s2));
            if (p1 != p2) {
                int aSize = sizeMap.get(p1);
                int bSize = sizeMap.get(p2);
                Node bigNode = aSize > bSize ? p1 : p2;
                Node smallNode = bigNode == p1 ? p2 : p1;
                parents.put(smallNode, bigNode);
                sizeMap.put(bigNode, aSize + bSize);
                sizeMap.remove(smallNode);
            }
        }
    }
}
