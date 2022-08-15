package org.crypto.bcuwallet.account;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

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
import org.web3j.protocol.websocket.WebSocketService;

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
     * Method under test: {@link AccountUtil#getNonce(Web3j, String)}
     */
    @Test
    void testGetNonce() throws InterruptedException, ExecutionException {
        AccountUtil.getNonce(new JsonRpc2_0Admin(new HttpService()), "jane.doe@example.org");
    }




}

