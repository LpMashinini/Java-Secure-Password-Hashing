import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Base64;

public class HashPassword{
    private static String ALGORITHM = "PBKDF2withHmacSHA512";
    private static final int Iteraction = 65536;
    private static final int KEY_LENGTH = 512;
    private static final int SALT_LENGTH = 16;

    public String hashPassword(String password) throws Exception{

        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[SALT_LENGTH];
        random.nextBytes(salt);

        KeySpec spec = new PBEKeySpec(
                password.toCharArray(),
                salt,
                Iteraction,
                KEY_LENGTH

        );

        SecretKeyFactory factory = SecretKeyFactory.getInstance(ALGORITHM);
        byte[] hash = factory.generateSecret(spec).getEncoded();

        String saltBase64 = Base64.getEncoder().encodeToString(salt);
        String hashBase64 = Base64.getEncoder().encodeToString(hash);

        return String.format("%s:%s:%d:%d", saltBase64,hashBase64,Iteraction,KEY_LENGTH);
    }

}
