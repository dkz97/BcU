package org.crypto.bcuwallet.account;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;

import org.crypto.bcuwallet.account.struct.AccountStruct;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.Web3jService;
import org.web3j.protocol.admin.JsonRpc2_0Admin;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.Request;
import org.web3j.protocol.core.Response;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.http.HttpService;

class AccountUtilTest {
    /**
     * Method under test: {@link AccountUtil#createAccount(int)}
     */
    @Test
    void testCreateAccount() {
        List<AccountStruct> account = AccountUtil.createAccount(3);
        //account.forEach(System.out::println);
        assertEquals(3, account.size());
        account = AccountUtil.createAccount(5);
        //account.forEach(System.out::println);
        assertEquals(5, account.size());
    }

    /**
     * Method under test: {@link AccountUtil#getBalanceOf(Web3j, List)}
     */
    @Test
    void testGetBalanceOf() throws IOException {
        JsonRpc2_0Admin web3j = new JsonRpc2_0Admin(new HttpService());
        assertTrue(AccountUtil.getBalanceOf(web3j, new ArrayList<>()).isEmpty());
    }

    /**
     * Method under test: {@link AccountUtil#getBalanceOf(Web3j, List)}
     */
    @Test
    void testGetBalanceOf2() throws IOException {
        assertNull(AccountUtil.getBalanceOf(null, new ArrayList<>()));
    }

    /**
     * Method under test: {@link AccountUtil#getBalanceOf(Web3j, List)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetBalanceOf3() throws IOException {
        // TODO: Complete this test.
        //   Reason: R011 Sandboxing policy violation.
        //   Diffblue Cover ran code in your project that tried
        //     to access the network.
        //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
        //   your code from damaging your system environment.
        //   See https://diff.blue/R011 to resolve this issue.

        JsonRpc2_0Admin web3j = new JsonRpc2_0Admin(new HttpService());

        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("开始批量查询账户余额, addresses: {}");
        AccountUtil.getBalanceOf(web3j, stringList);
    }

    /**
     * Method under test: {@link AccountUtil#getBalanceOf(Web3j, List)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetBalanceOf4() throws IOException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.crypto.bcuwallet.account.AccountUtil.getBalanceOf(AccountUtil.java:71)
        //       at org.crypto.bcuwallet.account.AccountUtil.getBalanceOf(AccountUtil.java:87)
        //   In order to prevent getBalanceOf(Web3j, List)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getBalanceOf(Web3j, List).
        //   See https://diff.blue/R013 to resolve this issue.

        Web3jService web3jService = mock(Web3jService.class);
        when(web3jService.send((Request) any(), (Class<Response>) any())).thenReturn(null);
        JsonRpc2_0Admin web3j = new JsonRpc2_0Admin(web3jService);

        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("开始批量查询账户余额, addresses: {}");
        AccountUtil.getBalanceOf(web3j, stringList);
    }

    /**
     * Method under test: {@link AccountUtil#getBalanceOf(Web3j, List)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetBalanceOf5() throws IOException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.web3j.protocol.core.Request.send(Request.java:87)
        //       at org.crypto.bcuwallet.account.AccountUtil.getBalanceOf(AccountUtil.java:70)
        //       at org.crypto.bcuwallet.account.AccountUtil.getBalanceOf(AccountUtil.java:87)
        //   In order to prevent getBalanceOf(Web3j, List)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getBalanceOf(Web3j, List).
        //   See https://diff.blue/R013 to resolve this issue.

        Web3j web3j = mock(Web3j.class);
        when((Request<Object, EthGetBalance>) web3j.ethGetBalance((String) any(), (DefaultBlockParameter) any()))
                .thenReturn(new Request<>());

        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("开始批量查询账户余额, addresses: {}");
        AccountUtil.getBalanceOf(web3j, stringList);
    }


}

