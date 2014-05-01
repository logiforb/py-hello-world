
package testlist;

import java.util.List;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TestList {

    @Test
    public void pass() {
        
        List mockedList = mock(List.class);
        
        mockedList.add("one");
        mockedList.clear();
        
        verify(mockedList).add("one");
        verify(mockedList).clear();
    }
    
//    @Test
//    public void fail() {
//        
//        List mockedList = mock(List.class);
//        
//        mockedList.add("one");
//        mockedList.clear();
//        
//        verify(mockedList).add("one2");
//        verify(mockedList).clear();
//    }
}
