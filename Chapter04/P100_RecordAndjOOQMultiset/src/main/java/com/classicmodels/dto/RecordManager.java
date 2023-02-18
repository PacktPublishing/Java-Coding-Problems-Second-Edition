package com.classicmodels.dto;

import java.util.List;

public record RecordManager(Long managerId, String managerName, List<RecordOffice> offices) {}