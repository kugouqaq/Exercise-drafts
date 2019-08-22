package ceshi.emmm;

class Tree {
    int data;
    Tree zuo;
    Tree you;
    Tree(int math) {
        this.data = math;
    }
}
    public class TestCode {
        int maxLen = 0;
        public int Maxcode(Tree a) {
            if (a==null) {
                return 0;
            }
            if (a.you==null&&a.zuo==null) {
                return 0;
            }
            int left = Maxcode(a.zuo)+1;
            int right = Maxcode(a.you)+1;
            int Temp = left+right;
            if (Temp>maxLen) {
                maxLen=Temp;
            }
            if (left>right) {
                return left;
            } else {
                return right;
            }
        }

        public static void main(String[] args) {
            Tree A = new Tree(2);
            Tree B = new Tree(3);
            Tree C = new Tree(4);
            Tree D = new Tree(5);
            Tree E = new Tree(6);
            Tree F = new Tree(7);
            Tree G = new Tree(8);

            A.you = B;
            A.zuo = C;
            B.you = D;
            B.zuo = E;
            C.you = F;
            C.zuo = G;

            TestCode test = new TestCode();
            int out = test.Maxcode(B);
            System.out.println(out);
            System.out.println(test.maxLen);
        }
    }


