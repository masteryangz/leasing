package com.view;
import com.domain.House;
import com.service.HouseService;
import com.utils.Utility;

public class HouseView {
    private boolean loop = true;
    private char key = ' ';
    private HouseService houseService = new HouseService(10);

    public void update(){
        System.out.println("=================UPDATE=================");
        System.out.println("enter the ID you want to update(enter -1 to exit): ");
        int updateId = Utility.readInt();
        if(updateId == -1){
            System.out.println("==================DONE==================");
            return;
        }
        House house = houseService.findById(updateId);
        if(house == null){
            System.out.println("not exist");
            return;
        } 
        System.out.println("Name(" + house.getName() + "):");
        String name = Utility.readString(8, "");
        if(!"".equals(name)){
            house.setName(name);
        }
        System.out.println("Phone(" + house.getPhone() + "):");
        String phone = Utility.readString(12, "");
        if(!"".equals(phone)){
            house.setPhone(phone);
        }
        System.out.println("Address(" + house.getAddress() + "):");
        String address = Utility.readString(18, "");
        if(!"".equals(address)){
            house.setAddress(address);
        }
        System.out.println("Rent(" + house.getRent() + "):");
        int rent = Utility.readInt(-1);
        if(rent != -1){
            house.setRent(rent);
        }
        System.out.println("State(" + house.getState() + "):");
        String state = Utility.readString(10, "");
        if(!"".equals(state)){
            house.setState(state);
        }
        System.out.println("==================DONE==================");
    }

    public void findHouse(){
        System.out.println("==================FIND==================");
        System.out.println("enter the ID you want to find: ");
        int findId = Utility.readInt();
        House house = houseService.findById(findId);
        if(house != null) {
            System.out.println(house);
        } else {
            System.out.println("not exist");
        }
    }

    public void exit() {
        char c = Utility.readConfirmSelection();
        if(c == 'Y'){
            loop = false;
        }
    }

    public void listHouses(){
        System.out.println("==================LIST==================");
        System.out.println("Id\t\tname\t\tphone\t\taddress\t\trent\t\tstate");
        House[] houses = houseService.list();
        for(House h : houses){
            if(h == null){
                break;    
            }
            System.out.println(h);
        }
        System.out.println("==================DONE==================");
    }

    public void addHouse(){
        System.out.println("==================ADD===================");
        System.out.print("Name: ");
        String name = Utility.readString(8);
        System.out.print("Phone: ");
        String phone = Utility.readString(12);
        System.out.print("Address: ");
        String address = Utility.readString(16);
        System.out.print("rent: ");
        int rent = Utility.readInt();
        System.out.print("State(rented/not rented): ");
        String state = Utility.readString(10);
        House house = new House(0, name, phone, address, rent, state);
        if(houseService.add(house)){
            System.out.println("================SUCCEED=================");
        } 
        else {
            System.out.println("=================FAILED=================");
        }
    }

    public void delHouse(){
        System.out.println("=================DELETE=================");
        System.out.print("Enter ID of the house you want to delete(enter -1 to exit): ");
        int deleteId = Utility.readInt();
        if(deleteId == -1){
            System.out.println("==================DONE==================");
            return;
        }
        char choice = Utility.readConfirmSelection();
        if(choice == 'Y'){
            if(houseService.del(deleteId)){
                System.out.println("================SUCCEED=================");
            } else {
                System.out.println("=================FAILED=================");
            }
        }
        else {
            System.out.println("==================DONE==================");
        }
    }

    public void mainMenu(){
        do{
            System.out.println("\n==================MENU==================");
            System.out.println("\t1 new houses");
            System.out.println("\t2 find houses");
            System.out.println("\t3 delete houses");
            System.out.println("\t4 update houses");
            System.out.println("\t5 list houses");
            System.out.println("\t6 eixt");
            System.out.print("enter option(1-6): ");
            key = Utility.readChar();
            switch(key){
                case '1':
                    addHouse();
                    break;
                case '2':
                    findHouse();
                    break;
                case '3':
                    delHouse();
                    break;
                case '4':
                    update();
                    break;
                case '5':
                    listHouses();
                    break;
                case '6':
                    exit();
                    break;
            }
        }while(loop);
    }


}
