package org.crypto.bcuwallet.common.util;

import org.crypto.bcuwallet.common.constant.Node;
import org.springframework.stereotype.Component;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

/**
 * Desc: 构造web3j客户端工具类
 *
 * @author dkz97
 * @version 1.0.0
 * @date 2022/7/25 11:18
 */
@Component
public class Web3jUtil {

    /**
     * 连接本地节点，构造web3j客户端，使用完请自行shutdown
     * @return Web3j 本地节点Web3j
     */
    public static Web3j connectEthLocal() {
        return Web3j.build(new HttpService(Node.ETH_LOCAL_NODE));
    }

    /**
     * 连接infura节点，构造web3j客户端，使用完请自行shutdown
     * @return Web3j infura节点Web3j
     */
    public static Web3j connectEthInfura() {
        return Web3j.build(new HttpService(Node.ETH_INFURA_NODE));
    }

}
