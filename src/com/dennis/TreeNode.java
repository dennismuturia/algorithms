package com.dennis;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    public int val;
    TreeNode left, right;

    public TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(){}

    //add Node to a tree
    public TreeNode addNode(int val, TreeNode allNodes){
        TreeNode res = allNodes;
        if(res == null){
            return new TreeNode(val);
        }

        while(true){
            if(val < res.val){
                if(res.left == null){
                    res.left = new TreeNode(val);
                    return allNodes;
                }
                res = res.left;
            }else{
                if(res.right == null){
                    res.right = new TreeNode(val);
                    return allNodes;
                }
                res = res.right;
            }
        }
    }

    //Traversal Techniques
    //Inorder
    public List<Integer> inorderTraversal(TreeNode root, List<Integer>res){

        if(root != null){
            res.add(root.val);
            inorderTraversal(root.left, res);
            inorderTraversal(root.right, res);
        }
        return res;
    }

     boolean isSame(TreeNode p, TreeNode q){
        if(p != null&& q == null || p == null&& q != null){
            return false;
        }
        if(p!=null && q!=null){
            if(p.val != q.val){
                return false;
            }else{
                return isSame(p.left, q.left) && isSame(p.right, q.right);
            }
        }else {
            return true;
        }
    }
     boolean isSymetric(TreeNode root){
        return checkSymettry(root.left, root.right);
    }

    private  boolean checkSymettry(TreeNode left, TreeNode right) {
        if(left != null && right == null || left == null && right != null) return false;
        if(left!=null && right!= null){
            if(left.val != right.val){
                return false;
            }else {
                return checkSymettry(left.right, right.left) && checkSymettry(left.left, right.right);
            }
        }else return true;
    }

    //Iteretive
    public List<List<Integer>> levelOrderTraversal(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        int len = getLength(root);
        for(int i = 1; i <= len; i++){
            res.add(recursiveLevel(root, i, new ArrayList<>()));
        }
        /*
        Queue<TreeNode>q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()){
            List<Integer>myList = new ArrayList<>();
            int len = q.size();
            for (int i = 0; i < len; i++) {
                if(q.peek().left != null){
                    q.add(q.peek().left);
                }
                if(q.peek().right != null){
                    q.add(q.peek().right);
                }
                myList.add(q.poll().val);
            }
            res.add(myList);
        }

         */
        return res;
    }

    int getLength(TreeNode root){
        if(root== null) return 0;

        int left = 0, right = 0;

        left = getLength(root.left);
        right = getLength(root.right);

        return Math.max(left + 1, right + 1);
    }

    //recursive
    List<Integer> recursiveLevel(TreeNode root, int level, List<Integer>myList){
        if(root != null){
            if(level == 1){
                myList.add(root.val);
            }else if(level > 1){
                recursiveLevel(root.left, level -1, myList);
                recursiveLevel(root.right, level -1, myList);
            }
        }
        return myList;
    }

    //cousin tree
    public boolean isCousins(TreeNode root, int x, int y) {
        //do a level order traversal
        Queue<TreeNode>q = new LinkedList<>();
        if(root == null) return false;
        q.add(root);
        while(!q.isEmpty()){
            List<Integer>list = new ArrayList<>();
            int len = q.size();
            for(int i = 0; i < len; i++){
                TreeNode p = q.poll();
                if(p.left!=null && p.right != null){
                    if(p.left.val ==x && p.right.val == y){
                        return false;
                    }
                }
                if(p.val == x   || p.val==y){
                    list.add(p.val);
                }
                if(p.left != null) q.add(p.left);
                if(p.right!= null) q.add(p.right);

                if(list.size() == 2){
                    return true;
                }

            }

        }

        return false;
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum){
        List<List<Integer>>res = new ArrayList<>();
        secondPathSum(root,  targetSum, res, new ArrayList<>());
        return res;
    }

    private void secondPathSum(TreeNode root, int targetSum, List<List<Integer>> res, List<Integer>items) {
        if(root == null) return;
        items.add(root.val);
        if(root.val == targetSum &&root.left == null && root.right == null){
            res.add(new ArrayList<>(items));
            return;
        }
        if (root.left != null){
            secondPathSum(root.left, targetSum = root.val, res, items);
            items.remove(items.size() -1);
        }
        if(root.right != null){
            secondPathSum(root.right, targetSum = root.val, res, items);
            items.remove(items.size() -1);
        }
    }


    List<List<Integer>>res = new ArrayList<>();
    public List<List<Integer>> pathSum11(TreeNode root, int targetSum) {
        calculate(root, targetSum, 0, new ArrayList<>());
        return res;
    }
    void calculate(TreeNode root, int targetSum, int sum, List<Integer> vals){
        if(root == null) return;
        vals.add(root.val);
        sum += root.val;
        if(sum == targetSum && root.left == null && root.right == null){
            res.add(new ArrayList<>(vals));
            return;
        }

        if(root.left != null){
            calculate(root.left, targetSum, sum, vals);
            vals.remove(vals.size() -1);
        }
        if(root.right != null){
            calculate(root.right, targetSum, sum, vals);
            vals.remove(vals.size() - 1);
        }
    }
    //find profession
    class NewTreeNode{
        String val;
        NewTreeNode left, right;
        NewTreeNode(String val){
            this.val = val;
            this.left =null;
            this.right=null;
        }
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if(val == root.val){
            return root;
        }
        else{
            if(root.left != null){
                if(val < root.val)
                    return searchBST(root.left, val);
            }
            if(root.right != null){
                if(val > root.val)
                    return searchBST(root.right, val);
            }


        }
        return new TreeNode();

    }

    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode res = buildTree(preorder, 0);
        return res;
    }

    TreeNode buildTree(int[] preorder, int index){
        if(index >= preorder.length) return null;

        TreeNode res = new TreeNode(preorder[index]);

        index+=1;
        if(preorder[index] < res.val){
            TreeNode left = buildTree(preorder, index);
            res.left = left;
        }else{
            TreeNode right = buildTree(preorder, index);
            res.right = right;
        }
        return res;
    }

//Ineficient method
    public String findProfession(int level, int pos) {
        //do a breadth first search
        int count = 1;
        Queue<NewTreeNode>q = new LinkedList<>();
        q.add(new NewTreeNode("E"));
        while(!q.isEmpty()){
            int len = q.size();
            for(int i =0; i <=len; i++){
                NewTreeNode p = q.poll();
                // set the items to the tree
                if(p.val.equals("E")){
                    q.add(p.left = new NewTreeNode("E"));
                    q.add(p.right = new NewTreeNode("D"));
                }else{
                    q.add(p.right = new NewTreeNode("D"));
                    q.add(p.left = new NewTreeNode("E"));
                }
                if(count == level && i == pos){
                    return p.val;
                }

            }
            count+=1;
        }
        return "";
    }

}
