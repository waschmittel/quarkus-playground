package org.acme.getting.started;

import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class CommandLineApp implements QuarkusApplication {
    @Override
    public int run(String... args) throws Exception {
        if (args.length < 1) {
            System.out.println("Provide a name");
            return 1;
        }
        System.out.println(String.format("Hello %s", args[0]));
        return 0;
    }
}
