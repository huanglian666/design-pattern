package passkey;

import lombok.SneakyThrows;

import java.security.*;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * Title: <br/>
 * Description: <br/>
 * Copyright: 2024 <br/>
 * Company:<br/>
 * Project: design-pattern <br/>
 *
 * @Author huanglian <br/>
 * Create Time:11/19/24 09:22 <br/>
 */
public class GenerateKeyUtil {
    /**
     * 生成滿足需求的EC算法的公鑰和密鑰對
     * return 密鑰對
     * {@link KeyPair#getPublic()}公鑰
     * {@link KeyPair#getPrivate()}私鑰
     */
    @SneakyThrows
    public static void ECKeyGenerator()  {
        // 初始化 KeyPairGenerator，使用 secp256k1 曲线
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC");
        keyPairGenerator.initialize(new ECGenParameterSpec("secp256k1"));

        // 生成密钥对
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

        // 获取私钥和公钥的编码（PKCS#8 和 X.509 格式）
        String privateKeyBase64 = Base64.getEncoder().encodeToString(privateKey.getEncoded());
        String publicKeyBase64 = Base64.getEncoder().encodeToString(publicKey.getEncoded());

        // 输出密钥
        System.out.println("私钥 (Base64, PKCS#8): " + privateKeyBase64);
        System.out.println("公钥 (Base64, X.509): " + publicKeyBase64);
    }

    /**
     * 使用私鑰對challenge進行簽名
     * @param privateKey 私鑰
     * @param challenge 挑戰內容
     * @return 簽名之後的內容
     */
    @SneakyThrows
    public static String sign(String privateKey, String challenge) {
        // 將 Base64 私鑰轉換為 PrivateKey 對象
        byte[] privateKeyBytes = Base64.getDecoder().decode(privateKey);
        KeyFactory keyFactory = KeyFactory.getInstance("EC");
        PrivateKey ecPrivateKey = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(privateKeyBytes));

        // 初始化 Signature 對象
        Signature signature = Signature.getInstance("SHA256withECDSA");
        signature.initSign(ecPrivateKey);

        // 傳入需要簽名的數據
        signature.update(challenge.getBytes());

        // 生成簽名
        byte[] signedData = signature.sign();

        // 返回 Base64 編碼的簽名
        return Base64.getEncoder().encodeToString(signedData);
    }

    /**
     * 驗證簽名是否能夠和公鑰匹配上
     * @param publicKey 公鑰
     * @param challenge 挑戰內容
     * @param sign 客戶端私鑰簽名結果
     * @return 是否可以正常匹配
     */
    public static boolean verify(String publicKey, String challenge, String sign) {
        try {
            // 將 Base64 公鑰轉換為 PublicKey 對象
            byte[] publicKeyBytes = Base64.getDecoder().decode(publicKey);
            KeyFactory keyFactory = KeyFactory.getInstance("EC");
            PublicKey ecPublicKey = keyFactory.generatePublic(new X509EncodedKeySpec(publicKeyBytes));

            // 將 Base64 簽名轉換為 byte[]
            byte[] signatureBytes = Base64.getDecoder().decode(sign);

            // 使用 Signature 類進行簽名驗證
            Signature signature = Signature.getInstance("SHA256withECDSA");
            signature.initVerify(ecPublicKey);

            // 傳入挑戰內容
            signature.update(challenge.getBytes());

            // 驗證簽名是否有效
            return signature.verify(signatureBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
