import processing.core.PApplet;

import processing.video.*;
public class MovieTest extends PApplet{
	private Movie movie;
	public static void main(String[] args) {
		PApplet.main("MovieTest");

	}
	public void settings() {
		size(1920,1080);
	}
	public void setup() {
		framerate(24);
		
	}
}
