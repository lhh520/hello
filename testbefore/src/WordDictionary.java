import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class WordDictionary {
     class Trie
    {
        private Trie[] children;
        private boolean isEnd;
        public Trie()
        {
            children=new Trie[26];
            isEnd=false;
        }
        private void insert(String word)
        {
            Trie node=this;
            for(int i=0;i<word.length();i++)
            {
                char ch=word.charAt(i);
                int index=ch-'a';
                if(node.children[index]==null)
                    node.children[index]=new Trie();
                node=node.children[index];
            }
            node.isEnd=true;
        }
        public Trie[] getChildren()
        {
            return children;
        }
        public boolean isEnd()
        {
            return isEnd;
        }

    }
    Trie trie;
    public WordDictionary() {
        trie=new Trie();
    }

    public void addWord(String word) {
        trie.insert(word);
    }

    public boolean search(String word) {
       return  dfs(word,0,trie);
    }
    public boolean dfs(String word,int index,Trie node)
    {
        if(index==word.length())
            return node.isEnd;
        char ch=word.charAt(index);
        if(Character.isLetter(ch))
        {
            int ChileIndex=ch-'a';
            Trie child=node.getChildren()[ChileIndex];
            if(child!=null&&dfs(word,index+1,child));
            return true;
        }
        else
        {
            for(int i=0;i<26;i++)
            {
                Trie child=node.getChildren()[i];
                if(child!=null&&dfs(word,index+1,child))
                    return true;
            }
        }
        return false;
    }
}
