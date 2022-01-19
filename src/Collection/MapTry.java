package Collection;

import java.security.MessageDigest;
import java.util.*;

import static java.util.Map.entry;

public class MapTry {
    public static void main(String[] args) {
        //맵 팩토리
        java.util.Map<String, Integer> ageOfFriends =
                java.util.Map.of("Raphael", 30, "Olivia", 25, "Thibaut", 26 );
        System.out.println(ageOfFriends);//{Thibaut=26, Olivia=25, Raphael=30}

        for(Map.Entry<String, Integer> entry : ageOfFriends.entrySet()){
            String friend = entry.getKey();
            Integer age = entry.getValue();
            System.out.println(friend + " is " +age + " years old");
        }
        System.out.println("------------------------");
        ageOfFriends.forEach((friends, age) -> System.out.println(friends +" is " +age + " years old"));

        System.out.println("------------------------");
        Map<String, String> favouriteMovies
                = Map.ofEntries(entry("Raphael", "Star wars"),
                                entry("Cristina", "Martix"),
                                entry("Olivia", "James Bond"));

        favouriteMovies.entrySet()
                        .stream()
                        .sorted(Map.Entry.comparingByKey())
                        .forEachOrdered(System.out::println);//사람의 이름을 알파벳 순으로 스트림 요소를 처리한다.

        System.out.println("------------------------");
        Map<String, String> favouriteMovies2 = Map.ofEntries(entry("Rephael", "Star Wars"),
                                                            entry("Olivia", "James Bond"));
        System.out.println(favouriteMovies2.getOrDefault("Olivia", "Martix"));
        System.out.println(favouriteMovies2.getOrDefault("Thibaut", "Martix"));

        Map<String, String > favouriteMoviesTest = new HashMap<>();
        favouriteMoviesTest.put("Raphael", "Star Wars");
        favouriteMoviesTest.put("Olivia", "James bond");

        String key = "Olivia";
        String value = "James bond";

        favouriteMoviesTest.remove(key, value);
        System.out.println();
        favouriteMoviesTest.forEach((name, movies) -> System.out.println(name + "은 " + movies + "를 좋아한다."));
        System.out.println();

        favouriteMoviesTest.put("Olivia", "James bond");
        favouriteMoviesTest.replaceAll((name, movies) -> movies.toUpperCase());//{Olivia=JAMES BOND, Raphael=STAR WARS}
        System.out.println(favouriteMoviesTest);

        //합침
        Map<String, String> family = Map.ofEntries(entry("Teo","Star Wars"), entry("Cristina", "James Bond"));
        Map<String, String> friends = Map.ofEntries(entry("Raphael","Star Wars"));
        Map<String, String> everyone = new HashMap<>(family);
        everyone.putAll(friends); // friends의 모든 항목을 everyone으로 복사
        System.out.println(everyone);//{Cristina=James Bond, Raphael=Star Wars, Teo=Star Wars}


        Map<String, String> family2 = Map.ofEntries(entry("Teo","Star Wars"), entry("Cristina", "James Bond"));
        Map<String, String> friends2 = Map.ofEntries(entry("Raphael","Star Wars"), entry("Cristina", "Matrix"));

        Map<String, String> everyone2 = new HashMap<>(family);
        friends2.forEach((k,v) -> everyone2.merge(k,v,(movie1, movie2) ->movie1 + " & " + movie2)); // 중복된 키가 있으면 두 값을 연결
        System.out.println(everyone2);//{Raphael=Star Wars, Cristina=James Bond & Matrix, Teo=Star Wars}

     /*   Map<String, Long> moviesToCount = new HashMap<>();
        String movieName = "JamesBond";
        long count = moviesToCount.get(movieName);
        if(count == 0){
            moviesToCount.put(movieName, 1L);
        }else{
            moviesToCount.put(movieName, count+1);
        }

        moviesToCount.merge(movieName, 1L, (key2,count2)-> count2+1L);*/
    }
}
