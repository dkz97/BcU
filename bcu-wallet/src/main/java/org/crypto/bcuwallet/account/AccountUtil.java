package org.crypto.bcuwallet.account;

import lombok.extern.slf4j.Slf4j;
import org.crypto.bcuwallet.account.struct.AccountStruct;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.Keys;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetBalance;

import java.io.IOException;
import java.math.BigInteger;
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
    public static BigInteger getBalanceOf(Web3j web3j, String address) throws IOException {
        log.info("开始查询账户余额, address: {}", address);
        if (web3j == null) {
            return null;
        }
        // 从最新的区块中查询余额
        EthGetBalance balance = web3j.ethGetBalance(address, DefaultBlockParameterName.LATEST).send();
        BigInteger result = balance.getBalance();
        log.info("查询账户余额完成, address: {}, balance: {}", address, result);

        return result;
    }

    /**
     * 批量查询账户余额
     */
    public static List<BigInteger> getBalanceOf(Web3j web3j, List<String> addresses) throws IOException {
        log.info("开始批量查询账户余额, addresses: {}", addresses);
        if (web3j == null) {
            return null;
        }
        List<BigInteger> result = new ArrayList<>();
        for (String address : addresses) {
            result.add(getBalanceOf(web3j, address));
        }
        log.info("批量查询账户余额完成, addresses: {}, result: {}", addresses, result);
        return result;
    }

}
