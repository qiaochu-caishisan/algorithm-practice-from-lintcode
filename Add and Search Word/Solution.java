class TrieNode{
    public TrieNode[] children;
    public boolean end;
    public  TrieNode(){
        children = new TrieNode[26];
        end = false;
    }
    
    public void insert(String word, int index){
        if(index == word.length()){
            this.end = true;
            return;
        }
        int pos = word.charAt(index) - 'a';
        if(this.children[pos] == null){
            this.children[pos] = new TrieNode();
        }
        children[pos].insert(word, index+1);
    }
}

public class WordDictionary {
    TrieNode root = new TrieNode();
    // Adds a word into the data structure.
    public void addWord(String word) {
        // Write your code here
        root.insert(word, 0);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        // Write your code here
        return find(word, 0, root);
      
    }
    public boolean find(String word, int index, TrieNode curr){
        if(index == word.length()){
            if(curr.end == true){
                return true;
            }else{
                return false;
            }
        }
            if(word.charAt(index) == '.'){
                for(int i = 0; i < 26; i++){
                    if(curr.children[i] != null){
                        if(find(word, index+1, curr.children[i])){
                            return true;
                        }
                    }
                }
                return false;
            }else{
            int pos = word.charAt(index) - 'a';
            if(curr.children[pos] == null){
                return false;
            }
            return find(word, index+1, curr.children[pos]);
        }
    }    
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
