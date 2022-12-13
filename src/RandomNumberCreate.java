import java.util.Random;

/***
 * 0-108 arasında random sayı döndürür.
 */

public class RandomNumberCreate {

    public int randomNumberCreate(){

        Random rnd = new Random();
        int customNumber = rnd.nextInt(109);
        return customNumber;
    }
}
