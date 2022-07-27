package org.crypto.bcuwallet.account.struct;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountStruct {

    // 私钥
    private String privateKey;

    // 公钥
    private String publicKey;

    // 地址
    private String address;

}
