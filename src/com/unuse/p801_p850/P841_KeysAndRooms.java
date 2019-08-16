package com.unuse.p801_p850;

import java.util.*;

/**
 * @author Unuse
 * @date 2019-08-16
 */
public class P841_KeysAndRooms {

	public static void main(String[] args) {
		List<List<Integer>> rooms = new ArrayList<>();
		rooms.add(Arrays.asList(1,3));
		rooms.add(Arrays.asList(3,0,1));
		rooms.add(Arrays.asList(2));
		rooms.add(Arrays.asList(0));
		System.out.println(canVisitAllRooms(rooms));
	}

	public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
		int[] arrived = new int[rooms.size()];
		Map<Integer, Integer> keyMap = new HashMap<>(rooms.size());
		visitRoom(arrived, keyMap, rooms, 0);
		return keyMap.size() == rooms.size() - 1;
	}

	private static void visitRoom(int[] arrived, Map<Integer, Integer> keyMap, List<List<Integer>> rooms, int room) {
		keyMap.remove(0);
		if (arrived[room] == 1 || keyMap.size() == rooms.size() - 1) {
			return;
		}

		arrived[room] = 1;
		List<Integer> keys = rooms.get(room);
		for (Integer key : keys) {
			keyMap.put(key, key);
		}

		for (Integer key : keys) {
			visitRoom(arrived, keyMap, rooms, key);
		}
	}

}
