public class Frog {
    public static final int MIN_POSITION = 0;
    public static final int MAX_POSITION = 10;

    protected int position;

    public Frog() { position = 5; }

    public boolean jump(int steps) {
        if (position + steps > MAX_POSITION || position + steps < MIN_POSITION) {
            System.out.println("Невозможно выполнить прыжок. Парашютов не завезли.");
            return false;
        } else {
            position = position + steps;
            return true;
        }
    }

    public void printField() {
        for (int i = MIN_POSITION; i <= MAX_POSITION; i++) {
            if (i == position) {
                System.out.print(" \uD83D\uDC38 ");
            } else {
                System.out.print(" _ ");
            }
        }
        System.out.println();
    }

}