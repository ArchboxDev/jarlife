package io.github.lordjbs.jarlife.game.commands;

import io.github.lordjbs.jarlife.game.internalutil.colours;

import static io.github.lordjbs.jarlife.game.game.commands;
import static io.github.lordjbs.jarlife.game.internalutil.gameutil.print;

/**
 * @author lordjbs
 */
public class help implements ICommand {
    @Override
    public void execute(String input) {
        StringBuilder cmds = new StringBuilder();

        commands.forEach((name, command) -> cmds.append(name).append(" - ").append(command.help()).append("\n"));

        print(colours.ANSI_WHITE + cmds.toString());
    }

    @Override
    public String help() {
        return "Help Command.";
    }

    @Override
    public String name() {
        return "help";
    }
}
