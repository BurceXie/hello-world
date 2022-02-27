package alc;

import com.google.gson.Gson;

import java.util.*;

public class MockUtil {

	public static int[][] genIntMatrix(String data) {
		return new Gson().fromJson(data, int[][].class);
	}

	public static void main(String[] args) {
		int[][] matrix = MockUtil.genIntMatrix("[[1,2],[3,4]]");
		System.out.println(Arrays.toString(matrix));
	}
}
