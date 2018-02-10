package com.aamir.game.util;

import com.aamir.game.exception.ResourceNotFoundException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public final class FileUtil {

	public static List<String> readData(String fileName) throws ResourceNotFoundException {
		InputStream inputStream = FileUtil.class.getClassLoader().getResourceAsStream(fileName);
		if (inputStream == null) {
			throw new ResourceNotFoundException(String.format("%s file not found", fileName));
		}
		List<String> list = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
			list = br.lines().skip(1).collect(Collectors.toList());
		} catch (IOException e) {
			throw new ResourceNotFoundException(e.getMessage(), e);
		}
		return list;
	}
}
