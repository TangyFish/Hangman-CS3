package Guitar_Hero;
import javax.swing.JFrame;
//I'm Thanh, partners with Andre

public class GuitarHeroLiteRunner extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public GuitarHeroLiteRunner()
	// * Changed DaRunner to "GuitarHeroLiteRunner" to make constructor work
	{
		super("GuitarHeroLiteRunner");

		setSize(WIDTH,HEIGHT); 

		getContentPane().add(  new KeyTrapper() );		

		setVisible(true);	

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main( String args[] )
	{
		GuitarHeroLiteRunner run = new GuitarHeroLiteRunner();
	}
}