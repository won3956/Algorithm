package com.ssafy.어항;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserSolution {
	int N;
	int width;
	int height;
	Tank[] tanks;
	class Tank{
		int id;
		int[] lenghts;
		int[] upShapes;
		Tank(int mID, int mLengths[], int mUpShapes[]) {
			id = mID;
			lenghts = mLengths.clone();
			upShapes = mUpShapes.clone();
		}
	}

	public void init(int N, int mWidth, int mHeight, int mIDs[], int mLengths[][], int mUpShapes[][]) {
		this.N = N;
		width = mWidth;
		height = mHeight;
		tanks = new Tank[N];
		for (int i = 0; i < N; i++) {
			Tank tank = new Tank(mIDs[i], mLengths[i], mUpShapes[i]);
			tanks[i] = tank;
		}
	}

	public int checkStructures(int mLengths[], int mUpShapes[], int mDownShapes[]) {
		return 0;
	}

	public int addStructures(int mLengths[], int mUpShapes[], int mDownShapes[]) {
		return 0;
	}

	public Solution.Result pourIn(int mWater) {
		Solution.Result ret = new Solution.Result();
		ret.ID = ret.height = ret.used = 0;
		return ret;
	}
}
