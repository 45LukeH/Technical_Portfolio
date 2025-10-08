/*
 * Created on 2024-11-02
 *
 * Copyright (c) 2024 Nadine von Frankenberg
 */

// NO NEED TO TOUCH THIS CLASS
public final class GameChoices {
    private static int[] rockSurrogates = { 0xD83D, 0xDC4A };
    private static int[] paperSurrogates = { 0xD83D, 0xDCC4 };
    private static int[] scissorsSurrogates = { 0x2702, 0xFE0F };
    private static int[] lizardSurrogates = { 0xD83E, 0xDD8E };
    private static int[] spockSurrogates = { 0xD83D, 0xDD96 };

    private static final String rockEmoji = new String(rockSurrogates, 0, rockSurrogates.length);
    private static final String paperEmoji = new String(paperSurrogates, 0, paperSurrogates.length);
    private static final String scissorsEmoji = new String(scissorsSurrogates, 0, scissorsSurrogates.length);
    private static final String lizardEmoji = new String(lizardSurrogates, 0, lizardSurrogates.length);
    private static final String spockEmoji = new String(spockSurrogates, 0, spockSurrogates.length);

    public static final String ROCK = "Rock " + rockEmoji;
    public static final String PAPER = "Paper " + paperEmoji;
    public static final String SCISSORS = "Scissors " + scissorsEmoji;
    public static final String LIZARD = "Lizard " + lizardEmoji;
    public static final String SPOCK = "Spock " + spockEmoji;

    // Prevent instantiation!
    private GameChoices() {
    }
}
