package com.hqinjun.Collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Collections.shuffle(list); this way will upset the old list order
public class CollectionsShuffle {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
        Collections.shuffle(list);
        String code = "";
        for (int i = 0; i <= 5; i++) {
            code += list.get(i);
        }
        System.out.println( code);
    }

}
