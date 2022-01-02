import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Frog frog = new Frog();

        List<FrogCommand> commands = new ArrayList<>();
        int curCommand = -1;

        frog.printField();

        while (true) {
            System.out.println("Введите команду. ");
            System.out.println("+N - прыгни на N шагов направо");
            System.out.println("-N - прыгни на N шагов налево");
            System.out.println("<< - Undo (отмени последнюю команду)");
            System.out.println(">> - Redo (повтори отменённую команду)");
            System.out.println("!! - повтори последнюю команду");
            System.out.println("0 - выход");
            String command = reader.readLine();

            if (command.equals("0")) {
                break;
            }

            if (command.equals("<<")) {
                if (curCommand < 0) {
                    System.out.println("Нечего отменять!");
                } else {
                    commands.get(curCommand).undo();
                    curCommand--;
                }
            } else if (command.equals(">>")) {
                if (curCommand == commands.size() - 1) {
                    System.out.println("Нечего отменять!");
                } else {
                    curCommand++;
                    commands.get(curCommand).doit();
                }
            } else if (command.equals("!!")) {
                FrogCommand cmd = commands.get(commands.size() - 1);
                curCommand++;
                commands.add(cmd);
                cmd.doit();
            } else {
                int commandStep = Integer.parseInt(command);
                if (curCommand != commands.size() - 1) {
                    for(int i = curCommand + 1; i < commands.size(); i++) {
                        commands.remove(i);
                    }
                }
                FrogCommand cmd = new FrogCommands().jumpRightCommand(frog, commandStep);
                curCommand++;
                commands.add(cmd);
                cmd.doit();
            }

            frog.printField();

        }
    }





}