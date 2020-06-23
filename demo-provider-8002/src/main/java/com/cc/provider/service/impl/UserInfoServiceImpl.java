package com.cc.provider.service.impl;

import com.cc.common.domian.UserInfoBO;
import com.cc.common.domian.UserInfoVO;
import com.cc.provider.dao.AccountInfoMapper;
import com.cc.provider.dao.UserInfoMapper;
import com.cc.provider.pojo.AccountInfoPO;
import com.cc.provider.pojo.UserInfoPO;
import com.cc.provider.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: cheng.chen
 * Date: 2019/8/23 16:11
 * Description:
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    AccountInfoMapper accountInfoMapper;

    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    @Transactional
    public int register(UserInfoVO record) {
        AccountInfoPO accountInfoPO = new AccountInfoPO(record);
        accountInfoMapper.save(accountInfoPO);
        UserInfoPO userInfoPO = new UserInfoPO(record);
        userInfoPO.setAccountId(accountInfoPO.getId());
        userInfoMapper.save(userInfoPO);
        //此处根据用户角色创建token, 根据不同的token转发到不同环境
        return userInfoPO.getId();
    }

    public UserInfoBO get(Integer id){
        return userInfoMapper.get(id);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null)
            return result;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if(node.right != null)
                stack.push(node.right);
            if(node.left != null)
                stack.push(node.left);
        }
        return result;
    }

    public static void main(String[] args) {
        try(FileReader fr = new FileReader("a.txt")) {
            int counter = 0;
            boolean state = false;
            int currentChar;
            while((currentChar= fr.read()) != -1) {
                if(currentChar== ' ' || currentChar == '\n'
                        || currentChar == '\t' || currentChar == '\r') {
                    state = false;
                }else if(!state) {
                    state = true;
                    counter++;
                }
            }
            System.out.println(counter);
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        CompletableFuture<Void> future = CompletableFuture.runAsync(() ->{try{
            TimeUnit.SECONDS.sleep(2);
         }catch (Exception e){
        }
            System.out.println("run end");
        });

    }
}
