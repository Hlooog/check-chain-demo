package com.hl.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: hl
 * @Description: TODO
 * @DateTime: 2024/3/20  23:26
 **/
@Configuration
@ComponentScan("com.hl.spring")
public class SpringConfig {

    @Autowired
    Map<String, CheckChain> checks;

    Map<String, CheckChainNode> nodeMap = new HashMap<>();

    public CheckChainNode build() {
        CheckChainNode root = new CheckChainNode(null);
        checks.entrySet().stream().forEach((e) -> {
            String beanName = e.getKey();
            CheckChain bean = e.getValue();
            findParent(root, beanName, bean);
        });
        return root;
    }

    @Bean
    public VerifyChain verifyChain() {
        return new VerifyChain(build());
    }

    public CheckChainNode findParent(CheckChainNode root, String name, CheckChain checkChain) {
        if (nodeMap.containsKey(name)) {
            return nodeMap.get(name);
        }
        CheckChainNode node = new CheckChainNode(checkChain);
        String parentName = checkChain.getClass().getAnnotation(From.class).from();
        if ("".equals(parentName)) {
            if (root.getChild() == null) {
                root.setChild(new ArrayList<>());
            }
            root.getChild().add(node);
            nodeMap.put(name, node);
            return node;
        }
        CheckChainNode parent = findParent(root, parentName, checks.get(parentName));
        if (parent.getChild() == null) {
            parent.setChild(new ArrayList<>());
        }
        parent.getChild().add(node);
        nodeMap.put(name, node);
        return node;
    }

}
