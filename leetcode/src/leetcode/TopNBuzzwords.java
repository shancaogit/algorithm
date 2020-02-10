package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class TopNBuzzwords {

    public static void main(String[] args) {
        String[] toys = {"elmo", "elsa", "legos", "drone", "tablet", "warcraft"};
        String[] quotes = {"Emo is the hottest of the season! Elmo will be on every kid's wishlist!",
                "The new Elmo dolls are super high quality",
                "Expect the Elsa dolls to be very popular this year",
                "Elsa and Elmo are the toys I'll be buying for my kids",
                "For parents of older kids, look into buying them a drone",
                "Warcraft is slowly rising in popularity ahead of the holiday season"
        };
        Stream.of(new TopNBuzzwords().topNBuzzwords(6, 6, toys, 6, quotes)).forEach(System.out::println);
    }

    public String[] topNBuzzwords(int numToys, int topToys, String[] toys, int numQuotes, String[] quotes) {

        Map<String, Integer> map = new HashMap<>();
        for (String toy : toys) {
            map.put(toy.toLowerCase(), 0);
        }
        for (String quote : quotes) {
            String[] words = quote.split(" ");
            for (String word : words) {
                map.computeIfPresent(word.toLowerCase(), (k, v) -> v + 1);
            }
        }

        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        int k = topToys <= numToys ? topToys : numToys;
        return map.entrySet().stream()
                .filter(entry -> entry.getValue() > 0)
                //.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .sorted((o1, o2) -> {
                    int result = o2.getValue().compareTo(o1.getValue());
                    return result == 0 ? o2.getKey().compareTo(o1.getKey()) : result;
                })
                //.sorted(Comparator.comparingInt((ToIntFunction<Map.Entry<String, Integer>>) Map.Entry::getValue).thenComparing(Map.Entry::getKey))
                .limit(k)
                .map(entry -> entry.getKey()).toArray(String[]::new);

    }
}
