package com.classicmodels.pojo.java16records;

import java.util.List;

public record RecordManager(Long managerId, String managerName, List<RecordOffice> offices) {}