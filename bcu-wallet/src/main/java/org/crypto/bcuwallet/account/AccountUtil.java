package org.crypto.bcuwallet.account;

import lombok.extern.slf4j.Slf4j;
import org.crypto.bcuwallet.account.struct.AccountStruct;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.Keys;

import java.math.BigDecimal;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.ArrayList;
import java.util.List;

/**
 * Desc: 操作账户的工具类
 *
 * @author dkz97
 * @version 1.0.0
 * @date 2022/7/20 16:58
 */
@Slf4j
public class AccountUtil {

    /**
     * 创建账户，不带助记词
     * @return AccountStruct 账户对象
     */
    public static List<AccountStruct> createAccount(int count) {
        log.info("开始创建账户, count: {}", count);
        ArrayList<AccountStruct> accounts = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            // 调用Keys的静态方法创建密钥对
            ECKeyPair ecKeyPair = null;
            try {
                ecKeyPair = Keys.createEcKeyPair();
            } catch (InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException e) {
                log.error("创建密钥对失败", e);
                break;
            }
            // 获取公私钥
            String privateKey = ecKeyPair.getPrivateKey().toString(16);
            String publicKey = ecKeyPair.getPublicKey().toString(16);
            // 根据公钥获取地址
            String address = Keys.getAddress(publicKey);
            address = "0x" + address.toUpperCase();

            //添加到账户列表中
            AccountStruct account = new AccountStruct(privateKey, publicKey, address);
            accounts.add(account);
        }
        log.info("创建账户完成, count: {}", count);
        return accounts;
    }


    /**
     * 查询账户余额
     */
    public static BigDecimal queryAccountBalance(String address, String contract) {
        log.info("开始查询账户余额, address: {}, contract: {}", address, contract);

        BigDecimal balance = null;

        // 查询余额


        return balance;
    }

}