//package org.example;
//
//import com.pholser.junit.quickcheck.From;
//import edu.berkeley.cs.jqf.fuzz.Fuzz;
//import edu.berkeley.cs.jqf.fuzz.JQF;
//import org.junit.Assert;
//import org.junit.Assume;
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.powermock.api.mockito.PowerMockito;
//import org.powermock.core.classloader.annotations.PrepareForTest;
//import org.powermock.modules.agent.PowerMockAgent;
//import org.powermock.modules.junit4.PowerMockRunner;
//import org.powermock.modules.junit4.PowerMockRunnerDelegate;
//import org.powermock.modules.junit4.rule.PowerMockRule;
//
//import java.util.ArrayList;
//
//@RunWith(JQF.class)
////@PrepareForTest({ArrayList.class, ListUser.class})
//public class ListTest {
//    //    @Fuzz
////    public void test(@From(ListGenerator.class) List<Object> list) {
////    @Rule
////    public PowerMockRule rule = new PowerMockRule();
//
//
//    static {
//        PowerMockAgent.initializeIfNeeded();
//    }
//
//    @Fuzz
//    public void test(@From(ListGenerator.class) ArrayList<String> list) throws Exception {
//        PowerMockito.whenNew(ArrayList.class)
//                .withNoArguments()
//                .thenReturn(list);
////        ArrayList<String> list = PowerMockito.mock(ArrayList.class);
////        PowerMockito.when(list.size()).thenReturn(10);
////        PowerMockito.when(list.get(0)).thenReturn("Mock!");
////        int result = new ListUser().main();
////        // Assume that the date is Feb 29
////        Assume.assumeTrue(list.size() == 1);
////        Assume.assumeTrue(list.size() == 1);
//        Assert.assertNotEquals("a", ListUser.listItem());
//    }
//}
