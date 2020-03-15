package RasTest;

import org.apache.commons.codec.binary.Hex;
import org.junit.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.text.ParseException;

/**
 * @program: demo-jasmine
 * @description: ${description}
 * @author: libingyao
 * @create: 2019-07-30 15:48
 **/
public class RSAEntry {

    @Test
    public void test() throws ParseException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
// Security.getProviders();//获取所有支持的加密算法
        //采用非对称加密解密算法
        //生成密钥实例
        KeyPairGenerator keygen = KeyPairGenerator.getInstance("RSA");
        SecureRandom random = new SecureRandom();
        random.setSeed(System.currentTimeMillis());//设置随机种子
        keygen.initialize(512, random);//设置密钥长度，应为64的整数倍
        //生成密钥公钥对
        KeyPair keyPair = keygen.generateKeyPair();
        //获取公钥
        PublicKey pubkey = keyPair.getPublic();
        //获取私钥
        PrivateKey prikey = keyPair.getPrivate();
        //测试数据
        String data = "测试数据";
        //使用公钥进行加密
        //构建加密解密类
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, pubkey);//设置为加密模式
        byte[] jmdata = cipher.doFinal(data.getBytes());
        //打印加密后数据
        System.out.println(new String(Hex.encodeHex(jmdata)));
        //改为解密模式进行解密
        cipher.init(Cipher.DECRYPT_MODE, prikey);//会用私钥解密
        jmdata = cipher.doFinal(jmdata);
        System.out.println(new String(jmdata));

    }

}
