package com.algorithms.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ActivitySelection {

	public static void main(String[] args) {

		System.out.println("Test Case# 1:");

		int[] startTimes = { 10, 12, 20 };
		int[] finishTimes = { 20, 25, 30 };
		getMaxActivities(startTimes, finishTimes);

		System.out.println("Test Case# 2:");

		startTimes = new int[] { 1, 3, 0, 5, 8, 5 };
		finishTimes = new int[] { 2, 4, 6, 7, 9, 9 };
		getMaxActivities(startTimes, finishTimes);

		System.out.println("Test Case# 3:");

		startTimes = new int[] { 8, 0, 1, 5, 3, 8, 5 };
		finishTimes = new int[] { 9, 6, 2, 7, 4, 9, 9 };
		getMaxActivities(startTimes, finishTimes);

	}

	public static void getMaxActivities(int[] startTimes, int[] finishTimes) {
		if (startTimes == null || finishTimes == null || startTimes.length != finishTimes.length)
			return;
		List<Task> taskList = new ArrayList<>();
		for (int i = 0; i < startTimes.length; i++)
			taskList.add(new Task(startTimes[i], finishTimes[i]));

		Collections.sort(taskList);

		List<Task> selectedList = new ArrayList<>();
		Task lastTask = taskList.get(0);
		selectedList.add(lastTask);
		for (int i = 1; i < taskList.size(); i++) {
			if (taskList.get(i).getStartTime() >= lastTask.getFinishTime()) {
				lastTask = taskList.get(i);
				selectedList.add(lastTask);
			}
		}

		selectedList.forEach(System.out::println);

	}

}

class Task implements Comparable<Task> {
	private int startTime;
	private int finishTime;

	public Task(int startTime, int finishTime) {
		super();
		this.startTime = startTime;
		this.finishTime = finishTime;
	}

	@Override
	public int compareTo(Task o) {
		return o == null? 1 : finishTime - o.finishTime;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(int finishTime) {
		this.finishTime = finishTime;
	}

	@Override
	public String toString() {
		return "Task [startTime=" + startTime + ", finishTime=" + finishTime + "]";
	}

}
