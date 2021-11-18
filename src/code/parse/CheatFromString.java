package code.parse;

import code.model.Cheat;

import java.util.Optional;
import java.util.function.Function;

/**
 * <p>Cheat creator using string.</p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 1.0.0
 */
public class CheatFromString implements Function<String, Optional<Cheat>> {

    /**
     * <p>Use string data to construct the cheat object.</p>
     *
     * <p>If the object cannot be constructed, an empty Optional is returned.</p>
     *
     * @param string String containing the data.
     *
     * @return An Optional containing the constructed cheat.
     *
     * @since 1.0.0
     */
    @Override
    public Optional<Cheat> apply(String string) {
        String[] split = string.split(",");

        if (split.length >= 5) {
            Cheat cheat = new Cheat();
            cheat.setGroup(split[0]);
            cheat.setType(split[1]);
            cheat.setActivation(split[2]);
            cheat.setDescription(split[3]);

            for (int i = 4; i < split.length; i++) {
                cheat.addCode(split[i]);
            }

            return Optional.of(cheat);
        } else {
            return Optional.empty();
        }
    }
}
