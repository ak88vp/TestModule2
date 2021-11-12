package sevier;

import model.Phonebook;

import java.util.ArrayList;

public class ManagerPhonebook implements manager<Phonebook> {
    ArrayList<Phonebook> listPhonebook = new ArrayList<>();
    private final static ManagerPhonebook instance= new ManagerPhonebook();
    private ManagerPhonebook(){
    }
    public static ManagerPhonebook getInstance(){
        return instance;
    }

    @Override
    public void add(Phonebook phonebook) {
        listPhonebook.add(phonebook);
    }

    @Override
    public void print() {
        for (Phonebook listPhonebook:listPhonebook
             ) {
            System.out.println(listPhonebook);
        }
    }

    @Override
    public void delete(String name) {
      listPhonebook.remove(find(name));
    }

    @Override
    public int find(String name) {
        for (int i = 0; i < listPhonebook.size(); i++) {
            if(listPhonebook.get(i).getName().equals(name)){
                return i;
            }
        }
        return -1;
    }
    @Override
    public void edit(String name, Phonebook phonebook) {
     listPhonebook.set(find(name),phonebook);
    }

    public ArrayList<Phonebook> getListPhonebook() {
        return listPhonebook;
    }

    public void setListPhonebook(ArrayList<Phonebook> listPhonebook) {
        this.listPhonebook = listPhonebook;
    }

    public void findName(String name) {
        for (Phonebook phonebook : listPhonebook) {
            if (phonebook.getName().contains(name)) {
                System.out.println(phonebook.getName());
            }
        }
    }

}
