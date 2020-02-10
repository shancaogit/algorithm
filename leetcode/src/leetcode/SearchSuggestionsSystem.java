package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SearchSuggestionsSystem {

    public static void main(String[] args) {
        String[] products = new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String searchWord = "monei";
        List<List<String>> results = suggestedProducts(products, searchWord);
        for (List<String> result : results) {
            System.out.println(String.join(",", result.toArray(String[]::new)));
        }
    }

    public List<List<String>> suggestedProducts2(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        if (products == null || searchWord == null) {
            return res;
        }

        Arrays.sort(products);
        List<String> proList = Arrays.asList(products);
        TreeMap<String, Integer> proToIndex = new TreeMap<>();
        for (int i = 0; i < products.length; i++) {
            proToIndex.put(products[i], i);
        }

        String key = "";
        for (char c : searchWord.toCharArray()) {
            key = key + c;
            String ceil = proToIndex.ceilingKey(key);
            String floor = proToIndex.floorKey(key + "~");
            if (ceil == null || floor == null) {
                break;
            }

            res.add(proList.subList(proToIndex.get(ceil), Math.min(proToIndex.get(ceil) + 3, proToIndex.get(floor) + 1)));
        }

        while (res.size() < searchWord.length()) {
            res.add(new ArrayList<String>());
        }

        return res;
    }


    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Map<Character, STree> trees = buildSTrees(products);
        List<List<String>> result = new ArrayList<>();
        STree tree = trees.get(searchWord.charAt(0));
        result.add(fetch(tree, ""));
        for (int i = 1; i < searchWord.length(); i++) {
            char c = searchWord.charAt(i);
            if (tree != null && tree.idx.containsKey(c)) {
                tree = tree.children.get(tree.idx.get(c) - 1);
            } else {
                tree = null;
            }
            result.add(fetch(tree, searchWord.substring(0, i)));
        }
        return result;
    }

    private static List<String> fetch(STree tree, String substring) {
        if (tree == null) return new ArrayList<>();
        List<String> results = new ArrayList();
        dps(tree, substring, results);
        return results;
    }

    private static void dps(STree tree, String prefix, List results) {
        if (results.size() == 3) return;

        if (tree.children.isEmpty() || tree.isWorld) {
            results.add(prefix + tree.current);
        }
        for (STree sTree : tree.children) {
            dps(sTree, prefix + tree.current, results);
        }
    }

    private static Map<Character, STree> buildSTrees(String[] products) {
        Map<Character, STree> map = new HashMap<>();
        Arrays.sort(products);
        for (String product : products) {
            char c = product.charAt(0);
            STree tree = map.computeIfAbsent(c, k -> new STree(k, new LinkedList<>(), new LinkedHashMap<>()));
            if (product.length() == 1)
                tree.isWorld = true;
            for (int i = 1; i < product.length(); i++) {
                if (tree.idx.containsKey(product.charAt(i))) {
                    tree = tree.children.get(tree.idx.get(product.charAt(i)) - 1);
                } else {
                    STree newTree = new STree(product.charAt(i), new LinkedList<>(), new LinkedHashMap<>());
                    tree.children.add(newTree);
                    tree.idx.put(product.charAt(i), tree.idx.size() + 1);
                    tree = newTree;
                }
                if (i == product.length() - 1)
                    tree.isWorld = true;
            }
        }
        return map;
    }
}

class STree {
    char current;
    LinkedList<STree> children;
    LinkedHashMap<Character, Integer> idx;
    boolean isWorld;

    public STree(char c, LinkedList<STree> children, LinkedHashMap<Character, Integer> idx) {
        this.current = c;
        this.children = children;
        this.idx = idx;
    }
}