package com.spring.test.image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ImageDetailController {
	@RequestMapping(value = "/image", headers = "Accept=image/jpeg, image/jpg, image/png, image/gif", method = RequestMethod.GET)
	@ResponseBody
	public BufferedImage getImage() {
		try {
			File file = new File("/home1/irteam/owfs/nfs/didark/photo/228/228.jpg");
			return ImageIO.read(file);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
