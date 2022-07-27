package org.crypto.bcuwallet.common.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Desc: 节点常量类
 *
 * @author dkz97
 * @version 1.0.0
 * @date 2022/7/25 11:07
 */
@Component
public class Node {

    // 本地以太坊节点地址
    public static String ETH_LOCAL_NODE = "";

    // infura以太坊节点地址
    public static String ETH_INFURA_NODE = "";

    @Value("${node.eth.local.url}")
    public void setEthLocalNode(String ethLocalNode) {
        ETH_LOCAL_NODE = ethLocalNode;
    }

    @Value("${node.eth.infura.url}")
    public void setEthInfuraNode(String ethInfuraNode) {
        ETH_INFURA_NODE = ethInfuraNode;
    }



}
