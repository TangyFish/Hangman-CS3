package Guitar_Hero;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Canvas;
import java.util.*;
import java.awt.event.*;

public class KeyTrapper extends Canvas implements KeyListener, Runnable
{
	private String key;
	private GuitarStringTester Guitar;
	private Stack<Character> stack;
	
	
		//this is the constructor
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Guitar.playNotes(key.charAt(0));
		
	}

	
	public KeyTrapper( )
	{	
		Guitar  = new GuitarStringTester();
		addKeyListener( this );
		setFocusable( true );
	}

	public void paint( Graphics window )
	{
		window.setColor(Color.WHITE);
		window.fillRect(0,0,800,600);

		window.setColor(Color.BLACK);		
		window.drawString( key, 250, 250 );
			
	}
	
	public void keyTyped(KeyEvent e)
	{
		
		System.out.println("pressed");			
	}
		
	public void keyPressed(KeyEvent e)
	{
		
		
		key = e.getKeyChar()+"";
		System.out.println(key);
		Thread t = new Thread(this);
		t.start();
		
	}
				
	public void keyReleased(KeyEvent e)
	{
		System.out.println("released");	
		
		
	}


	
	

}