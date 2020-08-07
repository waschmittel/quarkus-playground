package org.acme.getting.started;

import javax.enterprise.context.ApplicationScoped;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.String.format;

@ApplicationScoped
public class GreetingService {
    private final AtomicInteger visitorCounter = new AtomicInteger(0);
    private final ConcurrentHashMap<String, Integer> knownVisitors = new ConcurrentHashMap<>();

    public String greet(String name) {
        knownVisitors.computeIfAbsent(name, key -> visitorCounter.incrementAndGet());

        return format("Hello %s, you are visitor #%s.", name, knownVisitors.get(name));
    }
}
