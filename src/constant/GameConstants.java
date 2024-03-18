package constant;

import rule.TransitionRule;
import rule.TransitionRuleOne;
import rule.TransitionRuleThree;
import rule.TransitionRuleTwo;

import java.util.List;

/**
 * Game constants
 */
public class GameConstants {
	
	public static final int GRID_ROWS = 24;
    public static final int GRID_COLUMNS = 79;

    public static final long NEXT_GENERATION_RENDER_DELAY = 600;

    public static final List<TransitionRule> GAME_RULES = List.of(
            new TransitionRuleOne(),
            new TransitionRuleTwo(),
            new TransitionRuleThree()
    );
}
