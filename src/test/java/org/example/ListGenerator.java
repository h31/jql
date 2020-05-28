package org.example;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

import java.util.GregorianCalendar;
import java.util.List;

public class ListGenerator extends Generator<List> {
    public ListGenerator() {
        super(List.class);
    }

    @Override
    public List generate(SourceOfRandomness random, GenerationStatus status) {
        return List.of(random.nextChar('a', 'z'));
    }
}
