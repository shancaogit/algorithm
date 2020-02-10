package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class ReorderDataInlnLogs {

    public static void main(String args[]) {
        String[] logs = new String[]{"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};
        reorderLogFiles(logs);
    }

    public static String[] reorderLogFiles(String[] logs) {
        Node[] nodes = Stream.of(logs)
                .filter(log -> startWithLetter(log))
                .map(log -> new Node(log.substring(0, log.indexOf(" ")), log.substring(log.indexOf(" ") + 1)))
                .toArray(Node[]::new);
        Arrays.sort(nodes, Comparator.comparing(Node::getPrefix).thenComparing(Node::getRest));
        int j = 0;
        String[] result = new String[logs.length];
        for (int i = 0; i < nodes.length; i++) {
            result[j++] = nodes[i].prefix + " " + nodes[i].rest;
        }
        for (int i = 0; i < logs.length; i++) {
            if (!startWithLetter(logs[i])) {
                result[j++] = logs[i];
            }
        }
        return result;
    }

    static boolean startWithLetter(String log) {
        char c = log.charAt(log.indexOf(" ") + 1);
        return c >= 'a' && c <= 'z';
    }

    static class Node  {
        String prefix;
        String rest;

        public String getPrefix() {
            return prefix;
        }

        public void setPrefix(String prefix) {
            this.prefix = prefix;
        }

        public String getRest() {
            return rest;
        }

        public void setRest(String rest) {
            this.rest = rest;
        }

        public Node(String prefix, String rest) {
            this.prefix = prefix;
            this.rest = rest;
        }
    }

}
