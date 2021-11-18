package code.help;

/**
 * <p>Helper content to show in case of launch error.</p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 1.0.0
 */
public class Helper {

    /**
     * <p>Shows the help content.</p>
     *
     * @since 1.0.0
     */
    public void show() {
        String ls = System.lineSeparator();

        System.out.println(
                "CSV to CHT Parser" + ls +
                "    Convertes the CSV file to a CHT file." + ls + ls +
                "Requirements" + ls +
                "    JRE 8" + ls + ls +
                "Syntax" + ls +
                "    java -jar [jar_file] [target] [input_file] [output_file]" + ls + ls +
                "Target" + ls +
                "    --duckstation" + ls +
                "        The output file will conform with the DuckStation standards." + ls +
                "    --pcsxr" + ls +
                "        The output file will conform with the PCSXR standards." + ls + ls +
                "Arguments" + ls +
                "    [jar_file]" + ls +
                "        Path to executable JAR file." + ls +
                "    [input_file]" + ls +
                "        Path to CSV file." + ls +
                "    [output_file]" + ls +
                "        Path to CHT file. It will be created if does not exists." + ls
        );
    }
}
