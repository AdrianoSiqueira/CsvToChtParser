package code.main;

import aslib.filemanager.FileWriter;
import code.file.CsvReader;
import code.file.DuckStationChtWriter;
import code.file.PcsxrChtWriter;
import code.help.Helper;
import code.model.Cheat;
import code.parse.CheatFromString;
import code.parse.LineSplitter;
import code.parse.MultilineJoiner;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * <p>App main class.</p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 1.0.0
 */
public class Main {

    public static void main(String[] args) {
        if (args.length != 3) {
            new Helper().show();
            System.exit(0);
        }


        Path input  = Paths.get(args[1]);
        Path output = Paths.get(args[2]);

        FileWriter      writer = new FileWriter();
        Consumer<Cheat> writerImpl;


        // Determines the target of the conversion.
        switch (args[0]) {
            case "--duckstation":
                writerImpl = new DuckStationChtWriter(writer, output);
                break;
            case "--pcsxr":
                writerImpl = new PcsxrChtWriter(writer, output);
                break;
            default:
                throw new IllegalArgumentException("Invalid parameter: '" + args[0] + "'");
        }


        // Read file content
        String content = CsvReader.read(input);

        // Fix multiline cell content
        content = new MultilineJoiner().apply(content);

        // Split content in individual lines
        List<String> lines = new LineSplitter().apply(content);

        // Remove header line
        lines.remove(0);


        // Clear previous content in output file
        writer.write("", output);


        // Run parse routine
        lines.stream()
             .map(new CheatFromString())
             .filter(Optional::isPresent)
             .map(Optional::get)
             .forEach(writerImpl);
    }
}
