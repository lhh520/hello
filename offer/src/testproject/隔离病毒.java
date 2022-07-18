package testproject;

import java.util.*;

public class 隔离病毒 {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int containVirus(int[][] isInfected) {
        int m = isInfected.length, n = isInfected[0].length;
        int ans = 0;
        while (true) {
            List<Set<Integer>> neighbors = new ArrayList<Set<Integer>>();
            List<Integer> firewalls = new ArrayList<Integer>();
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (isInfected[i][j] == 1) {//从当前位置开始进行BFS
                        Queue<int[]> queue = new ArrayDeque<int[]>();
                        queue.offer(new int[]{i, j});//进入队列
                        Set<Integer> neighbor = new HashSet<Integer>();
                        int firewall = 0, idx = neighbors.size() + 1;
                        isInfected[i][j] = -idx;

                        while (!queue.isEmpty()) {
                            int[] arr = queue.poll();
                            int x = arr[0], y = arr[1];
                            for (int d = 0; d < 4; ++d) {
                                int nx = x + dirs[d][0], ny = y + dirs[d][1];
                                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                                    if (isInfected[nx][ny] == 1) {
                                        queue.offer(new int[]{nx, ny});
                                        isInfected[nx][ny] = -idx;
                                    } else if (isInfected[nx][ny] == 0) {//下一个已经是新的 那么应该
                                        ++firewall;
                                        neighbor.add(getHash(nx, ny));
                                    }
                                }
                            }
                        }
                        neighbors.add(neighbor);
                        firewalls.add(firewall);
                    }
                }
            }

            if (neighbors.isEmpty()) {
                break;
            }

            int idx = 0;
            for (int i = 1; i < neighbors.size(); ++i) {
                if (neighbors.get(i).size() > neighbors.get(idx).size()) {
                    idx = i;
                }
            }
            ans += firewalls.get(idx);
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (isInfected[i][j] < 0) {
                        if (isInfected[i][j] != -idx - 1) {
                            isInfected[i][j] = 1;
                        } else {
                            isInfected[i][j] = 2;
                        }
                    }
                }
            }
            for (int i = 0; i < neighbors.size(); ++i) {
                if (i != idx) {
                    for (int val : neighbors.get(i)) {
                        int x = val >> 16, y = val & ((1 << 16) - 1);
                        isInfected[x][y] = 1;
                    }
                }
            }
            if (neighbors.size() == 1) {
                break;
            }
        }
        return ans;
    }

    public int getHash(int x, int y) {
        return (x << 16) ^ y;
    }
}
