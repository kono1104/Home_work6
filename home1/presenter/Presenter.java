package home1.presenter;

import java.util.Comparator;

import home1.model.FamilyTree;
import home1.model.Human;
import home1.model.IO;
import home1.ui.View;

public class Presenter {
    private static final Comparator<? super Human> sortAge = null;
    private View view;
    private FamilyTree<Human> familyConnect;
    private IO serialize;

    public Presenter(View view, FamilyTree<Human> familyConnect, IO serialize) {
        this.familyConnect = familyConnect;
        this.view = view;
        this.serialize = serialize;
        view.setPresenter(this);
    }

    public Presenter(View view2, FamilyTree<Human> familyTree, IO serialize2, Object object) {
    }

    public void addHumanNew(String name, String sex, int age) {
        familyConnect.addFamilyTree(new Human(name, sex, age));
        view.print("Новый член семьи добавлен !");
    }

    public void familyPrint() {
        String family = familyConnect.toString();
        view.print(family);
    }

    public void humanSearch(String name) {
        Human human = familyConnect.getByName(name);
        if (human == null)
            view.print("Такого человека нет в семье !");

        else {
            String foundHuman = human.toString();
            view.print(foundHuman);
        }
    }

    public void saveFamily() {
        familyConnect.saveObj(serialize);
        view.print("Семейное древо сохранено !");
    }

    public void loadFamily() {
        serialize.load("TreeFamily.data");
    }

    public void sortFamilyName() {
        familyConnect.getFamilyTree().sort(null);
        view.print("Сортировка завершена !");
    }

    public void sortFamilyAge() {
        familyConnect.getFamilyTree().sort(sortAge);
        view.print("Сортировка завершена !");
    }
}