import java.io.*;


/**
 * This program checks whether a file is of PNG image format or not,
 * by analysing its first 8 bytes.
 * @author www.codejava.net
 */
public class CheckPNG {
	private static int[] pngSignature = {137, 80, 78, 71, 13, 10, 26, 10};

    public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("Please provide the input file");
			System.exit(0);
		}

		String inputFile = args[0];

        try (
			InputStream inputStream = new FileInputStream(inputFile);
        ) {
			int[] headerBytes = new int[8];

			boolean isPNG = true;

			for (int i = 0; i < 8; i++) {
				headerBytes[i] = inputStream.read();
				if (headerBytes[i] != pngSignature[i]) {
					isPNG = false;
					break;
				}
			}

			System.out.println("Is PNG file? " + isPNG);

        } catch (IOException ex) {
			ex.printStackTrace();
		}

	}
}
