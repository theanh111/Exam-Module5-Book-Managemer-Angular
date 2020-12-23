import java.io.*;


/**
 * Copy one file to another using low level byte streams, 4KB at a time.
 * @author www.codejava.net
 */
public class CopyFilesChunkBuffered {
	private static final int BUFFER_SIZE = 4096; // 4KB

    public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("Please provide input and output files");
			System.exit(0);
		}

		String inputFile = args[0];
		String outputFile = args[1];


        try (
			InputStream inputStream = new BufferedInputStream(new FileInputStream(inputFile));
			OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(outputFile));
        ) {

            byte[] buffer = new byte[BUFFER_SIZE];

            while (inputStream.read(buffer) != -1) {
                outputStream.write(buffer);
            }

        } catch (IOException ex) {
			ex.printStackTrace();
		}
    }
}