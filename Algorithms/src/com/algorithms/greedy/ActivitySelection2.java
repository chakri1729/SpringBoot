package com.algorithms.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ActivitySelection2 {

	public static void main(String[] args) {

		// Activities are already sorted in finish asc, start desc
		System.out.println(getMaximumActivities(Arrays.asList(10, 12, 20), Arrays.asList(20, 25, 30)));
		System.out.println(getMaximumActivities(Arrays.asList(1, 3, 0, 5, 8, 5), Arrays.asList(2, 4, 6, 7, 9, 9)));

		// Activities are already sorted in finish asc, start desc
		System.out.println(getMaximumActivities(Arrays.asList(20, 12, 10), Arrays.asList(30, 25, 20)));
		System.out.println(getMaximumActivities(Arrays.asList(8, 3, 0, 5, 1, 5), Arrays.asList(9, 4, 6, 7, 2, 9)));

	}

	public static List<Task> getMaximumActivities(List<Integer> start, List<Integer> finish) {

		List<Task> givenTasks = new ArrayList<>();
		for (int i = 0; i < start.size(); i++) {
			givenTasks.add(new Task(i, start.get(i), finish.get(i)));
		}

		// Assume Already activities are sorted in order of finish time asc
		// start time desc

		Collections.sort(givenTasks, (a, b) -> {
			if (a.finish == b.finish)
				return b.start - a.start;
			return a.finish - b.finish;
		});

		List<Task> selectedActivites = new ArrayList<>();
		Task previousTask = givenTasks.get(0);
		selectedActivites.add(previousTask);

		for (int i = 1; i < givenTasks.size(); i++) {
			Task t = givenTasks.get(i);
			if (previousTask.finish <= t.start) {
				selectedActivites.add(t);
				previousTask = t;
			}
		}

		return selectedActivites;

	}

	static class Task {
		int id;
		int start;
		int finish;

		public Task(int id, int start, int finish) {
			super();
			this.id = id;
			this.start = start;
			this.finish = finish;
		}

		@Override
		public String toString() {
			return "Task [id=" + id + ", start=" + start + ", finish=" + finish + "]";
		}

	}
}
