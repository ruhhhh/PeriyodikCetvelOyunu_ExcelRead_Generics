import java.util.Random;

public class RandomNumberCreate {

    public int randomNumberCreate(){

        Random rnd = new Random();
        int customNumber = rnd.nextInt(109);
        return customNumber;
    }
}
