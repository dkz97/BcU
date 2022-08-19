package org.crypto.bcuwallet.account;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import org.crypto.bcuwallet.account.struct.AccountStruct;
import org.crypto.bcuwallet.common.util.Web3jUtil;
import org.junit.jupiter.api.Test;

import java.util.List;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.admin.JsonRpc2_0Admin;
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

    @Test
    void testGetBalanceOf() throws IOException {
        Web3j web3j = Web3jUtil.connectEthLocal();
        String account = "321";
        AccountUtil.getBalanceOf(web3j, account);
    }

    /**
     * Method under test: {@link AccountUtil#getBalanceOf(Web3j, List)}
     */
    @Test
    void testGetBalanceOf1() throws IOException {
        Web3j web3j = Web3jUtil.connectEthLocal();
        String account = "321";
        List<String> accounts = new ArrayList<>();
        accounts.add(account);
        assertTrue(AccountUtil.getBalanceOf(web3j, accounts).isEmpty());
    }


    /**
     * Method under test: {@link AccountUtil#getNonce(Web3j, String)}
     */
    @Test
    void testGetNonce() throws InterruptedException, ExecutionException {
        AccountUtil.getNonce(new JsonRpc2_0Admin(new HttpService()), "jane.doe@example.org");
    }




}

