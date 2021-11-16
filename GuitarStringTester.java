/*****************************************************************************

 *  Plays two guitar strings (concert A and concert C) when the user
 *  types the lowercase letters 'a' and 'c', respectively in the 
 *  standard drawing window.
 *
 ***************************************************************************/
package Guitar_Hero;

import java.util.*;

public class GuitarStringTester {
	static GuitarString[] notes;

    public static void main(String[] args) 
    {

        // Create two guitar strings, for concert A and C
        double CONCERT_A0 = 440*Math.pow(1.05956,-24);
        
        notes = new GuitarString[37];
        for (int i=0;i<notes.length;i++) {
        	notes[i] = new GuitarString(440*Math.pow(1.05956,i-24));
        }
        

        final double TEXT_POS_X = .2;
        final double TEXT_POS_Y = .5;
                
        Scanner kb = new Scanner( System.in );
 
        // the user types this character
        char key = kb.next().charAt(0);
        if (key == 'q') {
        	plucker(0);
        }
        if (key == '2') {
        	plucker(1);
        }
        if (key == 'w') {
        	plucker(2);
        }
        if (key == 'e') {
        	plucker(3);
        }
        if (key == '4') {
        	plucker(4);
        }
        if (key == 'r') {
        	plucker(5);
        }
        if (key == '5') {
        	plucker(6);
        }
        if (key == 't') {
        	plucker(7);
        }
        if (key == 'y') {
        	plucker(8);
        }
        if (key == '7') {
        	plucker(9);
        }
        if (key == 'u') {
        	plucker(10);
        }
        if (key == '8') {
        	plucker(11);
        }
        if (key == 'i') {
        	plucker(12);
        }
        if (key == '9') {
        	plucker(13);
        }
        if (key == 'o') {
        	plucker(14);
        }
        if (key == 'p') {
        	plucker(15);
        }
        if (key == '-') {
        	plucker(16);
        }
        if (key == '[') {
        	plucker(17);
        }
        if (key == '=') {
        	plucker(18);
        }
        if (key == 'z') {
        	plucker(19);
        }
        if (key == 'x') {
        	plucker(20);
        }
        if (key == 'd') {
        	plucker(21);
        }
        if (key == 'c') {
        	plucker(22);
        }
        if (key == 'f') {
        	plucker(23);
        }
        if (key == 'v') {
        	plucker(24);
        }
        if (key == 'g') {
        	plucker(25);
        }
        if (key == 'b') {
        	plucker(26);
        }
        if (key == 'n') {
        	plucker(27);
        }
        if (key == 'j') {
        	plucker(28);
        }
        if (key == 'm') {
        	plucker(29);
        }
        if (key == 'k') {
        	plucker(30);
        }
        if (key == ',') {
        	plucker(31);
        }
        if (key == '.') {
        	plucker(32);
        }
        if (key == ';') {
        	plucker(33);
        }
        if (key == '/') {
        	plucker(34);
        }
        if (key == '\'') {
        	plucker(35);
        }
        if (key == ' ') {
        	plucker(36);
        }
        // pluck the corresponding string        
        // compute the superposition of the samples

        // send the result to standard audio
        

        // advance the simulation of each guitar string by one step
    }
	

		private static void plucker(int i) {
			notes[i].pluck();
        	 for (int c=0;c<44100;c++) {
             	double sample = notes[i].sample() ;
             	StdAudio.play(sample);
             	notes[i].tic();
             }
		}
}
