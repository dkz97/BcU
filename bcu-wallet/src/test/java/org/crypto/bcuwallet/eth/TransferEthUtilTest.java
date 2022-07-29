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

    /**
     * Method under test: {@link TransferEthUtil#transfer(Web3j, Credentials, String, BigDecimal)}
     */
    @Test
    void testTransfer2() throws Exception {
        assertFalse(TransferEthUtil.transfer(null, null, "foo", BigDecimal.valueOf(1L)));
    }

    /**
     * Method under test: {@link TransferEthUtil#transfer(Web3j, Credentials, String, BigDecimal)}
     */
    @Test
    void testTransfer3() throws Exception {
        JsonRpc2_0Admin web3j = new JsonRpc2_0Admin(null);
        Credentials credentials = mock(Credentials.class);
        assertFalse(TransferEthUtil.transfer(web3j, credentials, "42 Main St", BigDecimal.valueOf(1L)));
    }

    /**
     * Method under test: {@link TransferEthUtil#transfer(Web3j, Credentials, String, BigDecimal)}
     */
    @Test
    void testTransfer4() throws Exception {
        JsonRpc2_0Admin web3j = new JsonRpc2_0Admin(new HttpService());
        assertFalse(TransferEthUtil.transfer(web3j, null, "42 Main St", BigDecimal.valueOf(1L)));
    }

    /**
     * Method under test: {@link TransferEthUtil#transfer(Web3j, Credentials, String, BigDecimal)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testTransfer5() throws Exception {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at java.math.BigInteger.<init>(BigInteger.java:415)
        //       at org.web3j.utils.Numeric.toBigIntNoPrefix(Numeric.java:123)
        //       at org.web3j.crypto.WalletUtils.isValidAddress(WalletUtils.java:233)
        //       at org.web3j.crypto.WalletUtils.isValidAddress(WalletUtils.java:226)
        //       at org.crypto.bcuwallet.eth.TransferEthUtil.transfer(TransferEthUtil.java:55)
        //   In order to prevent transfer(Web3j, Credentials, String, BigDecimal)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   transfer(Web3j, Credentials, String, BigDecimal).
        //   See https://diff.blue/R013 to resolve this issue.

        JsonRpc2_0Admin web3j = new JsonRpc2_0Admin(new HttpService());
        Credentials credentials = mock(Credentials.class);
        TransferEthUtil.transfer(web3j, credentials, null, BigDecimal.valueOf(1L));
    }

    /**
     * Method under test: {@link TransferEthUtil#transfer(Web3j, Credentials, String, BigDecimal)}
     */
    @Test
    void testTransfer6() throws Exception {
        JsonRpc2_0Admin web3j = new JsonRpc2_0Admin(new HttpService());
        Credentials credentials = mock(Credentials.class);
        assertFalse(TransferEthUtil.transfer(web3j, credentials, "42", BigDecimal.valueOf(1L)));
    }


}

