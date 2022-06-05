package designClass;

import java.util.Random;

public class GenerateRandomPointInACircle {
	// leetcode 478 medium 2022/6/5
	// 等概率随机采样,使用极坐标思想，通过对点到圆心的距离，以及角度进行等概率随机，计算出点的坐标
	double r,x,y;
	Random random = new Random();
    public GenerateRandomPointInACircle(double radius, double x_center, double y_center) {
    	r = radius;
    	x = x_center;
    	y = y_center;
    }
    
    public double[] randPoint() {
    	double len = Math.sqrt(random.nextDouble()* r * r);
    	double ang = random.nextDouble()* 2 * Math.PI;
    	double nx = x + len * Math.cos(ang),ny = y + len * Math.sin(ang);
    	return new double[] {nx,ny};
    }
}
