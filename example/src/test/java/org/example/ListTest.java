package org.example;

import com.pholser.junit.quickcheck.From;
import edu.berkeley.cs.jqf.fuzz.Fuzz;
import edu.berkeley.cs.jqf.fuzz.JQF;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assume.assumeTrue;

@RunWith(JQF.class)
public class ListTest {
    @Fuzz
    public void test(@From(ListGenerator.class) List<Object> list) {
        // Assume that the date is Feb 29
        assumeTrue(list.size() == 1);
    }
}
