package org.ray.concurrent.forkjoin;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.ForkJoinPool;

import javax.imageio.ImageIO;

public class ForkJoinTest {

	public static void main(String[] args) throws Exception {
        String srcName = "red-tulips.jpg";
        File srcFile = new File(srcName);
        BufferedImage image = ImageIO.read(srcFile);
        
        System.out.println("Source image: " + srcName);
        
        BufferedImage blurredImage = blur(image);
        
        String dstName = "blurred-tulips.jpg";
        File dstFile = new File(dstName);
        ImageIO.write(blurredImage, "jpg", dstFile);
        
        System.out.println("Output image: " + dstName);
        
    }
	
	public static BufferedImage blur(BufferedImage srcImage) {
        int w = srcImage.getWidth();
        int h = srcImage.getHeight();

        int[] src = srcImage.getRGB(0, 0, w, h, null, 0, w);
        int[] dst = new int[src.length];

        System.out.println("Array size is " + src.length);
        System.out.println("Threshold is " + ForkBlur.sThreshold);

        int processors = Runtime.getRuntime().availableProcessors();
        System.out.println(Integer.toString(processors) + " processor"
                + (processors != 1 ? "s are " : " is ")
                + "available");

        // Step1
        ForkBlur fb = new ForkBlur(src, 0, src.length, dst);

        // Step2
        ForkJoinPool pool = new ForkJoinPool();

        long startTime = System.currentTimeMillis();
        // Step3
        pool.invoke(fb);
        long endTime = System.currentTimeMillis();

        System.out.println("Image blur took " + (endTime - startTime) + 
                " milliseconds.");

        BufferedImage dstImage =
                new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        dstImage.setRGB(0, 0, w, h, dst, 0, w);

        return dstImage;
    }
	
}
