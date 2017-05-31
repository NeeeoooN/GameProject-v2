package GameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import Audio.AudioPlayer;
import TileMap.Background;

public class HelpState extends GameState {
	
	private Background bg;
	
	private String con = "Volume";
	
	private Color titleColor;
	private Font titleFont;
	
	private Color color;
	private Font font;
	private AudioPlayer bgMusic;
	
	private int vol = 5;
	private double realVol = 0.5;
	private String dash = "-----------";
	
	
	public HelpState(GameStateManager gsm){
		this.gsm = gsm;
		
		try {
			
			bg = new Background("/Backgrounds/menubg.gif", 1);
			bg.setVector(-0.1, 0);
			
			titleColor = new Color(128, 0, 0);
			titleFont = new Font(
					"Century Gothic",
					Font.PLAIN,
					28);
			
			font = new Font("Arial", Font.PLAIN, 12);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void init() {}

	public void update() {
		bg.update();
	}

	public void draw(Graphics2D g) {
		// draw bg
				bg.draw(g);
				
				g.setColor(titleColor);
				g.setFont(titleFont);
				g.drawString("Change The Volume", 50, 70);
				
				// draw menu options
				g.setFont(font);
				g.setColor(Color.BLACK);
				g.drawString(con + ": " + vol, 135, 150);
				for(int i = 1; i > 11; i++){
					
				}
				if(dash.length() == 1 || dash.length() == 10 ) {
					g.drawString("|" + dash + "|", 135, 170);
				}
				else{
					g.drawString("|" + dash.substring(0, vol) + "|", 145, 180);
				}
		}
	public void keyPressed(int k) {
		if(k == KeyEvent.VK_RIGHT){
			realVol += 0.1;
			vol++;
			if(vol >= 10){
				vol = 10;
			}
		}
		if(k == KeyEvent.VK_LEFT) {
			realVol -= 0.1;
			vol--;
			if(vol <= 1){
				vol = 1;
			}
			}
		if(k == KeyEvent.VK_ESCAPE){
			gsm.setState(GameStateManager.MENUSTATE);
		}
		}


	public void keyReleased(int k) {}

}
