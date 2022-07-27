package org.crypto.bcuwallet.common.util;

import lombok.extern.slf4j.Slf4j;
import org.crypto.bcuwallet.BcuWalletApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.web3j.protocol.Web3j;

import java.io.IOException;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BcuWalletApplication.class)
class Web3jUtilTest {

    /**
     * 测试连接本地eth节点，构造web3j客户端
     */
    @Test
    void testConnectEthLocal() {
        Web3j web3j = Web3jUtil.connectEthLocal();
        try {
            // 通过获取gas来测试一下节点是否连通
            web3j.ethGasPrice().send();
        } catch (IOException e) {
            web3j.shutdown();
            log.error("测试连接本地端口失败");
            assert false;
        }
        web3j.shutdown();
    }

    /**
     * 测试连接infura节点，构造web3j客户端
     */
    @Test
    void testConnectEthInfura() {
        Web3j web3j = Web3jUtil.connectEthInfura();
        try {
            // 通过获取gas来测试一下节点是否连通
            web3j.ethGasPrice().send();
        } catch (IOException e) {
            web3j.shutdown();
            log.error("测试连接infura端口失败");
            assert false;
        }
        web3j.shutdown();
    }

}

