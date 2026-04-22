import java.util.*;
class Solution {
    static class Node{
        int id, x, y;
        Node left, right;
        
        Node(int id, int x, int y){
            this.id = id;
            this.x = x;
            this.y = y;
        }
        
        public void insertNode(Node parent, Node child){
            if(child.x < parent.x){ //현재 부모 보다 왼쪽 
                if(parent.left == null) parent.left = child;
                else insertNode(parent.left, child);
            } else { //현재 부모보다 오른쪽
                if(parent.right == null) parent.right = child;
                else insertNode(parent.right, child);
            }
        }
        
        public void preorder(List<Integer> list){
            list.add(this.id); // 나 먼저 기록
            if(this.left != null) this.left.preorder(list); // 왼쪽 
            if(this.right != null) this.right.preorder(list); // 오른쪽
        }
        
        public void postorder(List<Integer> list){
            if(this.left != null) this.left.postorder(list); 
            if(this.right != null) this.right.postorder(list);
            list.add(this.id); // 나는 나중에 기록
        }
    }
    
    public List<List<Integer>> solution(int[][] nodeinfo) {
        int n = nodeinfo.length;
        Node[] nodes = new Node[n];
        
        for(int i = 0; i < n; i++){
            int[] arr = nodeinfo[i];
            nodes[i] = new Node(i+1, arr[0], arr[1]);
        }
        
        Arrays.sort(nodes, (a, b) -> {
            if(a.y == b.y) return a.x - b.x;
            return b.y - a.y;
        });
        
        //주입과정
        Node root = nodes[0];
        for(int i = 1; i < n; i++){
            root.insertNode(root, nodes[i]);   
        };
        
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> pre = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        root.preorder(pre);
        root.postorder(post);
        ret.add(pre);
        ret.add(post);
        return ret;
    }
}
/*
조건 및 구하는 것
- 두팀으로 나눔, 각팀이 다른 곳 순회, 
- x,y는 정수, 모든 노드 서로다은 x,
- 목표: 전위, 후위 순회한 결과를 2차원 배열에 담아 리턴
- 노드의 정보는 [x좌표, y좌표]
- y가 가장 높은 지점이 루트이고 다음 y를 기준으로 좌표가 가 정해진다

아이디어

자료구조

로직

*/