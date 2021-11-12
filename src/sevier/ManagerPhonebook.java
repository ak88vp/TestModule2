package sevier;

import model.Phonebook;

import java.util.ArrayList;
import java.util.Scanner;

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
        for (int i = 0; i < listPhonebook.size(); i++) {
            if(i % 5 == 0 && i!=0){
                Scanner scanner=new Scanner(System.in);
                System.out.println("Enter để hiển thị thêm");
                String next=scanner.nextLine();
            }
            System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s1", listPhonebook.get(i).getName(), listPhonebook.get(i).getNumberPhone(), listPhonebook.get(i).getSex(), listPhonebook.get(i).getDateOfBirth(), listPhonebook.get(i).getAddress(), listPhonebook.get(i).getClub(), listPhonebook.get(i).getEmail());
            System.out.println();
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
    public int findNumber(String number) {
        for (int i = 0; i < listPhonebook.size(); i++) {
            if(listPhonebook.get(i).getNumberPhone().equals(number)){
                return i;
            }
        }
        return -1;
    }

}
