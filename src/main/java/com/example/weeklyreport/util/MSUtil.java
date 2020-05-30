package com.example.weeklyreport.util;

import org.apache.tomcat.util.codec.binary.Base64;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.imageio.ImageIO;


public class MSUtil {
    //使用md5加密算法
    public static String md5(String msg) {
        //摘要算法，将不同长度的字符串转换为等长的，不可逆
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] input = msg.getBytes();//input需要加密的信息
            byte[] output = md.digest(input);//output加密过的信息
            //将md5处理后的output结果转成字符串
            //利用Base64算法转成字符串
            String str = Base64.encodeBase64String(output);
            //String str=new String(output);//容易出现乱码，一般不使用
            return str;
        } catch (NoSuchAlgorithmException e) {
            System.out.println("密码加密失败");
            return "";
        }
    }

    /**
     * 调整图片大小
     *
     * @param srcImgPath  原图片路径
     * @param distImgPath 转换大小后图片路径
     * @param width       转换后图片宽度
     * @param height      转换后图片高度
     */
    public static void resizeImage(String srcImgPath, String distImgPath, int width, int height) {
        try {
            File srcFile = new File(srcImgPath);
            Image srcImg = ImageIO.read(srcFile);
            //构建图片对象
            BufferedImage buffImg =
                    new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            //绘制图片
            buffImg.getGraphics().drawImage(
                    srcImg.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);
            ImageIO.write(buffImg, "JPEG", new File(distImgPath));
        } catch (IOException e) {
            System.out.println("图片转换异常" + e);
            e.printStackTrace();
        }
    }

    /**
     * 生成不同尺寸的图片
     *
     * @param img 原图片
     * @param url 资源路径
     * @return map：缩略图、大图、小图、原图
     */
    public static Map createImg(String img, String url) {
        Map<String, Object> map = new HashMap<String, Object>();
        //图片名称
        String[] s = img.split("\\.");// "."用"\\."表示
        String thumSRC = s[0] + "_thum." + s[1];
        String bigSRC = s[0] + "_big." + s[1];
        String smallSRC = s[0] + "_small." + s[1];
        String origSRC = s[0] + "_orig." + s[1];
        /*
         * 图片尺寸转换
         * 缩略图：60px*60px
         * 大图：800px*800px
         * 小图（列表页展示图）：220px*220px
         * 原图：430px*430px
         */
        MSUtil.resizeImage(img, thumSRC, 60, 60);
        MSUtil.resizeImage(img, bigSRC, 800, 800);
        MSUtil.resizeImage(img, smallSRC, 220, 220);
        MSUtil.resizeImage(img, origSRC, 430, 430);
        //转换成可访问的资源地址
        String path = MSUtil.getPath();
//		String path="E:\\javashop\\wtpwebapps";
        String thumSRC2 = thumSRC.replace(path, url);
        String bigSRC2 = bigSRC.replace(path, url);
        String smallSRC2 = smallSRC.replace(path, url);
        String origSRC2 = origSRC.replace(path, url);
        //将资源路径中的\替换为/
        map.put("thum", thumSRC2.replace("\\", "/"));
        map.put("big", bigSRC2.replace("\\", "/"));
        map.put("small", smallSRC2.replace("\\", "/"));
        map.put("orig", origSRC2.replace("\\", "/"));
        return map;
    }

    //获取path.properties文件中path的路径
    public static String getPath() {
        String path = "";
        try {
            Properties prop = new Properties();
            InputStream is = MSUtil.class.getClassLoader().getResourceAsStream("path.properties");
            prop.load(is);
            path = prop.getProperty("path");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("加载配置文件失败" + e);
        }
        return path;
    }

    //删除文件
    public static void deleteFile(String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }
    }
}