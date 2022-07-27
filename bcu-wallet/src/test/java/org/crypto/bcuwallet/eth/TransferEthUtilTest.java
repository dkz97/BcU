package org.crypto.bcuwallet.eth;

import java.io.IOException;

import lombok.extern.slf4j.Slf4j;
import org.crypto.bcuwallet.common.util.Web3jUtil;
import org.junit.jupiter.api.Test;
import org.web3j.protocol.Web3j;

@Slf4j
class TransferEthUtilTest {
    /**
     * 测试获取当前以太坊gas费
     */
    @Test
    void testGetGasPrice() throws IOException {
        log.info("使用infura节点测试获取当前以太坊gas费");
        Web3j web3j = Web3jUtil.connectEthInfura();
        try {
            TransferEthUtil.getGasPrice(web3j);
        } catch (Exception e) {
            log.info("获取当前以太坊gas费失败");
            web3j.shutdown();
            assert false;
        }
        log.info("获取当前以太坊gas费成功");
        web3j.shutdown();
    }


}

