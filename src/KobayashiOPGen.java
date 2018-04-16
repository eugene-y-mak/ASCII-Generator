import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class KobayashiOPGen extends PApplet {
	private int numFrames = 0;
	private ArrayList<PImage> imgList;
	private PImage img;
	private PImage img2;
	private float[][] values;
	private String master = "@#+;:,.` ";
	private int fontSize = 10;
	private float frameRate = 5;
	private boolean isRunning;
	private int i1 = 227;
	private int i2 = 199;
	private int i3 = 171;
	private int i4 = 143;
	private int i5 = 115;
	private int i6 = 87;
	private int i7 = 59;
	private int i8 = 31;

	public static void main(String[] args) {
		PApplet.main("KobayashiOPGen");
	}

	public void settings() {
		size(640, 386);
	}

	public void setup() {
		background(0);
		isRunning = true;
		PFont consolas = createFont("Consolas", 20);
		textFont(consolas);
		text("Loading...", 275, 193);
		imgList = new ArrayList<PImage>();
		for (int k = 1; k <= 7; k += 6) {
			String file = "s0000" + k + ".png";
			PImage temp = loadImage(file);
			imgList.add(temp);
		}
		for (int k = 10; k <= 97; k += 6) {
			String file = "s000" + k + ".png";
			PImage temp = loadImage(file);
			imgList.add(temp);
		}
		for (int k = 100; k <= 997; k += 6) {
			String file = "s00" + k + ".png";
			PImage temp = loadImage(file);
			imgList.add(temp);
		}
		for (int k = 1000; k <= 2668; k += 6) {
			String file = "s0" + k + ".png";
			PImage temp = loadImage(file);
			imgList.add(temp);
		}
		img2 = loadImage("s00001.png");
		values = new float[img2.width][img2.height];
		frameRate(frameRate);
	}

	public void draw() {

		background(255);

		img = imgList.get(numFrames);

		for (int r = 0; r < img2.width; r += 6) {
			for (int c = 0; c < img2.height; c += 6) {
				int pixel = img.get(r, c);
				values[r][c] = (0.21f * (red(pixel)) + 0.72f * (green(pixel)) + 0.07f * (blue(pixel)));
				// values[r][c] = (red(pixel) + green(pixel) + blue(pixel)) / 3;
			}
		}
		PFont consolas = createFont("Consolas Bold", fontSize);
		textFont(consolas);
		fill(0);
		for (int r = 0; r < img2.width; r += 6) {
			for (int c = 0; c < img2.height; c += 6) {
				if ((values[r][c]) == 255) {
					text(master.substring(9, 10), r, c);
				} else if (values[r][c] < 255 && values[r][c] > i1) {
					text(master.substring(8, 9), r, c);
				} else if (values[r][c] <= i1 && values[r][c] > i2) {
					text(master.substring(7, 8), r, c);
				} else if (values[r][c] <= i2 && values[r][c] > i3) {
					text(master.substring(6, 7), r, c);
				} else if (values[r][c] <= i3 && values[r][c] > i4) {
					text(master.substring(5, 6), r, c);
				} else if (values[r][c] <= i4 && values[r][c] > i5) {
					text(master.substring(4, 5), r, c);
				} else if (values[r][c] <= i5 && values[r][c] > i6) {
					text(master.substring(3, 4), r, c);
				} else if (values[r][c] <= i6 && values[r][c] > i7) {
					text(master.substring(2, 3), r, c);
				} else if (values[r][c] <= i7 && values[r][c] > i8) {
					text(master.substring(1, 2), r, c);
				} else if (values[r][c] <= i8 && values[r][c] >= 0) {
					text(master.substring(0, 1), r, c);
				}
			}
		}
		if (numFrames < 445) {
			numFrames++;
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
			numFrames = 0;
		}
	}
}