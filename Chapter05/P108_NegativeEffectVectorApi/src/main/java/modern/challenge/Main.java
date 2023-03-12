package modern.challenge;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import javax.imageio.ImageIO;
import jdk.incubator.vector.IntVector;
import jdk.incubator.vector.VectorOperators;
import jdk.incubator.vector.VectorSpecies;

public class Main {

    private static final VectorSpecies<Integer> VS = IntVector.SPECIES_PREFERRED;

    public static void negativeFilter(int pixel[], int width, int height) {                             
                
        for (int i = 0; i <= (width * height - VS.length()); i += VS.length()) {
            
            IntVector alphaVector = IntVector.fromArray(VS, pixel, i)
                    .lanewise(VectorOperators.LSHR, 24).and(0xff);
            IntVector redVector = IntVector.fromArray(VS, pixel, i)
                    .lanewise(VectorOperators.LSHR, 16).and(0xff);
            IntVector greenVector = IntVector.fromArray(VS, pixel, i)
                    .lanewise(VectorOperators.LSHR, 8).and(0xff);
            IntVector blueVector = IntVector.fromArray(VS, pixel, i).and(0xff);            

            IntVector subAlphaVector = alphaVector.lanewise(VectorOperators.LSHL, 24);            
            IntVector subRedVector = redVector.broadcast(255).sub(redVector)
                    .lanewise(VectorOperators.LSHL, 16);
            IntVector subGreenVector = greenVector.broadcast(255).sub(greenVector)
                    .lanewise(VectorOperators.LSHL, 8);
            IntVector subBlueVector = blueVector.broadcast(255).sub(blueVector);
           
            IntVector resultVector = subAlphaVector.or(subRedVector)
                    .or(subGreenVector).or(subBlueVector);
            
            resultVector.intoArray(pixel, i);           
        }        
    }

    public static void main(String[] args) throws IOException {

        File file = Path.of("image.png").toFile();
        BufferedImage img = ImageIO.read(file);

        int width = img.getWidth();
        int height = img.getHeight();

        int[] pixel = new int[width * height];
        
        int i = 0;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                pixel[i] = img.getRGB(x, y);                
                i++;
            }
        }

        negativeFilter(pixel, width, height);
        
        i = 0;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                img.setRGB(x, y, pixel[i]);                
                i++;
            }
        }

        File filer = Path.of("image_negative.png").toFile();
        ImageIO.write(img, "png", filer);
    }
}