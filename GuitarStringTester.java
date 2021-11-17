/*****************************************************************************

 *  Plays two guitar strings (concert A and concert C) when the user
 *  types the lowercase letters 'a' and 'c', respectively in the 
 *  standard drawing window.
 *
 ***************************************************************************/
package Guitar_Hero;

import java.util.*;

public class GuitarStringTester {
	private  GuitarString[] notes;
	private  String Keyboard ; 
	
	public GuitarStringTester() {
		
		Keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
		notes = new GuitarString[37];
        for (int i=0;i<notes.length;i++) {
        	notes[i] = new GuitarString(440*Math.pow(1.05956,i-24));
        }
	}

    public static void main(String[] args) 
    {
        GuitarStringTester  a = new GuitarStringTester();
        a.run();
    }
    
    public void run() {
    	
        notes = new GuitarString[37];
        for (int i=0;i<notes.length;i++) {
        	notes[i] = new GuitarString(440*Math.pow(1.05956,i-24));
        }
        

        final double TEXT_POS_X = .2;
        final double TEXT_POS_Y = .5;
                
        Scanner kb = new Scanner( System.in );
 
        // the user types this character
        char key = kb.nextLine().charAt(0);
        playNotes(key);
        
    }
	

		private  void plucker(int i) {
			notes[i].pluck();
        	 for (int c=0;c<44100;c++) {
             	double sample = notes[i].sample() ;
             	StdAudio.play(sample);
             	notes[i].tic();
             }
		}
		
		public  void playNotes(char key) {
			plucker(Keyboard.indexOf(key));
		}
}
