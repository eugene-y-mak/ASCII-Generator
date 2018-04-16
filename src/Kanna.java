import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PFont;

public class Kanna extends PApplet {
	private int xTranslate = -50;
	private int yTranslate = 25;
	private int fontSize = 8;
	private ArrayList<String[]> strList;
	private int numFrames;
	private boolean isRunning = true;

	public static void main(String[] args) {
		PApplet.main("Kanna");
	}

	public void settings() {
		fullScreen();
	}

	public void setup() {
		background(0);
		frameRate(5);
		numFrames = 0;

		strList = new ArrayList<String[]>();
		strList.add(loadStrings("kanna3.txt"));
		strList.add(loadStrings("kanna3.txt"));
		strList.add(loadStrings("kanna2.txt"));
		strList.add(loadStrings("kanna2.txt"));
		strList.add(loadStrings("kanna1.txt"));
		strList.add(loadStrings("kanna1.txt"));
		strList.add(loadStrings("kanna2.txt"));
		strList.add(loadStrings("kanna2.txt"));
		strList.add(loadStrings("kanna3.txt"));
		strList.add(loadStrings("kanna3.txt"));
		strList.add(loadStrings("kanna1.txt"));
		strList.add(loadStrings("kanna1.txt"));
		strList.add(loadStrings("kanna2.txt"));
		strList.add(loadStrings("kanna2.txt"));

	}

	public void draw() {

		fill(0);
		ellipse(xTranslate + 350, 400, 485, 1000);
		xTranslate = xTranslate + 50;

		PFont consolas = createFont("Consolas", fontSize);
		textFont(consolas);

		String[] strArr = strList.get(numFrames % strList.size());
		String[] strArr2 = loadStrings("kanna3.txt");

		for (int i = 0; i < strArr.length; i++) {
			fill(255);
			if (numFrames < 11) {
				text(strArr[i], xTranslate - 50, (i + yTranslate) * fontSize);

			} else {
				text(strArr2[i], xTranslate - 50, (i + yTranslate) * fontSize);
			}

		}
		numFrames++;
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
			numFrames = 0;
		}
	}
}