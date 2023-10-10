package Tries;

 class TrieNode {
    char data;
    boolean isTerminating;
    TrieNode children[];

    TrieNode(char data){
        this.data = data;
        isTerminating = false;
        children = new TrieNode[26];
    }
}