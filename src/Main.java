import company.MyException;
import company.gender.Gender;
import company.model.User;
import company.service.impl.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        User user1 = new User(1,"Tom",24, Gender.MALE);
        User user2 = new User(2,"Jack",19, Gender.MALE);
        User user3 = new User(3,"Roza",26, Gender.FEMALE);
        UserServiceImpl service = new UserServiceImpl();
        service.addUsers(user1);
        service.addUsers(user2);
        service.addUsers(user3);
        try {
            System.out.println(service.getById(7));
        }catch (MyException m){
            System.out.println(m.getMessage());
        }
        service.getAllUsers();
        System.out.println(service.deleteById(3));
        service.getAllUsers();

    }
}