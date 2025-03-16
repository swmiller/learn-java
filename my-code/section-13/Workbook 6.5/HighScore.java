public class HighScore {
    public static void main(String[] args) {

        int highScore = 0;

        // Instructions for this workbook are on Learn the Part (Workbook 6.5).
        int[] scores = new int[10];

        for (int i = 0; i < scores.length; i++) {
            scores[i] = getRandomScore();
            if (scores[i] > highScore) {
                highScore = scores[i];
            }
        }

        System.out.print("Here are the scores: ");
        for (int i = 0; i < scores.length; i++) {
            System.out.print(scores[i] + " ");
        }

        System.out.println("\n\nThe highest score is: " + highScore + ". Give that man a cookie!");
    }

    /**
     * This method returns a random score between 0 and 50000.
     * 
     * @return a random score between 0 and 50000
     */
    public static int getRandomScore() {
        return (int) (Math.random() * 50000);
    }
}
