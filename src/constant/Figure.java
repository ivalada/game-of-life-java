package constant;

import java.util.List;

/**
 * ENUM with some basic predefined figures
 * which can be used as an initial pattern for the game
 */
public enum Figure {

    BLINKER(
            List.of(
                    new int[]{5, 10},	// *
                    new int[]{6, 10},	// *
                    new int[]{7, 10}	// *
            )
    ),
	
	TOAD(
            List.of(
                    new int[]{5, 10},	//  ***
                    new int[]{5, 11},	// ***
                    new int[]{5, 12},
                    new int[]{6, 9},
                    new int[]{6, 10},
                    new int[]{6, 11}
            )
    ),
	
	BEACON(
            List.of(
                    new int[]{5, 10},	// **
                    new int[]{5, 11},	// *
                    new int[]{6, 10},	//   *
                    new int[]{7, 13},	//  **
                    new int[]{8, 12},
                    new int[]{8, 13}
            )
    ),

    ANGEL(
            List.of(
                    new int[]{5, 7},	//   *
                    new int[]{6, 5},	// ** **
                    new int[]{6, 6},	//  * *
                    new int[]{6, 8},	//   *
                    new int[]{6, 9},
                    new int[]{7, 6},
                    new int[]{7, 8},
                    new int[]{8, 7}
            )
    ),
	
	PULSAR(
			List.of(
                    new int[]{5, 20},	//      *     *
                    new int[]{6, 20},	//      *     *
                    new int[]{7, 20},	//      **   **
                    new int[]{7, 21},	//
					new int[]{5, 26},	// ***   ** **  ***
					new int[]{6, 26},	//   *  * * * * *
					new int[]{7, 25},	//      **   **
					new int[]{7, 26},	//
					new int[]{9, 16},	//      **   **
					new int[]{9, 17},	//   *  * * * * *
					new int[]{9, 18},	// ***   ** **  ***
					new int[]{10, 18},	//
					new int[]{9, 28},	//      **   **
					new int[]{9, 29},	//      *     *
					new int[]{9, 30},	//      *     *
					new int[]{10, 28},
					new int[]{9, 21},
					new int[]{9, 22},
					new int[]{10, 20},
					new int[]{10, 22},
					new int[]{11, 20},
					new int[]{11, 21},
					new int[]{9, 24},
					new int[]{9, 25},
					new int[]{10, 24},
					new int[]{10, 26},
					new int[]{11, 25},
					new int[]{11, 26},
					new int[]{14, 18},
					new int[]{15, 18},
					new int[]{15, 17},
					new int[]{15, 16},
					new int[]{13, 20},
					new int[]{13, 21},
					new int[]{14, 20},
					new int[]{14, 22},
					new int[]{15, 21},
					new int[]{15, 22},
					new int[]{13, 25},
					new int[]{13, 26},
					new int[]{14, 24},
					new int[]{14, 26},
					new int[]{15, 24},
					new int[]{15, 25},
					new int[]{14, 28},
					new int[]{15, 28},
					new int[]{15, 29},
					new int[]{15, 30},
					new int[]{17, 25},
					new int[]{17, 26},
					new int[]{18, 26},
					new int[]{19, 26},
					new int[]{17, 20},
					new int[]{17, 21},
					new int[]{18, 20},
					new int[]{19, 20}
            )
    ),
	
	PENTA_DECATHLON(
			List.of(
					new int[]{3, 10},	// ***
					new int[]{3, 11},   //  *
					new int[]{3, 12},   //  *
					new int[]{4, 11},   // ***
					new int[]{5, 11},   //
					new int[]{6, 10},   // ***
					new int[]{6, 11},   // ***
					new int[]{6, 12},   //
					new int[]{8, 10},   // ***
					new int[]{8, 11},   //  *
					new int[]{8, 12},   //  *
					new int[]{9, 10},	// ***
					new int[]{9, 11},
					new int[]{9, 12},
					new int[]{11, 10},
					new int[]{11, 11},
					new int[]{11, 12},
					new int[]{12, 11},
					new int[]{13, 11},
					new int[]{14, 10},
					new int[]{14, 11},
					new int[]{14, 12}
			)
	);

    private final List<int[]> aliveCellsPosition;

    Figure(List<int[]> aliveCellsPosition) {
        this.aliveCellsPosition = aliveCellsPosition;
    }

    public List<int[]> cellPositions() {
        return this.aliveCellsPosition;
    }
}
