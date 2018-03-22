package gui.graphic;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

// 이미지 편집과 관련된 기능을 구현
// - 이미지 로드			load
// - 이미지 분할			slice
// - 이미지 리사이징		resize
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
		// [1] 장수에 맞게 배열을 준비
		BufferedImage[] result = new BufferedImage[size];
		
		// [2] 앞번호 위치부터 잘라낸 이미지를 대입
		for(int i=0 ; i<size ; i++) {
			result[i] = image.getSubimage(i * image.getWidth()/size, 0, image.getWidth()/size, image.getHeight());
		}
		
		// [3] 반환
		return result;
	}
}
