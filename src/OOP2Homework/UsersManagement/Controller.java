package OOP2Homework.UsersManagement;

public class Controller{
    private User[] users = {};
    public boolean register(String username, String password, String email){
        try{
            for (User verify : users) {
                if (verify.getUsername().equals(username)){
                    return false;
                }
            }
            User temp = new User(username,Encryption.md5(password),email);
            users = java.util.Arrays.copyOf(users,users.length+1);
            users[users.length-1]=temp;
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean login(String username, String password){
        for(User temp : users){
            if (temp.getUsername().equals(username) && temp.getPassword().equals(Encryption.md5(password))){
                return true;
            }
        }
        return false;
    }
}
