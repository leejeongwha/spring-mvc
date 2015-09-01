package com.spring.test.etc;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;

public class ImageProcessingTest {
	/**
	 * 이미지 위에 글씨 합성
	 * 
	 * @throws IOException
	 */
	@Test
	public void imageTest() throws IOException {
		String path = "D:/nhnstore/img/L_021_main_thumb.jpg"; // 그릴 이미지 위치
		BufferedImage img = ImageIO.read(new File(path));
		BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_3BYTE_BGR);
		Graphics2D g = image.createGraphics();
		g.drawImage(img, 0, 0, 98, 98, null);

		g.setColor(Color.BLACK);
		g.setFont(new Font("나눔고딕", Font.BOLD, 12));
		g.drawString("안녕하세요 하하하", 25, 25);

		ImageIO.write(image, "jpg", new File("D:/nhnstore/img/L_021_main_thumb_test.jpg"));
		// response.getOutputStream().flush();
		// response.getOutputStream().close();
	}

	/**
	 * path 관련 출력
	 */
	@Test
	public void folderTest() {
		System.out.println(new java.io.File("").getAbsolutePath());
		System.out.println(ImageProcessingTest.class.getClassLoader().getResource("").getPath());
		System.out.println(System.getProperty("java.io.tmpdir"));

	}
}
