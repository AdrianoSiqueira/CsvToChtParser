package code.file;

import aslib.filemanager.FileReader;

import java.nio.file.Path;
import java.util.NoSuchElementException;

/**
 * <p>CSV file reader.</p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 1.0.0
 */
public class CsvReader {

    /**
     * <p>Reads the entire contents of the CSV file.</p>
     *
     * @param path File that will be read.
     *
     * @return A string with the contents of the file.
     *
     * @since 1.0.0
     */
    public static String read(Path path) {
        return new FileReader()
                .read(path)
                .orElseThrow(() -> new NoSuchElementException("File not found."));
    }
}
