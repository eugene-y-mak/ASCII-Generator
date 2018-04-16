import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class KobayashiOP extends PApplet {
	private int fontSize = 8;
	private ArrayList<String[]> strList;
	private int numFrames = 0;
	private float frameRate = 3.8f;
	private boolean isRunning = true;

	public static void main(String[] args) {
		PApplet.main("KobayashiOP");
	}

	public void settings() {
		size(600, 600);
	}

	public void setup() {
		background(255);
		frameRate(frameRate);
		strList = new ArrayList<String[]>();
		for (int i = 1; i <= 190; i++) {
			String file = i + ".txt";
			strList.add(loadStrings(file));
		}
	}

	public void draw() {
		String[] strArr = strList.get(numFrames);
		background(255);
		PFont consolas = createFont("Consolas Bold", fontSize);
		textFont(consolas);
		for (int i = 0; i < strArr.length; i++) {
			fill(0);
			text(strArr[i], 0, i * fontSize);

		}
		numFrames++;
		if (numFrames == strList.size()) {
			noLoop();
		}
	}

	public void keyPressed() {
		if (key == ' ') {
			if (isRunning) {
				noLoop();
				isRunning = false;
			} else {
				loop();
				isRunning = true;
			}
		}
		if (key == BACKSPACE) {
			numFrames =0;
		}
	}
}