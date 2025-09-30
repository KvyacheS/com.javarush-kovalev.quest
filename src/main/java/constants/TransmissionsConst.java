package constants;

import java.util.List;

public interface TransmissionsConst {

    String CORRIDOR = "corridor";

    String BATHROOM = "bathroom";

    String KITCHEN = "kitchen";

    String ENDING = "ending";

    List<String> AVAILABLE_SCENES  = List.of(BATHROOM, KITCHEN, ENDING, CORRIDOR);

    List<String> AVAILABLE_TRANS_FROM_CORRIDOR = List.of(BATHROOM, KITCHEN, ENDING);

    List<String> AVAILABLE_TRANS_FROM_BATHROOM = List.of(CORRIDOR);

    List<String> AVAILABLE_TRANS_FROM_KITCHEN = List.of(CORRIDOR);
}
