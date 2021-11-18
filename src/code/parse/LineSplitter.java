package code.parse;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

/**
 * <p>Multi-line string splitter.</p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 1.0.0
 */
public class LineSplitter implements Function<String, List<String>> {

    /**
     * <p>Splits the contents of a multi-line string into individual lines.</p>
     *
     * @param s String that will be split.
     *
     * @return A list containing the separate lines.
     *
     * @since 1.0.0
     */
    @Override
    public List<String> apply(String s) {
        Scanner scanner = new Scanner(s);
        scanner.useDelimiter("\n");

        List<String> lines = new ArrayList<>();

        while (scanner.hasNext()) {
            lines.add(scanner.next());
        }

        return lines;
    }
}
