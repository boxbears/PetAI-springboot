package com.petaiprogram.config;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class QuestionMatcher {
    private static final float SIMILARITY_THRESHOLD = 0.80F; // 相似度阈值
    private HashMap<Integer,String> questions=null;// 已存在的问题集合

    public QuestionMatcher(HashMap<Integer,String> questions) {
        this.questions = questions;
    }

    public int match(String question) {
        int flag=-1;
        String bestMatch = null;
        float bestSimilarity = 0.00F;
        for (Map.Entry<Integer,String>  entry : questions.entrySet()) {
            int index=entry.getKey();
            String existingQuestion=entry.getValue();
            float similarity = calculateJaccardSimilarity(existingQuestion, question);
            if (similarity >= SIMILARITY_THRESHOLD && similarity > bestSimilarity) {
                bestMatch = existingQuestion;
                bestSimilarity = similarity;
                flag=index;
            }
            System.out.println(similarity);
        }
        System.out.println("找到的相似问题为："+bestMatch);
        return flag;
    }

    private float calculateJaccardSimilarity(String s1, String s2) {
        Set<Character> union = new HashSet<>();
        Set<Character> union2 = new HashSet<>();
        Set<Character> intersection = new HashSet<>();
        for (char c : s1.toCharArray()) {
            union.add(c);
            union2.add(c);
        }
        System.out.println(union2);
        for (char c : s2.toCharArray()) {
            if (!union2.add(c)) {
                intersection.add(c);
            }
        }
        System.out.println("2"+union2+"1"+union);
        System.out.println(intersection.size()+"和"+union.size());
        return (float) intersection.size() / (float) union.size();
    }
}
