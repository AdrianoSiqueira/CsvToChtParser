package code.file;

import aslib.filemanager.FileWriter;
import code.model.Cheat;

import java.nio.file.Path;
import java.util.function.Consumer;

/**
 * <p>Cheat writer for the DuckStation format.</p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 1.0.0
 */
public class DuckStationChtWriter implements Consumer<Cheat> {

    private final FileWriter writer;
    private final Path       path;


    /**
     * <p>Creates an instance of the {@link DuckStationChtWriter} class.</p>
     *
     * @param writer Writer object used to write to file.
     * @param path   Destination file.
     *
     * @since 1.0.0
     */
    public DuckStationChtWriter(FileWriter writer, Path path) {
        this.writer = writer;
        this.path = path;
    }


    /**
     * <p>Writes out the cheat data applying standard DuckStation formatting.</p>
     *
     * @param cheat Cheat that will be written.
     *
     * @since 1.0.0
     */
    @Override
    public void accept(Cheat cheat) {
        StringBuilder builder = new StringBuilder()
                .append("#group=")
                .append(cheat.getGroup())
                .append(System.lineSeparator())
                .append("#type=")
                .append(cheat.getType())
                .append(System.lineSeparator())
                .append("#activation=")
                .append(cheat.getActivation())
                .append(System.lineSeparator())
                .append("[")
                .append(cheat.getDescription())
                .append("]")
                .append(System.lineSeparator());

        cheat.getCodes()
             .forEach(s -> builder.append(s).append(System.lineSeparator()));

        builder.append(System.lineSeparator());

        writer.append(builder.toString(), path);
    }
}
