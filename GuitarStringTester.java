/*****************************************************************************

 *  Plays two guitar strings (concert A and concert C) when the user
 *  types the lowercase letters 'a' and 'c', respectively in the 
 *  standard drawing window.
 *
 ***************************************************************************/
package Guitar_Hero;
//I'm Thanh, partners with Andre


import java.util.*;

public class GuitarStringTester implements Runnable {
	private  GuitarString[] notes;
	private  String Keyboard ; 
	private String chord;
	private int index;
	
	public GuitarStringTester() {
		
		Keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
		chord = "";
		index = 0;
		notes = new GuitarString[37];
        for (int i=0;i<notes.length;i++) {
        	notes[i] = new GuitarString(440*Math.pow(1.05956,i-24));
        }
	}

    public static void main(String[] args) 
    {
        GuitarStringTester  a = new GuitarStringTester();
        a.runMain();
    }
    
    public void runMain() {
    	
        notes = new GuitarString[37];
        for (int i=0;i<notes.length;i++) {
        	notes[i] = new GuitarString(440*Math.pow(1.05956,i-24));
        } 
        Scanner kb = new Scanner( System.in );
        // the user types this character
        char key = kb.next().charAt(0);
        playNotes(key);
        
    }
		private  void plucker(int i) {
			notes[i].pluck();
        	 for (int c=0;c<44100;c++) {
             	double sample = notes[i].sample();
             	StdAudio.play(sample);
             	notes[i].tic();
             }
		}
		
		public void playNotes(char key) {
			plucker(Keyboard.indexOf(key));
			
		}
		
}
