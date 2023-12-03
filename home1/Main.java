package home1;

import java.io.IOException;
import home1.model.FamilyTree;
import home1.model.Human;
import home1.model.IO;
import home1.presenter.Presenter;
import home1.ui.Console;
import home1.ui.View;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FamilyTree<Human> familyTree = new FamilyTree<>();

        // Add some data
        familyTree.addFamilyTree(new Human("Алекс", "муж", 27));
        familyTree.addFamilyTree(new Human("Иван Иванович Иванов", "муж", 70));
        familyTree.getByName("алекс");

        // MVP
        View view = new Console();
        IO serialize = new IO();
        new Presenter(view, familyTree, serialize, null);
        view.start();
    }
}
