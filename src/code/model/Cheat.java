package code.model;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Model an individual cheat. It has the attributes conforming to the data
 * from the CSV file.</p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 1.0.0
 */
public class Cheat {

    private String       group;
    private String       type;
    private String       activation;
    private String       description;
    private List<String> codes;


    public Cheat() {
        this.group = "Ungrouped";
        this.type = "Gameshark";
        this.activation = "EndFrame";
        this.description = "";
        this.codes = new ArrayList<>();
    }


    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getActivation() {
        return activation;
    }

    public void setActivation(String activation) {
        this.activation = activation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getCodes() {
        return codes;
    }

    public void addCode(String code) {
        codes.add(code);
    }
}
