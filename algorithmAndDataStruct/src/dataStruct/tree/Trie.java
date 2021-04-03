package dataStruct.tree;
/*
 * 	字典数算法
 */
public class Trie {

    private static class Node {
        Node[] next = new Node[26];
        int count = 0;

    }

    private static class Tree {
        Node root = new Node();

        public void add(String string) {
            Node current = root;
            for (int i = 0; i < string.length(); i++) {
                int index = string.charAt(i) - 65;
                if (current.next[index] == null) {
                    current.next[index] = new Node();
                    current.next[index].count = 1;
                } else {
                    current.next[index].count += 1;
                }
                current = current.next[index];
            }
        }

        public int getCount(String string) {
            Node current = root;

            int k = 0;
            while (k < string.length()) {
                if (current.next[string.charAt(k) - 65] == null) break;

                current = current.next[string.charAt(k) - 65];
            }
            if (k < string.length()) {
                return 0;
            } else {
                return current.count;
            }
        }

        public void delete(String string) {
            if (string == null || string.length() == 0) {
                return;
            }
            if (!contains(string)) {
                return;
            }
            Node current = root;
            int k = 0;

            while (k < string.length()) {
                if (current.next[string.charAt(k) - 65] == null) break;

                current = current.next[string.charAt(k) - 65];
                current.count--;
            }


        }

        public boolean contains(String string) {

            if (string == null || string.length() == 0) {
                return false;
            }
            Node current = root;

            int k = 0;

            while (k < string.length()) {
                if (current.next[string.charAt(k) - 65] == null) break;

                current = current.next[string.charAt(k) - 65];
            }

            if (k == string.length()) {
                return true;
            } else {
                return false;
            }

        }

        public int find(String string) {
            if (string == null || string.length() == 0) {
                return 0;
            }
            Node current = root;
            int k = 0;
            while (k < string.length()) {
                if (current.next[string.charAt(k) - 65] == null) {
                    return 0;
                }
                current = current.next[string.charAt(k) - 65];

            }

            return current.count;

        }

        public int search_complete(String string) {
            int sum = find(string);
            int count = 0;
            for (int i = 0; i < 26; i++) {
                count += find(string + (char) ('A' + i));
            }

            return sum - count;
        }

    }

}
