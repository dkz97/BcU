package org.crypto.bcuwallet.eth;

import lombok.extern.slf4j.Slf4j;
import org.crypto.bcuwallet.account.AccountUtil;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Desc: eth链转账工具类
 *
 * @author dkz97
 * @version 1.0.0
 * @date 2022/7/20 16:54
 */
@Slf4j
public class TransferEthUtil {

    /**
     * 获取当前以太坊gas费
     *
     * @param web3j 已经连接的web3j对象
     * @return gas费
     */
    public static BigInteger getGasPrice(Web3j web3j) throws IOException {
        BigInteger gas = web3j.ethGasPrice().send().getGasPrice();
        log.info("当前以太坊gas费: {}", gas);
        return gas;
    }


    /**
     * 转账方法
     * @param web3j 已经连接的web3j对象
     * @param credentials 转账账户凭证
     * @param toAddress 转账目标地址
     * @param amount 转账金额
     * @return 转账结果
     * @throws Exception 转账异常
     */
    public static boolean transfer(Web3j web3j, Credentials credentials, String toAddress, BigDecimal amount)
            throws Exception {
        log.info("开始转账, toAddress: {}, amount: {}", toAddress, amount);
        if (web3j == null || credentials == null) {
            return false;
        }

        if (!WalletUtils.isValidAddress(toAddress)) {
            log.info("转账目的地址不合法");
            return false;
        }
        if (!WalletUtils.isValidAddress(credentials.getAddress())) {
            log.info("转账账户不合法");
            return false;
        }

        BigInteger balance = AccountUtil.getBalanceOf(web3j, credentials.getAddress());
        if (balance == null) {
            log.info("转账账户余额为空");
            return false;
        }

        if (balance.compareTo(amount.toBigInteger()) <= 0) {
            log.info("转账账户余额不足");
            return false;
        }

        TransactionReceipt send = Transfer.sendFunds(web3j, credentials, toAddress, amount, Convert.Unit.WEI).send();
        log.info("转账成功, txHash: {}", send.getTransactionHash());
        log.info("from : {}, to : {}", send.getFrom(), send.getTo());
        log.info("gasUsed: {}, status: {}", send.getGasUsed(), send.getStatus());
        return true;
    }


}
