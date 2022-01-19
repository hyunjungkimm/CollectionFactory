package Collection;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.Map.entry;

public class Factory {
    public static void main(String[] args) {
        //리스트 팩토리
        List<String> friendsList = List.of("Raphael", "Olivia", "Thibaut");
        System.out.println(friendsList);//[Raphael, Olivia, Thibaut]
        //friendsList.add("hi");//UnsupportedOperationException

        //집합 팩토리
        Set<String> friendsSet = Set.of("Raphael", "Olivia", "Thibaut");
        System.out.println(friendsSet);//[Thibaut, Olivia, Raphael]

       // Set<String> friendsSet2 = Set.of("Raphael", "Olivia", "Olivia");
        // System.out.println(friendsSet2);//IllegalArgumentException - 중복x

        //맵 팩토리
        Map<String, Integer> ageOfFriends =
                Map.of("Raphael", 30, "Olivia", 25, "Thibaut", 26 );
        System.out.println(ageOfFriends);//{Thibaut=26, Olivia=25, Raphael=30}

        Map<String, Integer> ageOfFriends2 = Map.ofEntries(entry("Raphael",30),
                                                        entry("Olivia",25),
                                                        entry("Thibaut",26));

        System.out.println(ageOfFriends2);//{Olivia=25, Raphael=30, Thibaut=26}

    }
}
