import java.io.*;
import java.util.*;


public class LongestWord {
	private static ArrayList<String> words = new ArrayList<String>();
	private static Trie trie = new Trie();
	public static Stack<Suffix> suffixes = new Stack<Suffix>();
	public static ArrayList<String> concatWords = new ArrayList<String>();
	public static String findLongestWord() {
		Collections.sort(words, new lengthComp());
		for(String word : words) {
			trie.insert(word, suffixes);
		}
		String longest="";
		while(!suffixes.isEmpty()) {
			trie.search(suffixes.pop(), suffixes, concatWords);
		}
		return longest;
	}
	
	public static void buildWordsArray(String inputfile) {
		File fp = new File(inputfile);
		InputStreamReader inputReader = null;
		BufferedReader inputBuff = null;
		String word = null;
		try{
			inputReader = new InputStreamReader(new FileInputStream(fp));
			inputBuff = new BufferedReader(inputReader);
			word = inputBuff.readLine();
			while(word!=null) {
				if(word.length()!=0) {
					words.add(word);
				}
				word = inputBuff.readLine();
			}
			inputBuff.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		String inputfile = (args==null||args.length<1) ? "wordsforproblem.txt" : args[0];
		buildWordsArray(inputfile);
		findLongestWord();
		System.out.println("--------------------- Answer ----------------------");
		System.out.println("1. the 1st longest word is: "+concatWords.get(0));
		System.out.println("2. the 2nd longest word is: "+concatWords.get(1));
		System.out.println("3. There are totally "+concatWords.size()+" words that can be constructed of other words in the list.");
	}
}
