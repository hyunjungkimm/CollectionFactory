package Collection;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AsList {
    public static void main(String[] args) {
        List<String> friends  = new ArrayList<>();
        friends.add("Raphael");
        friends.add("Olivia");
        friends.add("Thibaut");

        List<String> friends2 = Arrays.asList("Olivia", "Thibaut");
        friends2.set(0, "Raphael");
        //friends2.add("Richard");//UnsupportedOperationException

        Set<String> friends3 = new HashSet<>(Arrays.asList("Olivia", "Thibaut"));

        Set<String> friends4 = Stream.of("Olivia", "Thibaut").collect(Collectors.toSet());
    }
}
