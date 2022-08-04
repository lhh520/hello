package testproject;

public class 词典中最长的单词 {
    public String longestWord(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        String longest = "";
        for (String word : words) {
            if (trie.search(word)) {
                if (word.length() > longest.length() || (word.length() == longest.length() && word.compareTo(longest) < 0)) {
                    longest = word;
                }
            }
        }
        return longest;
    }
    class Trie{
        private Trie[]children;
        private boolean isEnd;
        public Trie(){
            children=new Trie[26];
            isEnd=false;
        }
        public void insert(String word){
            Trie node=this;
            for(int i=0;i<word.length();i++){
                char cc=word.charAt(i);
                int index=cc-'a';
                if(node.children[index]==null){
                    node.children[index]=new Trie();
                }
                node=node.children[index];
            }
            node.isEnd=true;
        }
        public boolean search(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                int index = ch - 'a';
                //如果不存在当前的值 并且 当前的值
                if (node.children[index] == null || !node.children[index].isEnd) {
                    return false;
                }
                node = node.children[index];
            }
            return node != null && node.isEnd;
        }
        public boolean startsWith(String prefix) {
            return searchPrefix(prefix)!=null;
        }
        private Trie searchPrefix(String prefix){
            Trie node=this;
            for(int i=0;i<prefix.length();i++){
                char ch=prefix.charAt(i);
                int index=ch-'a';
                if(node.children[index]==null){
                    return null;
                }
                node=node.children[index];
            }
            return node;
        }
    }
}
