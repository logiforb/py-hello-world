
package animals1;

import presentation.Presentation;

public class DogImpl implements Dog {

    private Presentation presentation;
    private Cat cat;

    @Override
    public Presentation getPresentation() {
        return presentation;
    }

    @Override
    public void setPresentation(Presentation presentation) {
        this.presentation = presentation;
    }

    @Override
    public Cat getCat() {
        return cat;
    }

    @Override
    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public DogImpl(Presentation presentation, Cat cat) {
        this.presentation = presentation;
        this.cat = cat;
    }
    
    @Override
    public void bark() {
        printBarkString();
        presentation.println(cat.purr());
        printBarkString();
    }

    private void printBarkString() {
        presentation.println(BARK_STRING);
    }
    
    private static final String BARK_STRING = "Barking!";
}
