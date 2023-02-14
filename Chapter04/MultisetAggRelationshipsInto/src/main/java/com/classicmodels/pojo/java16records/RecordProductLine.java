package com.classicmodels.pojo.java16records;

import java.util.List;

public record RecordProductLine(String productLine, String textDescription, List<RecordProduct> products) {}
