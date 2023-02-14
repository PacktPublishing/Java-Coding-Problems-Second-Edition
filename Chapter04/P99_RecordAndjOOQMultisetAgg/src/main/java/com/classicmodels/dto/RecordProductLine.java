package com.classicmodels.dto;

import java.util.List;

public record RecordProductLine(String productLine, String textDescription, List<RecordProduct> products) {}
