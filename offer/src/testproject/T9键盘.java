package testproject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T9键盘 {
    public List<String> getValidT9Words(String num, String[] words){
        Trie trie=new Trie();
        for(String word:words){
            trie.insert(word);
        }
        List<String>res=new ArrayList<>();
        for(String word:words){
            if(trie.search(word,num)){
                res.add(word);
            }
        }
        return res;
    }
    class TrieNode{
        TrieNode[]son=new TrieNode[26];
        boolean isEnd;
        char val;
    }
    class Trie{
        TrieNode root;
        Map<Character,Character>map=new HashMap<>();//存放字母
        public Trie(){
            root = new TrieNode();
            map.put('!', '1');
            map.put('@', '1');
            map.put('#', '1');
            map.put('a', '2');
            map.put('b', '2');
            map.put('c', '2');
            map.put('d', '3');
            map.put('e', '3');
            map.put('f', '3');
            map.put('g', '4');
            map.put('h', '4');
            map.put('i', '4');
            map.put('j', '5');
            map.put('k', '5');
            map.put('l', '5');
            map.put('m', '6');
            map.put('n', '6');
            map.put('o', '6');
            map.put('p', '7');
            map.put('q', '7');
            map.put('r', '7');
            map.put('s', '7');
            map.put('t', '8');
            map.put('u', '8');
            map.put('v', '8');
            map.put('w', '9');
            map.put('x', '9');
            map.put('y', '9');
            map.put('z', '9');
            map.put('+', '*');
            map.put('_', '0');
            map.put('↑', '#');
        }
        public void insert(String word){
            TrieNode cur=root;
            for(char c:word.toCharArray()){
                int cNum=c-'a';
                if(cur.son[cNum]==null){
                    cur.son[cNum]=new TrieNode();
                }
                cur.son[cNum].val=map.get(c);//表示有下一个数据
                cur=cur.son[cNum];
            }
            cur.isEnd=true;
        }
        public boolean search(String word, String num){
            TrieNode cur=root;
            int numIndex=0;
            for(char c:word.toCharArray()){
                int cNum=c-'a';
                if(cur.son[cNum]==null||cur.son[cNum].val!=num.charAt(numIndex)){
                    return false;
                }
                numIndex++;
                cur=cur.son[cNum];
            }
            return cur.isEnd;
        }
    }
}
