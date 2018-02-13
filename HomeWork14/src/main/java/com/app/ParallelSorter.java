package com.app;

import java.util.ArrayList;

public class ParallelSorter extends Thread {

	public static <T extends Comparable> void serialSort(T[] array){
		for(int i=0;i<array.length;i++){
			for(int j=0;j<array.length-1;j++){
				if(array[j].compareTo(array[j+1])>0){
					T o=array[j];
					array[j]=array[j+1];
					array[j+1]=o;
				}
			}
		}
	}

	public static <T extends Comparable> void  sort(T[] sortArray, int numThreads){

		if(sortArray==null){return;}

		if(sortArray.length<3){serialSort(sortArray);return;}

		ArrayList<ParallelSorter> threadList=new ArrayList<>();
		int numElements=sortArray.length;

		if(numElements/numThreads<3){numThreads=numElements/3;}

		int numElInThread=numElements/numThreads;
		int[] markers=new int[numThreads];

		for(int i=0;i<numThreads;i++){
			ParallelSorter ps;
			int start=i*numElInThread;
			int end=(i+1<numThreads)?(i+1)*numElInThread:numElements;
			ps=new ParallelSorter(sortArray,start,end);
			threadList.add(ps);
			markers[i]=ps.start;
		}
		for(ParallelSorter ps:threadList) {
			ps.start();
		}
		for(ParallelSorter ps:threadList) {
			try{
				ps.join();
			} catch(InterruptedException e){
				throw new RuntimeException("Unexpected interrupt");
			}
		}
		mergeSort( sortArray, numElements,numThreads,markers, threadList);
	}

	private static <T extends Comparable> void mergeSort(T[] sortArray, int numElements,int numThreads,int[] markers, ArrayList<ParallelSorter> threadList){
		T[] tempArray=sortArray.clone();
		for(int i=0;i<numElements;i++){
			T min=null;
			int thread=-1;
			for(int j=0;j<numThreads;j++){
				if(markers[j]>=threadList.get(j).end){continue;}
				T res=tempArray[markers[j]];
				if(min==null||min.compareTo(res)>0){
					min=res;
					thread=j;
				}
			}
			sortArray[i]=min;
			markers[thread]++;
		}
	}

	private Comparable[] sortMs;
	private int start;
	private int end;
	private ParallelSorter(Comparable[] var, int start, int end) {
		super();
		sortMs=var;
		this.start=start;
		this.end=end;
	}
	public void run() {
		serialRangeSort(sortMs);
	}

	private void serialRangeSort(Comparable[] array){
		for(int i=start;i<end;i++){
			for(int j=start;j<end-1;j++){
				if(array[j].compareTo(array[j+1])>0){
					Comparable o=array[j];
					array[j]=array[j+1];
					array[j+1]=o;
				}
			}
		}
	}

}
