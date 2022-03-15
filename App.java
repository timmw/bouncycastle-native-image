import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class App 
{
    public static void main( String[] args ) throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException
    {
        java.security.Provider[] providers = java.security.Security.getProviders();

        for (java.security.Provider provider : providers) {
            System.out.println(provider.getName());
        }
        
        try {
            Cipher c = Cipher.getInstance("AES/CBC/PKCS7Padding", "BC");
            System.out.println(c.getAlgorithm());
        } catch (NoSuchAlgorithmException e)
        {
            System.out.println(e.getCause());
            throw e;
        }
    }
}
