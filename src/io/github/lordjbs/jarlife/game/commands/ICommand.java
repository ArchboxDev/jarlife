package io.github.lordjbs.jarlife.game.commands;

public interface ICommand {
    void execute(String input);
    String help();
    String name();
}
