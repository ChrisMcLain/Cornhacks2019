package spellmate.lists;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collection;

public class ListProcessor {

    @Getter public static Collection<WordList> wordLists;

    public static void refreshLists() {
        wordLists = new ArrayList<WordList>();

        
    }
}
