package com.yore.offer2;

import java.util.*;

/**
 * @author Yore
 * @date 2022/3/21 8:56
 * @description
 */
public class Offer114 {
    public static void main(String[] args) {
        Offer114 o = new Offer114();
        System.out.println(o.alienOrder(new String[]{"z", "z"}));
    }

    public String alienOrder(String[] words) {
        Graph gp = new Graph();
        for (String str : words) {
            for (char ch : str.toCharArray()) {
                gp.nodes.put(ch, new Node(ch));
            }
        }
        for (int i = 1; i < words.length; i++) {
            String str1 = words[i - 1];
            String str2 = words[i];
            if (checkPre(str1, str2) && !str1.equals(str2)) {
                return "";
            }
            int left = 0;
            while (left < str1.length() && left < str2.length()) {
                if (str1.charAt(left) != str2.charAt(left)) {
                    Node n1 = gp.nodes.get(str1.charAt(left));
                    Node n2 = gp.nodes.get(str2.charAt(left));
                    n2.in += 1;
                    n1.nexts.add(n2);
                    break;
                }
                left++;
            }
        }
        Map<Character, Integer> inMap = new HashMap<>();
        Deque<Character> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder("");
        for (Character key : gp.nodes.keySet()) {
            int in = gp.nodes.get(key).in;
            inMap.put(key, in);
            if (in == 0) {
                queue.offerLast(key);
            }
        }
        while (!queue.isEmpty()) {
            char ch = queue.pollFirst();
            sb.append(ch);
            for (Node node : gp.nodes.get(ch).nexts) {
                inMap.put(node.ch, inMap.get(node.ch) - 1);
                if (inMap.get(node.ch) == 0) {
                    queue.offerLast(node.ch);
                }
            }
        }
        return sb.length() == gp.nodes.size() ? sb.toString() : "";
    }

    public boolean checkPre(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        if (m < n) {
            return false;
        }
        int i = 0;
        while (i < m && i < n) {
            if (s2.charAt(i) != s1.charAt(i)) {
                return false;
            }
            i++;
        }
        return true;
    }

    class Node {
        char ch;
        int in;
        int out;
        List<Node> nexts;

        public Node(char c) {
            this.ch = c;
            this.in = 0;
            this.out = 0;
            this.nexts = new ArrayList<>();
        }
    }

    class Graph {
        Map<Character, Node> nodes;

        public Graph() {
            this.nodes = new HashMap<>();
        }
    }
}
