import java.util.*;

class Node {
	public char w;
	public Hashtable<Character, Node> children;
	public boolean isEnd;
	Node(char w) {
		this.w = w;
		this.children = new Hashtable<Character, Node>();
		this.isEnd = false;
	}
}
public class Trie {
	public Node root;
	public Trie() {
		root = new Node('*');
	}
	public void insert(String word, Stack<Suffix> suffixes) {
		Node cur=this.root;
		int len = word.length();
		for(int i=0; i<len; i++) {
			char c = word.charAt(i);
			if(!cur.children.containsKey(c)) {
				cur.children.put(c, new Node(c));
			}
			cur = cur.children.get(c);
			if(cur.isEnd && i+1<len) {
//				System.out.println(word+"-:"+i+", "+cur.w);
				suffixes.push(new Suffix(word, word.substring(i+1)));
			}
		}
		cur.isEnd = true;
	}
	public boolean search(Suffix coup, Stack<Suffix> suffixes, ArrayList<String> concatWords) {
		String str = coup.sub;
		Node cur=this.root;
		int len = str.length();
		for(int i=0; i<len; i++) {
			char c = str.charAt(i);
			if(!cur.children.containsKey(c)) {
				return false;
			}
			cur = cur.children.get(c);
			if(cur.isEnd  && i+1<len) {
				suffixes.push(new Suffix(coup.org, str.substring(i+1)));
			}
		}
		if(cur.isEnd) {
			concatWords.add(coup.org);
			while(suffixes.peek().org.equals(coup.org)) {
				suffixes.pop();
			}
			return true;
		}
		return false;
	}
}
