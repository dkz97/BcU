package org.crypto.bcuwallet.eth;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;

import java.io.IOException;
import java.math.BigDecimal;

import lombok.extern.slf4j.Slf4j;
import org.crypto.bcuwallet.BcuWalletApplication;
import org.crypto.bcuwallet.common.util.Web3jUtil;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.admin.JsonRpc2_0Admin;
import org.web3j.protocol.http.HttpService;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BcuWalletApplication.class)
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

    /**
     * Method under test: {@link TransferEthUtil#transfer(Web3j, Credentials, String, BigDecimal)}
     */
    @Test
    void testTransfer() throws Exception {
        JsonRpc2_0Admin web3j = new JsonRpc2_0Admin(new HttpService());
        Credentials credentials = mock(Credentials.class);
        assertFalse(TransferEthUtil.transfer(web3j, credentials, "42 Main St", BigDecimal.valueOf(1L)));
    }



}

