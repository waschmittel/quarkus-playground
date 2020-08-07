package org.acme.getting.started;

import picocli.CommandLine;
import picocli.CommandLine.Help.Ansi;

import static java.lang.String.format;

@CommandLine.Command(name = "greet", git mixinStandardHelpOptions = true, version = "0.0.0.1")
public class MainCommand implements Runnable {
    @CommandLine.Option(names = {"-n", "--name"}, description = "Who will be greeted?", required = true)
    private String name;

    @CommandLine.Option(names = {"-c", "--color"}, description = "Will the greeting colorful?", defaultValue = "false")
    private Boolean color;

    @Override
    public void run() {
        if (color) {
            System.out.println(Ansi.AUTO.string(format("Nice to meet you, @|red %s|@!", name)));
        } else {
            System.out.println(format("Nice to meet you, %s", name));
        }
    }

}
