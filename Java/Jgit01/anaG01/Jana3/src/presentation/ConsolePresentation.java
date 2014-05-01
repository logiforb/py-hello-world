
package presentation;

public class ConsolePresentation implements Presentation {

    @Override
    public void println(Object message) {
        
        fbTest(message); 
    }

    @edu.umd.cs.findbugs.annotations.SuppressWarnings("NP_ALWAYS_NULL")
    private void fbTest(Object message) {
        System.out.println(message); // NOPMD
    }
}
