
public class Guess {
	private int[] guesses;
	private boolean followedRule;
	
	public Guess(int[] x, boolean y){
		guesses = x;
		followedRule = y;
	}
	
	public int[] getGuesses(){
		return guesses;
	}
	
	public boolean getFollowedRule(){
		return followedRule;
	}
	
	public boolean checkRule() {
		if(guesses[0]*guesses[0] == guesses[1] && guesses[1]*guesses[1] == guesses[2]){
			followedRule = true;
			return true;
		} else
			return false;
	}
	
	public String toText(){
		if(followedRule){
			return("[" + guesses[0] + " " + guesses[1] + " " + guesses[2] + "] this guess followed the rule.");
		} else {
			return("[" + guesses[0] + " " + guesses[1] + " " + guesses[2] + "] this guess did not follow the rule.");
		}
		
	}
}
