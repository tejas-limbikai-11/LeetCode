/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> nm=new LinkedList<>();
        nm.offer(root);
        int s=0;
        while(!nm.isEmpty())
        {
            int m=0,l=nm.size();
            List<Integer> kk=new ArrayList<>();
            for(int i=0;i<l;i++)
            {
                if(nm.peek().left!=null)
                {
                    nm.add(nm.peek().left);
                }
                if(nm.peek().right!=null)
                {
                    nm.add(nm.peek().right);
                }
                int f=nm.poll().val;
                kk.add(f);
            }
            s+=task(kk);
        }
        return s;
    }
    public int task(List<Integer> nm)
    {
        Map<Integer,Integer> kk=new HashMap<>();
        for(int i=0;i<nm.size();i++)
        {
            kk.put(nm.get(i),i);
        }
        Collections.sort(nm);
        boolean k[]=new boolean[nm.size()];
        int s=0;
        for(int i=0;i<nm.size();i++)
        {
            if(k[i] || kk.get(nm.get(i))==i)
            {
                continue;
            }
            int j=i,m=0;
            while(!k[j])
            {
                k[j]=true;
                j=kk.get(nm.get(j));
                m++;
            }
            if(m>0)
            {
                s+=m-1;
            }
        }
        return s;
    }
}