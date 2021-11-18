package code.parse;

import java.util.function.Function;

/**
 * <p>Multi-line joiner. Serves to join separate lines of a cell.</p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 1.0.0
 */
public class MultilineJoiner implements Function<String, String> {

    /**
     * <p>Join separate lines of a cell.</p>
     *
     * @param string Line that will be joined.
     *
     * @return A string with the joined content.
     *
     * @since 1.0.0
     */
    @Override
    public String apply(String string) {
        StringBuilder result = new StringBuilder();
        boolean       merge  = false;

        for (char c : string.toCharArray()) {
            switch (c) {
                case '"':
                    merge = !merge;
                    break;
                case '\n':
                    if (merge) result.append(',');
                    else result.append(c);
                    break;
                default:
                    result.append(c);
                    break;
            }
        }

        return result.toString();
    }
}
