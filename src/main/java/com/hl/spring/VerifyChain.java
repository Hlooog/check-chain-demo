package com.hl.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Map;

/**
 * @Author: hl
 * @Description: TODO
 * @DateTime: 2024/3/21  0:44
 **/
public class VerifyChain {

    private final CheckChainNode root;

    public VerifyChain(CheckChainNode root) {
        this.root = root;
    }

    /**
     * 指责链的传递
     * @param condition
     * @return
     */
    public Result verify(Map<String, Object> condition) {
        CheckChainNode curr = root;
        Deque<CheckChainNode> queue = new ArrayDeque<>();
        if (curr.getChild() != null) {
            curr.getChild().forEach(c -> queue.offer(c));
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                CheckChainNode node = queue.pop();
                List<CheckChainNode> child = node.getChild();
                Result result = node.getCur().check(condition);
                if (!result.pass() && node.getCur().isNecessary(condition)) {
                    return new Result(result.pass(), result.getError());
                }
                if (child != null) {
                    child.forEach(e -> queue.offer(e));
                }
            }
        }
        return new Result(true, null);
    }

}
