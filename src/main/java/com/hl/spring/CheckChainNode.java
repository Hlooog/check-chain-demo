package com.hl.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @Author: hl
 * @Description: TODO
 * @DateTime: 2024/3/20  23:15
 **/
public class CheckChainNode {

    private CheckChain cur;

    private List<CheckChainNode> child;

    public CheckChainNode(CheckChain cur) {
        this.cur = cur;
    }

    public CheckChain getCur() {
        return cur;
    }

    public void setCur(CheckChain cur) {
        this.cur = cur;
    }

    public List<CheckChainNode> getChild() {
        return child;
    }

    public void setChild(List<CheckChainNode> child) {
        this.child = child;
    }
}
