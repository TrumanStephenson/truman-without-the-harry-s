package demos;

public interface TerminalApp {
    String name();
    String help();
    String execute(String line);
}