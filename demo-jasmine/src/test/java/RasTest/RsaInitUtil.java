package RasTest;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.jcajce.provider.asymmetric.rsa.BCRSAPublicKey;
import org.bouncycastle.jce.provider.BouncyCastleProvider;


/**
 *  * RSA初始化类
 *  * @author nmm
 *  * 结合前台的js使用的话，主要需要指定密钥提供者，即引入bcprov-ext-jdk15on-147.jar并使用其中的提供者
 *  
 */
public class RsaInitUtil {

    private static KeyPair keyPair;

    private static RsaInitUtil util;


    private RsaInitUtil() {
        try {
            if (keyPair == null) {
//如果想要能够解密js的加密文件，使用此提供者是必须的
                KeyPairGenerator keygen = KeyPairGenerator.getInstance("RSA", new BouncyCastleProvider());
                SecureRandom random = new SecureRandom();
                random.setSeed(System.currentTimeMillis());
                keygen.initialize(512, random);//设置512位长度
                keyPair = keygen.generateKeyPair();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static RsaInitUtil getInstance() {
        synchronized ("rsa") {
            if (util == null) {
                util = new RsaInitUtil();
            }
        }
        return util;
    }

    /**
     *  *
     *  * 功能说明：[获取公钥]
     *  * @return
     *  * 创建者:Nmm, Aug 19, 2013
     *  
     */


    public PublicKey getPublicKey() {
        return keyPair.getPublic();
    }


    public PrivateKey getPrivateKey() {
        return keyPair.getPrivate();
    }

    /**
     *  *
     *  * 功能说明：[获取公钥字符串]
     *  * @return
     *  * 创建者:Nmm, Aug 19, 2013
     *  
     */
    public String getPublicKeyStr() {
//根据我们的提供者，这里获取的是该类型公钥
        BCRSAPublicKey pk = (BCRSAPublicKey) getPublicKey();
        String str = new String(Hex.encodeHex(pk.getModulus().toByteArray()));
        System.out.println(str);
//获取入口10001一般都为这个
        String ss = new String(Hex.encodeHex(pk.getPublicExponent().toByteArray()));
//获取转换字符串
        System.out.println(b2Hex(pk.getModulus().toByteArray()));
        return ss + str;
    }

    /**
     *  *
     *  * 功能说明：[手动转换]
     *  * @param byteArray
     *  * @return
     *  * 创建者:Nmm, Aug 19, 2013
     *  
     */
    private String b2Hex(byte[] byteArray) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < byteArray.length; i++) {
            int zhz = byteArray[i];
            if (zhz < 0) {
                zhz += 256;
            }
            if (zhz < 16) {
                sb.append("0");
            }
            sb.append(Integer.toHexString(zhz));
        }
        return sb.toString();
    }
}