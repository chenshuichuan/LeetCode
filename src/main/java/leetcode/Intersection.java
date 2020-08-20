package leetcode;

class Intersection {
    public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        int x1=start1[0];
        int x2=start1[1];
        int y1= end1[0];
        int y2= end1[1];

        int x3=start2[0];
        int x4=start2[1];
        int y3= end2[0];
        int y4= end2[1];

        double[] reslut= new double[2];
        //判断两线段是否平行
        if((y4-y3)*(x2-x1)==(y2-y1)*(x4-x3)){
            // 判断两直线是否重叠
            if ((y2-y1)*(x3-x1) == (y3-y1)*(x2-x1)) {
                // 判断 (x3, y3) 是否在「线段」(x1, y1)~(x2, y2) 上
                if (isInside(x1, y1, x2, y2, x3, y3)) {
                    updateRes(reslut, x3, y3);
                }
                // 判断 (x4, y4) 是否在「线段」(x1, y1)~(x2, y2) 上
                if (isInside(x1, y1, x2, y2, x4, y4)) {
                    updateRes(reslut, (double)x4, (double)y4);
                }
                // 判断 (x1, y1) 是否在「线段」(x3, y3)~(x4, y4) 上
                if (isInside(x3, y3, x4, y4, x1, y1)) {
                    updateRes(reslut, (double)x1, (double)y1);
                }
                // 判断 (x2, y2) 是否在「线段」(x3, y3)~(x4, y4) 上
                if (isInside(x3, y3, x4, y4, x2, y2)) {
                    updateRes(reslut, (double)x2, (double)y2);
                }
            }
        }
        else{
            double t1Up = x3*(y4-y3)+y1*(x4-x3)-y3*(x4-x3)-x1*(y4-y3);
            double t1Down = (x2-x1)*(y4-y3)-(x4-x3)*(y2-y1);
            double t1 = t1Up/t1Down;

            double t2Up = x1*(y2-y1)+y3*(x2-x1)-y1*(x2-x1)-x3*(x2-x1);
            double t2Down = (x4-x3)*(y2-y1)-(x2-x1)*(y4-y3);
            double t2 = t2Up/t2Down;
            if(t1>=0.0&&t1<=1.0 && t2>=0.0 && t2<=1.0){
                reslut[0] = x1 + t1*(x2 - x1);
                reslut[1] = y1 + t1 * (y2 - y1);
            }
        }
        return reslut;
    }

    // 判断 (x, y) 是否在「线段」(x1, y1)~(x2, y2) 上
    // 这里的前提是 (x, y) 一定在「直线」(x1, y1)~(x2, y2) 上
    private boolean isInside(int x1, int y1, int x2, int y2, int x, int y) {
        // 若与 x 轴平行，只需要判断 x 的部分
        // 若与 y 轴平行，只需要判断 y 的部分
        // 若为普通线段，则都要判断
        return (x1 == x2 || (Math.min(x1, x2) <= x && x <= Math.max(x1, x2)))
                && (y1 == y2 || (Math.min(y1, y2) <= y && y <= Math.max(y1, y2)));
    }

    private void updateRes(double[] ans, double x, double y) {
        if (x < ans[0] || (x == ans[0] && y < ans[1])) {
            ans[0] = x;
            ans[1] = y;
        }
    }
}