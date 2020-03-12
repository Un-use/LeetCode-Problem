package com.unuse.p751_p800;

/**
 * @author Unuse
 * @date 2020/2/14
 */
public class P695_MaxAreaOfIsland {

	public int maxAreaOfIsland(int[][] grid) {
		int maxArea = 0;
		int m = grid.length;
		int n = grid[0].length;
		int area;
		int[][] arrived = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 0 || arrived[i][j] == 1) {
					continue;
				}
				arrived[i][j] = 1;
//				area = searchArea1(grid, arrived, i, j) + 1;
				area = searchArea2(grid, arrived, i, j, m, n) + 1;
				if (area > maxArea) {
					maxArea = area;
				}
			}
		}
		return maxArea;
	}

	// 4ms 41.7MB
	private int searchArea1(int[][] grid, int[][] arrived, int i, int j) {
		int area = 0;
		if (i - 1 >= 0 && arrived[i-1][j] != 1 && grid[i-1][j] == 1) {
			arrived[i-1][j] = 1;
			area += searchArea1(grid, arrived, i - 1, j) + 1;
		}
		if (j - 1 >= 0 && arrived[i][j-1] != 1 && grid[i][j-1] == 1) {
			arrived[i][j-1] = 1;
			area += searchArea1(grid, arrived, i, j - 1) + 1;
		}
		if (i + 1 < grid.length && arrived[i+1][j] != 1 && grid[i+1][j] == 1) {
			arrived[i+1][j] = 1;
			area += searchArea1(grid, arrived, i + 1, j) + 1;
		}
		if (j + 1 < grid[0].length && arrived[i][j+1] != 1 && grid[i][j+1] == 1) {
			arrived[i][j+1] = 1;
			area += searchArea1(grid, arrived, i, j + 1) + 1;
		}

		return area;
	}

	// 3ms 41MB
	private int searchArea2(int[][] grid, int[][] arrived, int i, int j, int m, int n) {
		int area = 0;
		if (i - 1 >= 0 && arrived[i-1][j] != 1 && grid[i-1][j] == 1) {
			arrived[i-1][j] = 1;
			area += searchArea2(grid, arrived, i - 1, j, m, n) + 1;
		}
		if (j - 1 >= 0 && arrived[i][j-1] != 1 && grid[i][j-1] == 1) {
			arrived[i][j-1] = 1;
			area += searchArea2(grid, arrived, i, j - 1, m, n) + 1;
		}
		if (i + 1 < m && arrived[i+1][j] != 1 && grid[i+1][j] == 1) {
			arrived[i+1][j] = 1;
			area += searchArea2(grid, arrived, i + 1, j, m, n) + 1;
		}
		if (j + 1 < n && arrived[i][j+1] != 1 && grid[i][j+1] == 1) {
			arrived[i][j+1] = 1;
			area += searchArea2(grid, arrived, i, j + 1, m, n) + 1;
		}

		return area;
	}

	public static void main(String[] args) {
		P695_MaxAreaOfIsland areaOfIsland = new P695_MaxAreaOfIsland();
		int[][] grid = {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
		System.out.println(areaOfIsland.maxAreaOfIsland(grid));
	}
}
