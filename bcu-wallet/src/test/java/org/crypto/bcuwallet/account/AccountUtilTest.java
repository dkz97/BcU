package org.crypto.bcuwallet.account;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.crypto.bcuwallet.account.struct.AccountStruct;
import org.junit.jupiter.api.Test;

import java.util.List;

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
}

