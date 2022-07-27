package org.crypto.bcuwallet.eth;

import lombok.extern.slf4j.Slf4j;
import org.web3j.protocol.Web3j;

import java.io.IOException;
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
     * @param web3j 已经连接的web3j对象
     * @return gas费
     */
    public static BigInteger getGasPrice(Web3j web3j) throws IOException {
        BigInteger gas = web3j.ethGasPrice().send().getGasPrice();
        log.info("当前以太坊gas费: {}", gas);
        return gas;
    }

}
