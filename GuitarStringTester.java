/*****************************************************************************

 *  Plays two guitar strings (concert A and concert C) when the user
 *  types the lowercase letters 'a' and 'c', respectively in the 
 *  standard drawing window.
 *
 ***************************************************************************/
package Guitar_Hero;

import java.util.*;

public class GuitarStringTester {

    public static void main(String[] args) 
    {

        // Create two guitar strings, for concert A and C
        double CONCERT_A0 = 440*Math.pow(1.05956,-24);
        
        GuitarString[] notes = new GuitarString[37];
        for (int i=0;i<notes.length;i++) {
        	notes[i] = new GuitarString(440*Math.pow(1.05956,i-24));
        }
        

        final double TEXT_POS_X = .2;
        final double TEXT_POS_Y = .5;
                
        Scanner kb = new Scanner( System.in );
 
        // the user types this character
        char key = kb.next().charAt(0);

        // pluck the corresponding string
        if (key == 'q')  {
        	 notes[0].pluck();
        	 for (int i=0;i<44100;i++) {
             	double sample = notes[0].sample() ;
             	StdAudio.play(sample);
             	notes[0].tic();
             }
        }
        if (key == '2')  {
       	 notes[1].pluck();
       	 for (int i=0;i<44100;i++) {
            	double sample = notes[1].sample() ;
            	StdAudio.play(sample);
            	notes[1].tic();
            }
       }
        if (key == 'w')  {
          	 notes[2].pluck();
          	 for (int i=0;i<44100;i++) {
               	double sample = notes[2].sample() ;
               	StdAudio.play(sample);
               	notes[2].tic();
               }
          }
        if (key == 'e')  {
          	 notes[3].pluck();
          	 for (int i=0;i<44100;i++) {
               	double sample = notes[3].sample() ;
               	StdAudio.play(sample);
               	notes[3].tic();
               }
          }
        if (key == '4')  {
          	 notes[4].pluck();
          	 for (int i=0;i<44100;i++) {
               	double sample = notes[4].sample() ;
               	StdAudio.play(sample);
               	notes[4].tic();
               }
          }
        if (key == 'r')  {
          	 notes[5].pluck();
          	 for (int i=0;i<44100;i++) {
               	double sample = notes[5].sample() ;
               	StdAudio.play(sample);
               	notes[5].tic();
               }
          }
        if (key == '5')  {
          	 notes[6].pluck();
          	 for (int i=0;i<44100;i++) {
               	double sample = notes[6].sample() ;
               	StdAudio.play(sample);
               	notes[6].tic();
               }
          }
        
        
        
       
       
            
        
       
        
        // compute the superposition of the samples

        // send the result to standard audio
        

        // advance the simulation of each guitar string by one step
    }
}
