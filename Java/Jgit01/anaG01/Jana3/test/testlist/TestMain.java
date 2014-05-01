
package testlist;

import java.util.LinkedList;
import java.util.List;
import static org.mockito.Mockito.*;

public class TestMain {

    public static void main(String[] args) {
        
//        LinkedList mockedList = mock(LinkedList.class);
//        when(mockedList.get(0)).thenReturn("first");
//        System.out.println(mockedList.get(0));
//        System.out.println(mockedList.get(999));
        
        List mockedList = mock(List.class);
        when(mockedList.get(0)).thenReturn("first");
        System.out.println(mockedList.get(0));
        System.out.println(mockedList.get(999));
        
//        TestList tl = new TestList(); // NOPMD
//        
//        try {
//            tl.pass();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
////        try {
////            tl.fail();
////        } catch (Exception e) {
////            System.out.println(e.getMessage());
////        }
//        try {
//            tl.pass();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
    }

}
