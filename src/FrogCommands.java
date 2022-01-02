public class FrogCommands implements FrogCommand {
    private Frog frog;
    private int steps;

    public FrogCommand jumpRightCommand(Frog frog, int steps) {
        this.frog = frog;
        this.steps = steps;
        return this;
    }

    @Override
    public boolean doit() {
        return frog.jump(steps);
    }

    @Override
    public boolean undo() {
        return frog.jump(-steps);
    }
}