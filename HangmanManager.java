import java.util.*;

public class HangmanManager
{
	private int guesses;
	private Set<String> wordPool = new TreeSet<String>();
	private Set<Character> guessed = new TreeSet<Character>();
	private String pattern;
	public HangmanManager( List<String> dictionary, int length, int max )
	{
	
	guesses = max;
	//adds strings of proper length to the pool
	for(String t: dictionary) {
		if(t.length() == length) {
			wordPool.add(t);
		}
	}
	//sets up the pattern
	for(int i = 0; i < length; i++) {
		pattern += "-";
	}
	guessed = new TreeSet<>();
	}
	
	public Set<String> words()
	{
		return wordPool;
	}	
	
	public int guessesLeft()
	{
		return guesses;
	}
		
	public Set<Character> guesses()
	{
		return guessed;
	}
	
	public String pattern()
	{
		
		return pattern;
	}
	
	//changes pattern for each guess - this will alow us to create families of words for each guess
	public String createPattern(char guess, String w) {
		String p = "";
		
		for(int i = 0; i < w.length(); i++) {
			if(w.charAt(i) != guess) {
				p += p.substring(i,i+1);
			}
			else {
				
			}
		}
		
		return p;
	}
	//needs to be the main decision driver of the program - writes down that 
	//the character has been recorded and choose the word family that the 
	//evil hangman will continue to use
	
	public int record( char guess )
	{
		guessed.add(guess);
		
		Map<String, Set<String>> family = new TreeMap<>();
		for(String word: wordPool) {
			String p = createPattern(guess, word);
			Set<String> matches = new TreeSet<>();
			if(!family.containsKey(p)) {
				family.put(p, matches);
			}
			family.get(p).add(word);
		}
		//changes the wordpool so you only draw from the largest one
		int max = 0;
		if (!family.isEmpty()) {
			for (String key : family.keySet()) {
				if (family.get(key).size() > max) {
					for(String t: wordPool) {
						wordPool.remove(t);
					}
					for(String a : family.get(key)) {
						wordPool.add(a);
					}
					pattern = key;
					max = family.get(key).size();
					}
				}
			}
		return choose(guess);

	}
	public int choose(char guess) {
		int max = 0;
		
		for (int i = 0; i < pattern.length(); i++) {
			
			if (pattern.charAt(i) == guess) max++;
			
		}
		
		guessed.add(guess);
		
		if (max == 0) guesses--;
		
		return max;
	}
}