package com.ssafy.어항;

public class UserSolution {
	int N; // 어항 개수 <=20
	int width; // 어항 가로 <= 500
	int height; // 어항 높이 <= 1500
	Tank[] tanks; // 어항 목록

	class Tank {
		int id; // <= 1000000
		int[] lenghts;
		int[] upShapes;

		Tank(int mID, int mLengths[], int mUpShapes[]) {
			id = mID;
			lenghts = mLengths.clone(); // 어항 열 별 설치된 구조물 높이
			upShapes = mUpShapes.clone(); // 구조물 별 위쪽 결합판 종
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

	// 구조물들을 설치할 수 있는 위치들의 수를 반 (우선순위 고려 x)
	public int checkStructures(int mLengths[], int mUpShapes[], int mDownShapes[]) {
		int sum = 0;

		for (Tank tank : tanks) {
			middle: for (int i = 0; i < width - 2; i++) {
				if (tank.upShapes[i] != mDownShapes[0])
					continue;
				for (int j = 0; j < 3; j++) {
					if (tank.upShapes[i + j] != mDownShapes[j]) // 결합판 종류 확인
						continue middle;
					if (tank.lenghts[i + j] + mLengths[j] > height) // 높이 초과 확인
						continue middle;
				}
				int as = tank.lenghts[i];
				int ae = as + mLengths[0];
				int bs = tank.lenghts[i + 1];
				int be = bs + mLengths[1];
				int cs = tank.lenghts[i + 2];
				int ce = cs + mLengths[2];

				if (!isAble(as, ae, bs, be, cs, ce))
					continue;

				sum++;
			}
		}

		return sum;
	}

	public int addStructures(int mLengths[], int mUpShapes[], int mDownShapes[]) {

		// 설치 우선순위: ID가 작을수록, 같은 어항 내에서는 왼쪽 = 그냥 순서대로
		for (Tank tank : tanks) {
			middle: for (int i = 0; i < width - 2; i++) {
				if (tank.upShapes[i] != mDownShapes[0])
					continue;
				for (int j = 0; j < 3; j++) {
					if (tank.upShapes[i + j] != mDownShapes[j])
						continue middle;
					if (tank.lenghts[i + j] + mLengths[j] > height)
						continue middle;
				}
				int[] start = new int[3];
				int[] end = new int[3];
				for (int k = 0; k < 3; k++) {
					start[k] = tank.lenghts[i + k];
					end[k] = start[k] + mLengths[k];
				}

				if (isAble(start, end)) {
					for (int k = 0; k < 3; k++) { // 실제 설치
						tank.lenghts[i + k] = end[k];
						tank.upShapes[i + k] = mUpShapes[k];
					}
					return tank.id * 1000 + i;
				}
			}
		}

		// 리턴: 설치하는 어항과 위치의 정보, 설치할 수 있는 어항이 없는 경우 0
		return 0;
	}

	public Solution.Result pourIn(int mWater) {
		Solution.Result ret = new Solution.Result();
		ret.ID = ret.height = ret.used = 0;
		return ret;
	}

	public static boolean isAble(int[] start, int[] end) {
		return start[0] < end[1] && end[0] > start[1] && start[1] < end[2] && end[1] > start[2];
	}
}
