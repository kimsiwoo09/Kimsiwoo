package gui.graphic;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

// �̹��� ������ ���õ� ����� ����
// - �̹��� �ε�			load
// - �̹��� ����			slice
// - �̹��� ������¡		resize
public class ImageManager {
	
	public static BufferedImage load(String path) {
		BufferedImage image;
		try {
			image = ImageIO.read(new File(path));
			return image;
		} catch (IOException e) {
			return null;
		}
	}
	
	public static BufferedImage[] slice(BufferedImage image, int size) {
		// [1] ����� �°� �迭�� �غ�
		BufferedImage[] result = new BufferedImage[size];
		
		// [2] �չ�ȣ ��ġ���� �߶� �̹����� ����
		for(int i=0 ; i<size ; i++) {
			result[i] = image.getSubimage(i * image.getWidth()/size, 0, image.getWidth()/size, image.getHeight());
		}
		
		// [3] ��ȯ
		return result;
	}
}
