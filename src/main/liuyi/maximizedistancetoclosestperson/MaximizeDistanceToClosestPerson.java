package main.liuyi.maximizedistancetoclosestperson;
/**
 * TODO 待优化下
 * https://leetcode-cn.com/problems/maximize-distance-to-closest-person/description/
 * @author liuyi
 *
 */
public class MaximizeDistanceToClosestPerson {
	public static void main(String[] args) {
		System.out.println(new MaximizeDistanceToClosestPerson().maxDistToClosest(new int[] {0,0,0,1,0,0,0,1,0,0,0,0,1,1,0,0,0,1}));
	}

	public int maxDistToClosest(int[] seats) {
		int result = 0;
		if (seats.length == 2) {
			return 1;
		}
		boolean isFinalEdge = false;
		boolean isEdge = false;
		int maxCon0 = 0;
		int con0 = 0;
		for (int i = 0; i < seats.length; i++) {
			if (seats[i] == 0) {
				con0++;
				if (i == 0) {
					isEdge = true;
				} else if (i == seats.length - 1) {
					isEdge = true;
					if(isEdge){
						if(isFinalEdge){
							if (con0 > maxCon0) {
								maxCon0 = con0;
								isFinalEdge = isEdge;
							}
						}else{
							if (con0*2-1 > maxCon0) {
								maxCon0 = con0;
								isFinalEdge = isEdge;
							}
						}
						
					}else{
						if(isFinalEdge){
							if ((con0+1)/2>maxCon0) {
								maxCon0 = con0;
								isFinalEdge = isEdge;
							}
						}else{
							if (con0 > maxCon0) {
								maxCon0 = con0;
								isFinalEdge = isEdge;
							}
						}
						
					}
				}
			}
			if (seats[i] == 1) {
				if(isEdge){
					if(isFinalEdge){
						if (con0 > maxCon0) {
							maxCon0 = con0;
							isFinalEdge = isEdge;
						}
					}else{
						if (con0*2-1 > maxCon0) {
							maxCon0 = con0;
							isFinalEdge = isEdge;
						}
					}
					
				}else{
					if(isFinalEdge){
						if ((con0+1)/2>maxCon0) {
							maxCon0 = con0;
							isFinalEdge = isEdge;
						}
					}else{
						if (con0 > maxCon0) {
							maxCon0 = con0;
							isFinalEdge = isEdge;
						}
					}
					
				}
				con0 = 0;
				isEdge = false;
			}
		}
		if (isFinalEdge) {
			result = maxCon0;
		} else {
			result = (maxCon0 + 1) / 2;
		}
		return result;
	}
}
