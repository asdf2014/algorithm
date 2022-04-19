package com.yore.offer2;

import java.util.*;

/**
 * @author Yore
 * @date 2022/2/23 17:16
 * @description
 */
public class Offer111 {

    Map<String, Entity> map = new HashMap<>();

    public static void main(String[] args) {
        Offer111 o = new Offer111();
        List<List<String>> equations = new ArrayList<>();
        equations.add(new ArrayList<String>() {
            {
                add("a");
                add("b");
            }
        });
        equations.add(new ArrayList<String>() {
            {
                add("b");
                add("c");
            }
        });

        double[] values = new double[]{2.0, 3.0};
        List<List<String>> queries = new ArrayList<>();
        queries.add(new ArrayList<String>() {
            {
                add("a");
                add("c");
            }
        });
        queries.add(new ArrayList<String>() {
            {
                add("b");
                add("a");
            }
        });
        queries.add(new ArrayList<String>() {
            {
                add("a");
                add("e");
            }
        });
        queries.add(new ArrayList<String>() {
            {
                add("a");
                add("a");
            }
        });
        queries.add(new ArrayList<String>() {
            {
                add("x");
                add("x");
            }
        });
        System.out.println(o.calcEquation(equations, values, queries));
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        map = initMap(equations, values);
        int n = queries.size();
        double[] result = new double[n];
        for (int i = 0; i < n; i++) {
            String v1 = queries.get(i).get(0);
            String v2 = queries.get(i).get(1);
            if (!map.containsKey(v1) || !map.containsKey(v2)) {
                result[i] = -1.0;
                continue;
            }
            result[i] = process(v1, v2, new HashSet<String>(), 1.0);
        }
        return result;
    }

    public double process(String v1, String v2, Set<String> visit, double multi) {
        if (v1.equals(v2)) {
            return 1.0;
        }
        Entity ent = map.get(v1);
        visit.add(v1);
        double res = -1.0;
        int idx = 0;
        for (String div : ent.div) {
            if (div.equals(v2)) {
                res = multi * ent.val.get(idx);
                break;
            }
            if (!visit.contains(div)) {
                visit.add(div);
                res = process(div, v2, visit, multi * ent.val.get(idx));
                if (res != -1.0) {
                    return res;
                }
                visit.remove(div);
            }
            idx++;
        }
        return res;
    }

    public Map<String, Entity> initMap(List<List<String>> equations, double[] values) {
        Map<String, Entity> map = new HashMap<>();
        int idx = 0;
        for (List<String> list : equations) {
            String v1 = list.get(0);
            String v2 = list.get(1);
            if (map.containsKey(v1)) {
                map.get(v1).addEle(v2, values[idx]);
            } else {
                map.put(v1, new Entity().addEle(v2, values[idx]));
            }
            if (map.containsKey(v2)) {
                map.get(v2).addEle(v1, 1.0 / values[idx]);
            } else {
                map.put(v2, new Entity().addEle(v1, 1.0 / values[idx]));
            }
            idx++;
        }
        return map;
    }

    class Entity {
        List<String> div;
        List<Double> val;

        public Entity() {
            this.div = new ArrayList<>();
            this.val = new ArrayList<>();
        }

        public Entity addEle(String div, double val) {
            this.div.add(div);
            this.val.add(val);
            return this;
        }
    }
}
