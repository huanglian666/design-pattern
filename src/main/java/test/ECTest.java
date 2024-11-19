package test;

import passkey.GenerateKeyUtil;

import java.util.UUID;

/**
 * Title: <br/>
 * Description: <br/>
 * Copyright: 2024 <br/>
 * Company:<br/>
 * Project: design-pattern <br/>
 *
 * @Author huanglian <br/>
 * Create Time:11/19/24 09:31 <br/>
 */
public class ECTest {
    public static void main(String[] args) {
        String privateKey = "MD4CAQAwEAYHKoZIzj0CAQYFK4EEAAoEJzAlAgEBBCCotmOSLTR7Ev94u8BHO8jIaPt9GrCt/S+IGA+J+oVmWA==";
        String publicKey = "MFYwEAYHKoZIzj0CAQYFK4EEAAoDQgAEKPKFhp" +
                "jRtBv1Yq6e1a40f7OyDmhteN7012Aid691o7ceoCMkSaTYpYLETzs6esYy5KjJuUidTqfbOtorrRNfDQ==";

        // 挑戰內容
        String challenge = UUID.randomUUID().toString();
        System.out.println("Challenge: " + challenge);

        // 簽名
        String signedResult = GenerateKeyUtil.sign(privateKey, challenge);
        System.out.println("簽名結果: " + signedResult);

        System.out.println("核實結果:" + GenerateKeyUtil.verify(publicKey, challenge, signedResult));
    }
}
