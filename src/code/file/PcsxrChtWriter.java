package code.file;

import aslib.filemanager.FileWriter;
import code.model.Cheat;

import java.nio.file.Path;
import java.util.function.Consumer;

/**
 * <p>Cheat writer for the PCSXR format.</p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 1.0.0
 */
public class PcsxrChtWriter implements Consumer<Cheat> {

    private final FileWriter writer;
    private final Path       path;


    /**
     * <p>Creates an instance of the {@link PcsxrChtWriter} class.</p>
     *
     * @param writer Writer object used to write to file.
     * @param path   Destination file.
     *
     * @since 1.0.0
     */
    public PcsxrChtWriter(FileWriter writer, Path path) {
        this.writer = writer;
        this.path = path;
    }


    /**
     * <p>Writes out the cheat data applying standard PCSXR formatting.</p>
     *
     * @param cheat Cheat that will be written.
     *
     * @since 1.0.0
     */
    @Override
    public void accept(Cheat cheat) {
        StringBuilder builder = new StringBuilder()
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
