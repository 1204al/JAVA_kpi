package workshop.task_2_1;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class DeveloperService {

    public static List<String> getLanguages(List<Developer> team) {
        List<String> languages = new ArrayList<>();
        Set<String> set=new HashSet<>();
        team.stream().forEach(s-> {
            set.addAll(s.getLanguages());
        });
        set.stream().forEach(s->{
            languages.add(s);
        });
        return languages;
    }


}
