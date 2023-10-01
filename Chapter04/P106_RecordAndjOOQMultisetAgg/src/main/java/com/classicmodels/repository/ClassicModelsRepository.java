package com.classicmodels.repository;

import com.classicmodels.dto.RecordManager;
import com.classicmodels.dto.RecordOffice;
import com.classicmodels.dto.RecordProduct;
import com.classicmodels.dto.RecordProductLine;
import java.util.List;
import static jooq.generated.tables.Manager.MANAGER;
import static jooq.generated.tables.Office.OFFICE;
import static jooq.generated.tables.OfficeHasManager.OFFICE_HAS_MANAGER;
import static jooq.generated.tables.Product.PRODUCT;
import static jooq.generated.tables.Productline.PRODUCTLINE;
import org.jooq.DSLContext;
import static org.jooq.Records.mapping;
import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.lateral;
import static org.jooq.impl.DSL.multisetAgg;
import static org.jooq.impl.DSL.name;
import static org.jooq.impl.DSL.select;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public class ClassicModelsRepository {

    private final DSLContext ctx;

    public ClassicModelsRepository(DSLContext ctx) {
        this.ctx = ctx;
    }
    
    public void oneToMany() {
       
        List<RecordProductLine> resultRecord = ctx.select(
                PRODUCTLINE.PRODUCT_LINE, PRODUCTLINE.TEXT_DESCRIPTION,
                multisetAgg(PRODUCT.PRODUCT_NAME, PRODUCT.PRODUCT_VENDOR,
                        PRODUCT.QUANTITY_IN_STOCK)
                        .as("products").convertFrom(r -> r.map(mapping(RecordProduct::new))))
                .from(PRODUCTLINE)
                .join(PRODUCT)
                .on(PRODUCTLINE.PRODUCT_LINE.eq(PRODUCT.PRODUCT_LINE))
                .groupBy(PRODUCTLINE.PRODUCT_LINE, PRODUCTLINE.TEXT_DESCRIPTION)
                .orderBy(PRODUCTLINE.PRODUCT_LINE)
                .fetch(mapping(RecordProductLine::new));

        System.out.println("One-to-many (Record):\n" + resultRecord);
    }

    public void manyToMany() {
        
        List<RecordManager> resultRecord = ctx.select(
                MANAGER.MANAGER_ID, MANAGER.MANAGER_NAME,
                multisetAgg(
                        field(name("t", "officeCode"), String.class), 
                        field(name("t", "city"), String.class), 
                        field(name("t", "state"), String.class))
                        .as("offices").convertFrom(r -> r.map(mapping(RecordOffice::new))))
                .from(MANAGER, lateral(select(OFFICE.OFFICE_CODE.as("officeCode"),
                        OFFICE.CITY.as("city"), OFFICE.STATE.as("state"))
                        .from(OFFICE).join(OFFICE_HAS_MANAGER)
                        .on(OFFICE.OFFICE_CODE.eq(OFFICE_HAS_MANAGER.OFFICES_OFFICE_CODE))
                        .where(MANAGER.MANAGER_ID.eq(OFFICE_HAS_MANAGER.MANAGERS_MANAGER_ID))).asTable("t"))
                .groupBy(MANAGER.MANAGER_ID)
                .orderBy(MANAGER.MANAGER_ID)
                .fetch(mapping(RecordManager::new));

        System.out.println("Many-to-many (Record):\n" + resultRecord);
    }
}
