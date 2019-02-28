package trees;

public class Trie {
    static class Entry {
        private int uniqueCharsCount = 26;
        private Entry[] child;
        private boolean isEnd;

        public Entry() {
            child = new Entry[uniqueCharsCount];
        }

        public boolean containsKey(char ch) {
            return child[ch - 'a'] != null;
        }

        public Entry get(char ch) {
            return child[ch - 'a'];
        }

        public void put(char ch, Entry entry) {
            child[ch - 'a'] = entry;
        }

        public void setEnd() {
            this.isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }

    private Entry root;

    public Trie() {
        root = new Entry();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Entry currEntry = root;
        for (char ch : word.toCharArray()) {
            if (!currEntry.containsKey(ch)) {
                currEntry.put(ch, new Entry());
            }
            currEntry = currEntry.get(ch);
        }
        currEntry.setEnd();
    }

    private Entry searchPrefix(String word) {
        Entry currEntry = root;
        for (char ch : word.toCharArray()) {
            if (!currEntry.containsKey(ch)) {
                return null;
            } else {
                currEntry = currEntry.get(ch);
            }
        }
        return currEntry;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Entry entry = searchPrefix(word);
        return entry != null && entry.isEnd();
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Entry entry = searchPrefix(prefix);
        return entry != null;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true
    }
}
