package lanpeople.util;

import java.awt.*; //导入类  
import java.awt.image.*;
import java.util.*;

public class VerifyCode {
	static Random r = new Random();
	static String ssource = "0123456789ABCDEF";
	static char[] src = ssource.toCharArray();

	// 产生随机字符串
	private static String randString(int length) {
		char[] buf = new char[length];
		int rnd;
		for (int i = 0; i < length; i++) {
			rnd = Math.abs(r.nextInt()) % src.length;

			buf[i] = src[rnd];
		}
		return new String(buf);
	}

	// 调用该方法，产生随机字符串,
	// 参数i: 为字符串的长度
	public static String runVerifyCode(int i) {
		String VerifyCode = randString(i);
		return VerifyCode;
	}

	// 给定范围获得随机颜色
	public static Color getRandColor(int fc, int bc) {
		Random random = new Random();
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}

	// 调用该方法将得到的验证码生成图象
	// sCode:传递验证码 w:图象宽度 h:图象高度
	public static BufferedImage CreateImage(String sCode) {
		try {
			// 字符的字体
			Font CodeFont = new Font("Arial Black", Font.PLAIN, 20);
			int iLength = sCode.length(); // 得到验证码长度
			int width = 22 * iLength, height = 38; // 图象宽度与高度
			int CharWidth = (int) (width - 24) / iLength; // 字符距左边宽度
			int CharHeight = 25; // 字符距上边高度

			// 在内存中创建图象
			BufferedImage image = new BufferedImage(width, height,
					BufferedImage.TYPE_INT_RGB);

			// 获取图形上下文
			Graphics g = image.getGraphics();

			// 生成随机类
			Random random = new Random();

			// 设定背景色
			g.setColor(getRandColor(200, 240));
			g.fillRect(0, 0, width, height);

			// 设定字体
			g.setFont(CodeFont);

			// 画随机颜色的边框
			g.setColor(getRandColor(10, 50));
			g.drawRect(0, 0, width - 1, height - 1);

			// 随机产生155条干扰线，使图象中的认证码不易被其它程序探测到
			g.setColor(getRandColor(160, 200));
			for (int i = 0; i < 155; i++) {
				int x = random.nextInt(width);
				int y = random.nextInt(height);
				int xl = random.nextInt(12);
				int yl = random.nextInt(12);
				g.drawLine(x, y, x + xl, y + yl);
			}

			for (int i = 0; i < iLength; i++) {
				String rand = sCode.substring(i, i + 1);
				// 将认证码显示到图象中
				g.setColor(new Color(20 + random.nextInt(60), 20 + random
						.nextInt(120), 20 + random.nextInt(180)));
				g.drawString(rand, CharWidth * i + 14, CharHeight);
			}
			// 图象生效
			g.dispose();
			return image;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 测试
	public static void main(String[] args) {
		String s1 = VerifyCode.runVerifyCode(4);
		System.out.println(s1);
		Image im = VerifyCode.CreateImage(s1);
		Graphics g = im.getGraphics();
		g.drawString(s1, 20, 20);

	}
}