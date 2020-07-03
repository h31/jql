package org.example;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

public class ListGenerator extends Generator<ArrayList<String>> {
    public ListGenerator() {
        super((Class<ArrayList<String>>)(Class<?>) ArrayList.class); // Register the type of objects that we can create
    }

    @Override
    public ArrayList<String> generate(SourceOfRandomness random, GenerationStatus status) {
        ArrayList<String> list = new ArrayList<>();
        list.add(Character.toString(random.nextChar('a', 'z')));
        return list;
    }

    static class ListWrapper extends ArrayList<String> {
        @Override
        public int size() {
            return 10;
        }

        @Override
        public String get(int i) {
            return "Mock!";
        }
    }
}
