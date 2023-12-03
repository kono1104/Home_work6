package home1.service;

import home1.model.FamilyTree;
import home1.model.Human;
import home1.model.IO;
import home1.ui.View;

import java.util.function.Consumer;

public class FamilyService {
    private View view;
    private FamilyTree<Human> familyConnect;
    private IO serialize;

    public FamilyService(View view, FamilyTree<Human> familyConnect, IO serialize) {
        this.familyConnect = familyConnect;
        this.view = view;
        this.serialize = serialize;
        view.setPresenter(new Consumer<Integer>() {
            @Override
            public void accept(Integer choice) {
                handleUserInput(choice);
            }
        });
    }

    private void handleUserInput(int choice) {
        switch (choice) {
            case 1:
                addHumanNew();
                break;
            case 2:
                familyPrint();
                break;
            case 3:
                humanSearch();
                break;
            case 4:
                saveFamily();
                break;
            case 5:
                loadFamily();
                break;
            case 6:
                sortFamilyName();
                break;
            case 7:
                sortFamilyAge();
                break;
            case 8:
                end();
                break;
            default:
                view.print("Некорректный выбор. Пожалуйста, выберите еще раз.");
        }
    }

    private void addHumanNew() {
        // Логика добавления человека
        view.print("Новый член семьи добавлен !");
    }

    private void familyPrint() {
        // Логика вывода семейного древа
        view.print(familyConnect.toString());
    }

    private void humanSearch() {
        // Логика поиска человека
        view.print("Реализация поиска человека");
    }

    private void saveFamily() {
        // Логика сохранения семьи
        familyConnect.saveObj(serialize);
        view.print("Семейное древо сохранено !");
    }

    private void loadFamily() {
        // Логика загрузки семьи
        serialize.load("TreeFamily.data");
    }

    private void sortFamilyName() {
        // Логика сортировки по имени
        familyConnect.getFamilyTree().sort(null);
        view.print("Сортировка завершена !");
    }

    private void sortFamilyAge() {
        // Логика сортировки по возрасту
        familyConnect.getFamilyTree().sort((o1, o2) -> Integer.compare(o1.getAge(), o2.getAge()));
        view.print("Сортировка завершена !");
    }

    private void end() {
        view.print("Спасибо, что пользуетесь нашим сервисом :D");
        // Дополнительные действия при завершении программы
    }
}
