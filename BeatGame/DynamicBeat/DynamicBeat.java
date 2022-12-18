package BeatGame.DynamicBeat;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
   

public class DynamicBeat extends JFrame{

    private Image screenImage;
    private Graphics screenGraphic;

    private Image introBackground;

    public DynamicBeat(){
        setTitle("Dynamic Beat");
        setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); //게임 프로그램의 해상도를 설정(1280*720)
        setResizable(false);    //사용자가 해상도를 마음대로 변경할 수 없음
        setLocationRelativeTo(null);    //실행시 실행창이 정중앙에 위치함
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //게임창 종료시 프로그램 전체 종료(필수)
        setVisible(true);   //Default값이 flase임, 눈에 게임창이 보이도록 해주는 메서드

        introBackground = new ImageIcon(Main.class.getResource("../images/DynamicBeat.jpg")).getImage();

        Music introMusic = new Music("introMusic.mp3", true);
        introMusic.start();
    }

    public void paint(Graphics g){
        screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        screenGraphic = screenImage.getGraphics();
        screenDraw(screenGraphic);
        g.drawImage(screenImage, 0, 0, null);
    }

    public void screenDraw(Graphics g){
        g.drawImage(introBackground, 0, 0, null);
        this.repaint();
    }
}
