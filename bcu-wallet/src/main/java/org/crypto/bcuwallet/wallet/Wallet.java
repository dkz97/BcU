package org.crypto.bcuwallet.wallet;

import lombok.Data;

import java.util.List;

/**
 * Desc:
 *
 * @author dkz97
 * @version 1.0.0
 * @date 2022/7/20 16:58
 */
@Data
public class Wallet {

    // 公钥
    private String publicKey;

    // 私钥
    private String privateKey;

    // 助记词
    private List<String> mnemonic;

    // 地址
    private String address;

}
