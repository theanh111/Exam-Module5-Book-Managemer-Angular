import java.io.*;
import java.nio.file.*;

/**
 * Copy one file to another using low level byte streams, one byte at a time.
 * @author www.codejava.net
 */
public class CopyFilesNIO {
    public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("Please provide input and output files");
			System.exit(0);
		}

		String inputFile = args[0];
		String outputFile = args[1];


        try {
			long start = System.currentTimeMillis();

			byte[] allBytes = Files.readAllBytes(Paths.get(inputFile));
			Files.write(Paths.get(outputFile), allBytes);

			long end = System.currentTimeMillis();
			System.out.println("Copied in " + (end - start) + " ms");
        } catch (IOException ex) {
			ex.printStackTrace();
		}
    }
}